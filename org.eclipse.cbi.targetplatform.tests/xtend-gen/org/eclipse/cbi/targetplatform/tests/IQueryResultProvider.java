/**
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.eclipse.cbi.targetplatform.tests;

import java.net.URI;
import java.util.List;

@SuppressWarnings("all")
public interface IQueryResultProvider<T extends Object> {
  public abstract List<T> listIUs(final URI location);
}
