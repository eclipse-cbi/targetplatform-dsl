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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.xml.sax.SAXException;

import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformFactory;

public class B3AggrTargetPlatformResourceImpl extends ResourceImpl {

	public B3AggrTargetPlatformResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		getContents().clear();
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = saxFactory.newSAXParser();
			B3AggrSaxHandler saxHandler = new B3AggrSaxHandler();
			parser.parse(inputStream, saxHandler);
			TargetPlatform b3aggrTP = TargetPlatformFactory.eINSTANCE
					.createTargetPlatform();
			b3aggrTP.setName(getURI().toString());
			Collection<Location> locations = saxHandler.getLocations();
			b3aggrTP.getContents().addAll(locations);
			getContents().add(b3aggrTP);
		} catch (ParserConfigurationException e) {
			
			 this.getErrors().add(new ExceptionDiagnostic(e));
		} catch (SAXException e) {
			 this.getErrors().add(new ExceptionDiagnostic(e));
		}
	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		/*
		 * we are not able to save here.
		 */
	}

}
