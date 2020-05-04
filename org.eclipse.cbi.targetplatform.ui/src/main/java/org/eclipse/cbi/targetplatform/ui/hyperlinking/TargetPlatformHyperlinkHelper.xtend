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
package org.eclipse.cbi.targetplatform.ui.hyperlinking

import org.eclipse.cbi.targetplatform.model.IncludeDeclaration
import org.eclipse.jface.text.Region
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor

import static org.eclipse.cbi.targetplatform.model.TargetPlatformPackage.Literals.INCLUDE_DECLARATION__IMPORT_URI

import static extension org.eclipse.emf.common.util.URI.createURI
import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.findNodesForFeature

/**
 * @author miklossy - Initial contribution and API
 */
class TargetPlatformHyperlinkHelper extends HyperlinkHelper {

	override createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		super.createHyperlinksByOffset(resource, offset, acceptor)

		val it = getEObjectAtOffsetHelper.resolveElementAt(resource, offset)
		if (it instanceof IncludeDeclaration) {
			val hyperlink = hyperlinkProvider.get

			hyperlink.hyperlinkRegion = hyperlinkRegion
			hyperlink.URI = importURI.createURI.resolve(resource.URI)

			acceptor.accept(hyperlink)
		}
	}

	private def getHyperlinkRegion(IncludeDeclaration includeDeclaration) {
		val nodes = includeDeclaration.findNodesForFeature(INCLUDE_DECLARATION__IMPORT_URI)

		if (nodes.size != 1) {
			throw new IllegalStateException("Exact 1 node is expected for the feature, but got " + nodes.size + " node(s).")
		}

		val it = nodes.head.textRegion

		// trimming the quotes
		new Region(offset + 1, length - 2)
	}

}