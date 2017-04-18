/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package fr.obeo.releng.targetplatform.conversion;

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
