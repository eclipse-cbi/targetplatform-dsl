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
 *     Mikael Barbero (Obeo) - initial API and implementation
 */
package org.eclipse.cbi.targetplatform.conversion;

import org.eclipse.xtext.conversion.impl.IDValueConverter;
import org.eclipse.xtext.nodemodel.INode;

public class TargetPlatformIDValueConverter extends IDValueConverter {

	@Override
	public String toValue(String string, INode node) {
		if (string == null)
			return null;
		return (string.startsWith("^") ? string.substring(1) : string).replaceAll("\\^", "");
	}
}
