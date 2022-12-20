/**
 * Copyright (c) 2012-2014 Obeo and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Hannes Niederhausen (itemis AG) - initial API and implementation
 */
package org.eclipse.cbi.targetplatform.resolved;

import org.eclipse.cbi.targetplatform.model.MavenDependency;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;

/**
 * This class is just a wrapper for the DSLs model to emulate the behavior of {@link ResolvedLocation} etc.
 * 
 * In future we could implement a resolve mechanism to check if the artifact relly exists.
 *
 */
public class ResolvedMavenArtifact {

	private final MavenDependency mavenArtifact;
	private final String type;

	private String groupId;
	private String artifactId;
	private String version;
	private String classifier;

	public ResolvedMavenArtifact(MavenDependency mavenArtifact) {
		super();
		this.mavenArtifact = mavenArtifact;
		type = mavenArtifact.getType();
	}

	public String getGroupId() {
		return groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public String getVersion() {
		return version;
	}

	public String getClassifier() {
		return classifier;
	}

	public String getType() {
		return type;
	}

	public boolean hasClassifier() {
		return classifier!=null;
	}
	
	public Diagnostic resolve(SubMonitor subMonitor) {
		groupId = mavenArtifact.getGroupId();
		artifactId = mavenArtifact.getArtifactId();
		version = mavenArtifact.getVersion();
		classifier = mavenArtifact.getClassifier();

		return new BasicDiagnostic();
	}

}
