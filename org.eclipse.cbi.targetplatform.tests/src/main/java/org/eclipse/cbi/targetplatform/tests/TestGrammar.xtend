/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *     Denis Golovin - Fix version qualifier parsing problems
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.tests

import com.google.inject.Inject
import java.util.Locale
import org.eclipse.cbi.targetplatform.model.Environment
import org.eclipse.cbi.targetplatform.model.Option
import org.eclipse.cbi.targetplatform.model.TargetPlatform
import org.eclipse.cbi.targetplatform.tests.util.CustomTargetPlatformInjectorProvider
import org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(CustomTargetPlatformInjectorProvider)
class TestGrammar {
	
	@Inject
	ParseHelper<TargetPlatform> parser
	
	@Inject
	IExecutionEnvironmentsManager eeManager;
	
	@Test
	def testEmpty() {
		val targetPlatform = parser.parse("")
		assertNull(targetPlatform)
	}
	
	@Test
	def testStandardFile() {
		val targetPlatform = parser.parse('''
			target "Latest target for EMF Compare based on Kepler interim"

			location "https://hudson.eclipse.org/hudson/view/Modeling/job/emf-core-head/lastSuccessfulBuild/artifact/EMF.p2.repository/" {
				org.eclipse.emf.sdk.feature.group;version="[2.9.0,3.0.0)"
				com.google.common.cache;version="10.0.1"
			}
			
			location "https://hudson.eclipse.org/hudson/view/Modeling/job/mdt-uml2-master/lastSuccessfulBuild/artifact/UML2.p2.repository/" {
				org.eclipse.uml2.sdk.feature.group
			}
			
			location "https://hudson.eclipse.org/hudson/view/Modeling/job/mdt-uml2-master/lastSuccessfulBuild/artifact/UML2.p2.repository/" {
				org.eclipse.uml2.sdk.feature.group;version=10.1.1.20141228-2310-BUILD1 
			}
			
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		assertEquals("https://hudson.eclipse.org/hudson/view/Modeling/job/emf-core-head/lastSuccessfulBuild/artifact/EMF.p2.repository/", fisrtLocation.uri)
		assertEquals(2, fisrtLocation.ius.size)
		val iu0 = fisrtLocation.ius.head
		assertEquals("org.eclipse.emf.sdk.feature.group", iu0.ID)
		assertEquals("[2.9.0,3.0.0)", iu0.version)
		
		val iu1 = fisrtLocation.getIus().last
		assertEquals("com.google.common.cache", iu1.getID)
		assertEquals("10.0.1", iu1.version)
		
		val lastLocation = targetPlatform.locations.last
		assertEquals("https://hudson.eclipse.org/hudson/view/Modeling/job/mdt-uml2-master/lastSuccessfulBuild/artifact/UML2.p2.repository/", lastLocation.uri)
		assertEquals(1, lastLocation.ius.size)
		val uml2iu = lastLocation.ius.head
		assertEquals("org.eclipse.uml2.sdk.feature.group", uml2iu.ID)
		assertEquals("10.1.1.20141228-2310-BUILD1", uml2iu.version)
	}
	
	@Test
	def testOption() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				with source, allEnvironments, requirements, configurePhase
				org.eclipse.emf.sdk.feature.group;version="[2.9.0,3.0.0)"
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		assertTrue(fisrtLocation.options.contains(Option::INCLUDE_SOURCE))
		assertTrue(fisrtLocation.options.contains(Option::INCLUDE_ALL_ENVIRONMENTS))
		assertTrue(fisrtLocation.options.contains(Option::INCLUDE_REQUIRED))
		assertTrue(fisrtLocation.options.contains(Option::INCLUDE_CONFIGURE_PHASE))
	}
	
	@Test
	def testIdWithSpaceInIt() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				my. iu
			}
		''')
		assertFalse(targetPlatform.eResource.errors.empty)
	}
	
