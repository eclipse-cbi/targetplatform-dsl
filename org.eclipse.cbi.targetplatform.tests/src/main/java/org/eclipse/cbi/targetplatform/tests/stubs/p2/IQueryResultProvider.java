/**
 * Copyright (c) 2012 Obeo and others.
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
package org.eclipse.cbi.targetplatform.tests.stubs.p2;

import java.net.URI;
import java.util.List;

public interface IQueryResultProvider<T> {

	List<T> listIUs(URI location);
	
}
