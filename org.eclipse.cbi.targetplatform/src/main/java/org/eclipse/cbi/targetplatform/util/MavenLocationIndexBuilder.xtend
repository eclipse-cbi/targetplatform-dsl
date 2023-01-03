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

import org.eclipse.cbi.targetplatform.model.MavenLocation

class MavenLocationIndexBuilder extends AbstractLocationIndexBuilder<MavenLocation> {
	override protected getMappingKey(MavenLocation location) {
		return location.label.toLowerCase
	}
	
	override protected isValidLocation(Object location) {
		location instanceof MavenLocation
	}
	
}