	@Test
	def testIdWithSpaceInIt2() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				my .iu
			}
		''')
		assertFalse(targetPlatform.eResource.errors.empty)
	}
	
	@Test
	def testIdWithDash() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				my.iu.with-dash
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		val iu0 = fisrtLocation.ius.head
		assertEquals("my.iu.with-dash", iu0.ID)
	}
	
	@Test
	def testIdWithVersionNonString() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				my.iu;version=3
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		val iu0 = fisrtLocation.ius.head
		assertEquals("my.iu", iu0.ID)
		assertEquals("3.0.0", iu0.version)
	}
	
	@Test
	def testIdWithVersionNonString2() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				myu;version=3.2.1
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		val iu0 = fisrtLocation.ius.head
		assertEquals("myu", iu0.ID)
		assertEquals("3.2.1", iu0.version)
	}
	
	@Test
	def testIdWithVersionNonString3() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				myu;version=[3.2.1,10.0)
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		val iu0 = fisrtLocation.ius.head
		assertEquals("myu", iu0.ID)
		assertEquals("[3.2.1,10.0.0)", iu0.version)
	}
	
	@Test
	def testIdWithVersionNonString4() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				myu;version=[ 3 , 5 )
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		val iu0 = fisrtLocation.ius.head
		assertEquals("myu", iu0.ID)
		assertEquals("[3.0.0,5.0.0)", iu0.version)
	}

	@Test
	def testIUWithIntQualifier() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				myu;version=1.2.3.201404071200
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		val iu0 = fisrtLocation.ius.head
		assertEquals("myu", iu0.ID)
		assertEquals("1.2.3.201404071200", iu0.version)
	}
	
	@Test
	def testWithKeywordInIUID1() {
		val tp = parser.parse('''
			target "TP1"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava
				com.google.guava.^source
			}
		''')
		
		assertEquals("TP1", tp.name)
		assertEquals(2, tp.locations.map[ius].flatten.size)
		
		val ids = tp.locations.map[ius.map[ID]].flatten
		assertEquals(2, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("com.google.guava.source", ids.get(1))
	}
	
	@Test
	def testWithKeywordInIUID2() {
		val tp = parser.parse('''
			target "TP1"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava
				com.google.guava.source
			}
		''')
		
		assertEquals("TP1", tp.name)
		assertEquals(2, tp.locations.map[ius].flatten.size)
		
		val ids = tp.locations.map[ius.map[ID]].flatten
		assertEquals(2, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("com.google.guava.source", ids.get(1))
	}
	
	@Test
	def testWithEnvironment1() {
		val tp = parser.parse('''
			target "TP1"
			
			environment win32 x86_64 win32 en_US JavaSE-1.7
		''')
		assertTrue(tp.eResource.errors.join("\n"), tp.eResource.errors.empty)
		val env = tp.contents.filter(typeof (Environment)).head
		assertEquals("win32", env.operatingSystem)
		assertEquals("x86_64", env.architecture)
		assertEquals("win32", env.windowingSystem)
		assertEquals(new Locale("en", "us"), env.localization)
		assertEquals(eeManager.getEnvironment("JavaSE-1.7"), env.executionEnvironment)
	}
	
	@Test
	def testWithEnvironment2() {
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment win32 
			environment win32
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		assertTrue(targetPlatform.eResource.errors.empty)
		assertEquals("win32", targetPlatform.environment.operatingSystem)
		assertEquals("win32", targetPlatform.environment.windowingSystem)
		
		assertEquals("win32", (targetPlatform.contents.get(0) as Environment).operatingSystem)
		assertEquals("win32", (targetPlatform.contents.get(0) as Environment).windowingSystem)
		assertEquals("win32", (targetPlatform.contents.get(1) as Environment).windowingSystem)
		assertEquals("win32", (targetPlatform.contents.get(1) as Environment).operatingSystem)
	}
	
	@Test
	def testWithEnvironment5() {
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment win32 linux
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		assertTrue(targetPlatform.eResource.errors.empty)
		assertEquals("linux", targetPlatform.environment.operatingSystem)
		assertEquals("win32", targetPlatform.environment.windowingSystem)
	}
	
	@Test
	def testWithEnvironment6() {
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment win32 cocoa
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		assertTrue(targetPlatform.eResource.errors.empty)
		assertEquals("win32", targetPlatform.environment.operatingSystem)
		assertEquals("cocoa", targetPlatform.environment.windowingSystem)
	}
	
	@Test
	def testWithEnvironment7() {
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment linux win32
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		assertTrue(targetPlatform.eResource.errors.empty)
		assertEquals("linux", targetPlatform.environment.operatingSystem)
		assertEquals("win32", targetPlatform.environment.windowingSystem)
	}
	
	@Test
	def testWithEnvironment8() {
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment cocoa win32
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		assertTrue(targetPlatform.eResource.errors.empty)
		assertEquals("win32", targetPlatform.environment.operatingSystem)
		assertEquals("cocoa", targetPlatform.environment.windowingSystem)
	}
	
	@Test
	def testVersionWithoutKeywords1() {
		val targetPlatform = parser.parse('''
			target "TP1"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava 1.2.0
			}
		''')
		
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val ids = targetPlatform.locations.map[ius.map[ID]].flatten
		val versions = targetPlatform.locations.map[ius.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("1.2.0", versions.head)
	}
	
	@Test
	def testVersionWithoutKeywords2() {
		val targetPlatform = parser.parse('''
			target "TP1"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava [1.2.0 , 2.4.54)
			}
		''')
		
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val ids = targetPlatform.locations.map[ius.map[ID]].flatten
		val versions = targetPlatform.locations.map[ius.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("[1.2.0,2.4.54)", versions.head)
	}
	
	@Test
	def testVersionWithoutKeywords3() {
		val targetPlatform = parser.parse('''
			target "TP1"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava [1.2.0 , 2.4.54)
				org.apacahe.commons
			}
		''')
		
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val ids = targetPlatform.locations.map[ius.map[ID]].flatten
		val versions = targetPlatform.locations.map[ius.map[version]].flatten
		assertEquals(2, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("org.apacahe.commons", ids.get(1))
		assertEquals("[1.2.0,2.4.54)", versions.head)
	}
	
	@Test
	def testVersionWithoutKeywords4() {
		val targetPlatform = parser.parse('''
			target "TP1"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava 1.2.0
				org.apacahe.commons
			}
		''')
		
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val ids = targetPlatform.locations.map[ius.map[ID]].flatten
		val versions = targetPlatform.locations.map[ius.map[version]].flatten
		assertEquals(2, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("org.apacahe.commons", ids.get(1))
		assertEquals("1.2.0", versions.head)
	}
}