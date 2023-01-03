/**
 * Copyright (c) 2012-2020 Obeo and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 */
package org.eclipse.cbi.targetplatform.util

import org.eclipse.cbi.targetplatform.model.Location
import org.eclipse.emf.common.util.URI

class LocationIndexBuilder extends AbstractLocationIndexBuilder<Location> {
	override protected getMappingKey(Location location) {
		return location.uri.normalizeURI
	}
	
	override protected isValidLocation(Object location) {
		return location instanceof Location
	}
	
	private static def String normalizeURI(String uri) {
		if (uri === null) {
			return null
		}
		val uriValue = URI.createURI(uri)
		if (uriValue.hasTrailingPathSeparator) {
			return uriValue.trimSegments(1).toString
		}
		return uri
	}
}
