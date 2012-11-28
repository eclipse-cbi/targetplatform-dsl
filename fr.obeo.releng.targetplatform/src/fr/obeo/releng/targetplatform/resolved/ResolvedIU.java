/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.obeo.releng.targetplatform.resolved;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.QueryUtil;

public class ResolvedIU {
	
	private final String id;
	private final VersionRange versionRange;
	private final IQuery<IInstallableUnit> query;

	public ResolvedIU(String id, String versionRange) {
		this(id, versionRange == null ? null : new VersionRange(versionRange));
	}
	
	public ResolvedIU(String id, VersionRange versionRange) {
		this.id = id;
		this.versionRange = versionRange;
		this.query = createQuery();
	}

	private IQuery<IInstallableUnit> createQuery() {
		if (this.versionRange == null) {
			return QueryUtil.createQuery("latest(x | x.id == $0)", id);
		} else {
			return QueryUtil.createQuery("latest(x | x.id == $0 && x.version ~= $1)", id, versionRange);
		}
	}
	
	public String getID() {
		return id;
	}
	
	public VersionRange getVersionRange() {
		return versionRange;
	}
	
	public IQuery<IInstallableUnit> getQuery() {
		return query;
	}
}