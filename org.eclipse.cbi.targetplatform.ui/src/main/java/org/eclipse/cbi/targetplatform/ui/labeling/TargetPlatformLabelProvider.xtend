/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.ui.labeling

import com.google.inject.Inject
import org.eclipse.cbi.targetplatform.model.IU
import org.eclipse.cbi.targetplatform.model.IncludeDeclaration
import org.eclipse.cbi.targetplatform.model.Location
import org.eclipse.cbi.targetplatform.model.TargetPlatform
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import org.eclipse.cbi.targetplatform.model.Option
import org.eclipse.cbi.targetplatform.model.Environment
import org.eclipse.cbi.targetplatform.model.Options

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
class TargetPlatformLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	def text(Location object) {
		val ss = new StyledString();
		ss.append(object.getUri());
		if (object.getID() !== null) {
			ss.append(" " + object.getID(), StyledString.DECORATIONS_STYLER);
		}
		ss;
	}
	
	def image(Location object) {
		"obj16/location_obj.gif";
	}
	
	def text(IU object) {
		val ss = new StyledString();
		ss.append(object.getID());
		if (object.getVersion() !== null) {
			ss.append(" " + object.getVersion(), StyledString.COUNTER_STYLER);
		}
		ss;
	}
	
	def image(IU object) {
		"obj16/iu_obj.gif";
	}
	
	def text(TargetPlatform object) {
		object.getName();
	}
	
	def image(TargetPlatform object) {
		"obj16/target_obj.gif";
	}
	
	def image(IncludeDeclaration object) {
		"obj16/inc_obj.gif"
	}
	
	def image(Option object) {
		"obj16/option_obj.gif"
	}
	
	def text(Options object) {
		"Options"
	}
	
	def image(Options object) {
		"obj16/option_obj.gif"
	}
	
	def text(Environment object) {
		"Environment"
	}
	
	def image(Environment object) {
		"obj16/env_obj.gif"
	}
}
