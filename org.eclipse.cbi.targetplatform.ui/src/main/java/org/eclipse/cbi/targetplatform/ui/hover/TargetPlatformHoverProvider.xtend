/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tamas Miklossy (itemis AG) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.ui.hover

import com.google.inject.Inject
import java.net.URI
import java.util.Set
import org.eclipse.cbi.targetplatform.model.IU
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.ecore.EObject
import org.eclipse.equinox.p2.core.IProvisioningAgent
import org.eclipse.equinox.p2.metadata.IInstallableUnit
import org.eclipse.equinox.p2.query.QueryUtil
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider

/**
 * @author miklossy - Initial contribution and API
 */
class TargetPlatformHoverProvider extends DefaultEObjectHoverProvider {

	@Inject extension IProvisioningAgent

	override protected getHoverInfoAsHtml(EObject o) {
		return if (o instanceof IU) {
			o.hoverInfo
		} else {
			super.getHoverInfoAsHtml(o)
		}
	}

	private def String getHoverInfo(IU iu) {
		val repositoryManager = IMetadataRepositoryManager.SERVICE_NAME.service as IMetadataRepositoryManager
		val metadataRepository = repositoryManager.loadRepository(new URI(iu.location.uri), new NullProgressMonitor)
		val idResults = metadataRepository.query(QueryUtil.createIUQuery(iu.ID), new NullProgressMonitor).toUnmodifiableSet
		idResults.hoverInfo
	}

	private def String getHoverInfo(Set<IInstallableUnit> ius) {
		if (ius.isEmpty) {
			'''<b>No information available</b>'''
		} else {
			val name = ius.findFirst[!name.nullOrEmpty]?.name
			val provider = ius.findFirst[!provider.nullOrEmpty]?.provider
			val versions = ius.sortBy[version].reverse.map[version]
			'''
				«IF name !== null»<b>Name:</b> «name»<br>«ENDIF»
				«IF provider !== null»<b>Provider:</b> «provider»<br>«ENDIF»
				«IF versions.size == 1»
					<b>Version:</b> «versions.head»
				«ELSE»
					<b>Versions:</b><br>
					«FOR version : versions SEPARATOR "<br>"»
						«version»
					«ENDFOR»
				«ENDIF»
			'''
		}
	}

	private def getName(IInstallableUnit it) {
		getProperty(IInstallableUnit.PROP_NAME, null)
	}

	private def getProvider(IInstallableUnit it) {
		getProperty(IInstallableUnit.PROP_PROVIDER, null)
	}
}