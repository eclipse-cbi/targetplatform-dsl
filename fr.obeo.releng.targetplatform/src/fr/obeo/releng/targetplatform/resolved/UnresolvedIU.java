/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo.
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
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.QueryUtil;

public class UnresolvedIU {
	
	private static final VersionRange LAZY_RANGE = new VersionRange(Version.create("0.0.0"), true, Version.create(Integer.MAX_VALUE+"."+Integer.MAX_VALUE+"."+Integer.MAX_VALUE), true); 
	private final String id;
	private final VersionRange versionRange;
	private final IQuery<IInstallableUnit> query;

	public UnresolvedIU(String id, String versionRange) {
		if ("lazy".equalsIgnoreCase(versionRange)) {
			this.versionRange = LAZY_RANGE;
		} else {
			this.versionRange = new VersionRange(versionRange);
		}
		this.id = id;
		this.query = createQuery();
	}

	private IQuery<IInstallableUnit> createQuery() {
		if (this.versionRange == null || this.versionRange == LAZY_RANGE) {
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
	
	public boolean isLazyRange() {
		return versionRange == LAZY_RANGE;
	}
	
	public IQuery<IInstallableUnit> getQuery() {
		return query;
	}
}