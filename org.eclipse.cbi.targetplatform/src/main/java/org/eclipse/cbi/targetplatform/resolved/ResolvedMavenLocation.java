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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.cbi.targetplatform.model.GeneratedFeature;
import org.eclipse.cbi.targetplatform.model.MavenDependency;
import org.eclipse.cbi.targetplatform.model.MavenLocation;
import org.eclipse.cbi.targetplatform.model.MavenRepository;
import org.eclipse.cbi.targetplatform.model.MavenScope;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;

public class ResolvedMavenLocation {

	private final MavenLocation dslLocation;
	private List<MavenDependency> unresolvedMavenDependencies;
	private List<ResolvedMavenArtifact> resolvedMavenDependencies;

	public ResolvedMavenLocation(MavenLocation dslLocation) {
		super();
		this.dslLocation = dslLocation;
		unresolvedMavenDependencies = new ArrayList<>(dslLocation.getDependencies());
		resolvedMavenDependencies = new ArrayList<>();
	}

	public String getLabel() {
		return dslLocation.getLabel();
	}

	public GeneratedFeature getGeneratedFeature() {
		return dslLocation.getGeneratedFeature();
	}

	public String getScope() {
		return dslLocation.getScopes().stream().map(MavenScope::getLiteral).collect(Collectors.joining(","));
	}

	public String getIncludeSources() {
		return Boolean.toString(dslLocation.isIncludeSources());
	}

	public String getMissingManifest() {
		return dslLocation.getMissingManifest().getLiteral();
	}

	public String getDependencyDepth() {
		return dslLocation.getDependencyDepth().getLiteral();
	}

	public boolean hasAdditionalRepositories() {
		return !dslLocation.getRepositories().isEmpty();
	}

	public Map<String, String> getRepositoryMap() {
		return dslLocation.getRepositories().stream() //
				.collect(Collectors.toMap(MavenRepository::getId, MavenRepository::getUrl));
	}

	public List<ResolvedMavenArtifact> getMavenDependencies() {
		return this.resolvedMavenDependencies;
	}

	public List<MavenDependency> getUnresolvedMavenDependencies() {
		return unresolvedMavenDependencies;
	}

	public Diagnostic resolve(IProgressMonitor monitor) {
		BasicDiagnostic ret = new BasicDiagnostic();
		SubMonitor subMonitor = SubMonitor.convert(monitor, unresolvedMavenDependencies.size());
		// right now no resolution done - we just transform the dsl artifacts into
		// resolved ones
		Iterator<MavenDependency> it = unresolvedMavenDependencies.iterator();
		while (it.hasNext()) {

			ResolvedMavenArtifact resolvedArtifact = new ResolvedMavenArtifact(it.next());
			Diagnostic diagnostic = resolvedArtifact.resolve(subMonitor);
			if (diagnostic.getSeverity() >= Diagnostic.WARNING) {
				ret.merge(diagnostic);
			}

			resolvedMavenDependencies.add(resolvedArtifact);
			it.remove();
		}

		return ret;
	}
}
