/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.obeo.releng.targetplatform.resource;

import java.util.Collection;
import java.util.Set;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.google.common.collect.Sets;

import fr.obeo.releng.targetplatform.IU;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.TargetPlatformFactory;

public class B3AggrSaxHandler extends DefaultHandler {

	private Stack<Location> locations = new Stack<Location>();

	private Set<Location> popedLocations = Sets.newLinkedHashSet();

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if ("repositories".equals(qName)) {
			String locationURI = attributes.getValue("location");
			if (locationURI != null) {
				Location newLocation = TargetPlatformFactory.eINSTANCE
						.createLocation();
				newLocation.setUri(locationURI);
				locations.push(newLocation);
			}
		} else if (locations.size() > 0
				&& ("features".equals(qName) || "bundles".equals(qName))) {
			String name = attributes.getValue("name");
			String versionRange = attributes.getValue("versionRange");
			if (name != null) {
				IU newIU = TargetPlatformFactory.eINSTANCE.createIU();
				newIU.setID(name);
				locations.peek().getIus().add(newIU);
				if (versionRange != null) {
					newIU.setVersion(versionRange);
				}

			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		if ("repositories".equals(qName) && !locations.isEmpty()) {
			popedLocations.add(locations.pop());
		}
	}

	public Collection<Location> getLocations() {
		return popedLocations;
	}

}
