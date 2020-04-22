/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tamas Miklossy (itemis AG) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.tests

import com.google.inject.Inject
import org.eclipse.cbi.targetplatform.tests.util.CustomTargetPlatformInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.FormatterTestHelper
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(CustomTargetPlatformInjectorProvider)
class FormatterTest {

	@Inject extension FormatterTestHelper

	@Test def testName001() {
		'''target"2020-03"'''.isFormattedTo('''target "2020-03"''')
	}

	@Test def testName002() {
		'''target "2020-03"'''.isFormattedTo('''target "2020-03"''')
	}

	@Test def testName003() {
		'''target  "2020-03"'''.isFormattedTo('''target "2020-03"''')
	}

	@Test def testName004() {
		'''
		target
		"2020-03"
		'''.isFormattedTo('''target "2020-03"''')
	}

	@Test def testName005() {
		'''
		target
		
		"2020-03"
		'''.isFormattedTo('''target "2020-03"''')
	}

	@Test def testName006() {
		'''
		target
		
		
		"2020-03"
		'''.isFormattedTo('''target "2020-03"''')
	}

	@Test def testOptions001() {
		'''target "2020-03" with source'''.isFormattedTo('''target "2020-03" with source''')
	}

	@Test def testOptions002() {
		'''target "2020-03"  with source'''.isFormattedTo('''target "2020-03" with source''')
	}

	@Test def testOptions003() {
		'''
		target "2020-03"
		with source'''.isFormattedTo('''target "2020-03" with source''')
	}

	@Test def testOptions004() {
		'''
		target "2020-03"
		
		with source'''.isFormattedTo('''target "2020-03" with source''')
	}

	@Test def testOptions005() {
		'''
		target "2020-03" with  source'''.isFormattedTo('''target "2020-03" with source''')
	}

	@Test def testOptions006() {
		'''
		target "2020-03" with  source '''.isFormattedTo('''target "2020-03" with source''')
	}

	@Test def testOptions007() {
		'''
		target "2020-03" with  source  '''.isFormattedTo('''target "2020-03" with source''')
	}

	@Test def testOptions008() {
		'''
		target "2020-03" with source requirements'''.isFormattedTo('''target "2020-03" with source requirements''')
	}

	@Test def testOptions009() {
		'''
		target "2020-03" with source  requirements'''.isFormattedTo('''target "2020-03" with source requirements''')
	}

	@Test def testOptions010() {
		'''
		target "2020-03" with  source  requirements'''.isFormattedTo('''target "2020-03" with source requirements''')
	}

	@Test def testOptions011() {
		'''
		target "2020-03" with  source  requirements '''.isFormattedTo('''target "2020-03" with source requirements''')
	}

	@Test def testOptions012() {
		'''
		target "2020-03" with
		source
		requirements
		'''.isFormattedTo('''target "2020-03" with source requirements''')
	}

	@Test def testOptions013() {
		'''target "2020-03" with source,requirements'''.isFormattedTo('''target "2020-03" with source, requirements''')
	}

	@Test def testOptions014() {
		'''target "2020-03" with source ,requirements'''.isFormattedTo('''target "2020-03" with source, requirements''')
	}

	@Test def testOptions015() {
		'''target "2020-03" with source, requirements'''.isFormattedTo('''target "2020-03" with source, requirements''')
	}

	@Test def testOptions016() {
		'''target "2020-03" with source , requirements'''.isFormattedTo('''target "2020-03" with source, requirements''')
	}

	@Test def testOptions017() {
		'''target "2020-03" with source  ,requirements'''.isFormattedTo('''target "2020-03" with source, requirements''')
	}

	@Test def testOptions018() {
		'''target "2020-03" with source  ,  requirements'''.isFormattedTo('''target "2020-03" with source, requirements''')
	}

	@Test def testOptions019() {
		'''target "2020-03" with source requirements configurePhase'''.isFormattedTo('''target "2020-03" with source requirements configurePhase''')
	}

	@Test def testOptions021() {
		'''target "2020-03" with  source   requirements   configurePhase'''.isFormattedTo('''target "2020-03" with source requirements configurePhase''')
	}

	@Test def testOptions022() {
		'''target "2020-03" with source, requirements, configurePhase'''.isFormattedTo('''target "2020-03" with source, requirements, configurePhase''')
	}

	@Test def testOptions023() {
		'''target "2020-03" with source ,requirements  ,    configurePhase'''.isFormattedTo('''target "2020-03" with source, requirements, configurePhase''')
	}

	@Test def testOptions024() {
		'''target "2020-03" with source ,requirements      configurePhase   '''.isFormattedTo('''target "2020-03" with source, requirements configurePhase''')
	}

	@Test def testEnvironment001() {
		'''target "2020-03"environment WIN32'''.isFormattedTo('''target "2020-03" environment WIN32''')
	}

	@Test def testEnvironment002() {
		'''target "2020-03" environment WIN32'''.isFormattedTo('''target "2020-03" environment WIN32''')
	}

	@Test def testEnvironment003() {
		'''target "2020-03"  environment WIN32'''.isFormattedTo('''target "2020-03" environment WIN32''')
	}

	@Test def testEnvironment004() {
		'''
		target "2020-03"
		environment WIN32'''.isFormattedTo('''target "2020-03" environment WIN32''')
	}

	@Test def testEnvironment005() {
		'''
		target "2020-03" environment  WIN32'''.isFormattedTo('''target "2020-03" environment WIN32''')
	}

	@Test def testEnvironment006() {
		'''
		target "2020-03" environment  WIN32 '''.isFormattedTo('''target "2020-03" environment WIN32''')
	}

	@Test def testEnvironment007() {
		'''
		target "2020-03" environment  WIN32   '''.isFormattedTo('''target "2020-03" environment WIN32''')
	}

	@Test def testEnvironment008() {
		'''
		target "2020-03" environment  WIN32
		
		'''.isFormattedTo('''target "2020-03" environment WIN32''')
	}

	@Test def testEnvironment009() {
		'''target "2020-03"environment WIN32 JavaSE-1.8'''.isFormattedTo('''target "2020-03" environment WIN32 JavaSE-1.8''')
	}

	@Test def testEnvironment010() {
		'''target "2020-03"environment WIN32  JavaSE-1.8'''.isFormattedTo('''target "2020-03" environment WIN32 JavaSE-1.8''')
	}

	@Test def testEnvironment011() {
		'''
		target "2020-03"environment WIN32
		JavaSE-1.8'''.isFormattedTo('''target "2020-03" environment WIN32 JavaSE-1.8''')
	}

	@Test def testEnvironment012() {
		'''target "2020-03"environment WIN32,JavaSE-1.8'''.isFormattedTo('''target "2020-03" environment WIN32, JavaSE-1.8''')
	}

	@Test def testEnvironment013() {
		'''target "2020-03"environment WIN32 ,JavaSE-1.8'''.isFormattedTo('''target "2020-03" environment WIN32, JavaSE-1.8''')
	}

	@Test def testEnvironment014() {
		'''target "2020-03"environment WIN32, JavaSE-1.8'''.isFormattedTo('''target "2020-03" environment WIN32, JavaSE-1.8''')
	}

	@Test def testEnvironment015() {
		'''target "2020-03"environment WIN32 , JavaSE-1.8'''.isFormattedTo('''target "2020-03" environment WIN32, JavaSE-1.8''')
	}

	@Test def testEnvironment016() {
		'''target "2020-03"environment WIN32  ,  JavaSE-1.8'''.isFormattedTo('''target "2020-03" environment WIN32, JavaSE-1.8''')
	}

	@Test def testOptionsAndEnvironment001() {
		'''target "2020-03" with source environment WIN32'''.isFormattedTo('''target "2020-03" with source environment WIN32''')
	}

	@Test def testOptionsAndEnvironment002() {
		'''target "2020-03" with source, requirements environment WIN32, JavaSE-1.8'''.isFormattedTo('''target "2020-03" with source, requirements environment WIN32, JavaSE-1.8''')
	}

	@Test def testOptionsAndEnvironment003() {
		'''
		target "2020-03"
		with source, requirements
		environment WIN32, JavaSE-1.8'''.isFormattedTo('''target "2020-03" with source, requirements environment WIN32, JavaSE-1.8''')
	}

	@Test def testIncludeDeclaration001() {
		'''
			target "2020-03" include "includedFile.tpd"
		'''.isFormattedTo('''
			target "2020-03"
			
			include "includedFile.tpd"
		''')
	}

	@Test def testIncludeDeclaration002() {
		'''
			target "2020-03"
			
			include "includedFile.tpd"
		'''.isFormattedTo('''
			target "2020-03"
			
			include "includedFile.tpd"
		''')
	}

	@Test def testIncludeDeclaration003() {
		'''
			target "2020-03"
			
			include "includedFile1.tpd" include "includedFile2.tpd"
		'''.isFormattedTo('''
			target "2020-03"
			
			include "includedFile1.tpd"
			include "includedFile2.tpd"
		''')
	}

	@Test def testIncludeDeclaration004() {
		'''
			target "2020-03"

			include "includedFile1.tpd"

			include "includedFile2.tpd"
		'''.isFormattedTo('''
			target "2020-03"

			include "includedFile1.tpd"
			include "includedFile2.tpd"
		''')
	}

	@Test def testIncludeDeclaration005() {
		'''
			target "2020-03"

			include"includedFile1.tpd"
		'''.isFormattedTo('''
			target "2020-03"
			
			include "includedFile1.tpd"
		''')
	}

	@Test def testIncludeDeclaration006() {
		'''
			target "2020-03"

			include"includedFile1.tpd" 
			include  "includedFile2.tpd"
		'''.isFormattedTo('''
			target "2020-03"
			
			include "includedFile1.tpd"
			include "includedFile2.tpd"
		''')
	}

	@Test def testIncludeDeclaration007() {
		'''
			target "2020-03"

			include  "includedFile1.tpd"
		'''.isFormattedTo('''
			target "2020-03"
			
			include "includedFile1.tpd"
		''')
	}

	@Test def testIncludeDeclaration008() {
		'''
			target "2020-03"

			include
			"includedFile1.tpd"
		'''.isFormattedTo('''
			target "2020-03"
			
			include "includedFile1.tpd"
		''')
	}

	@Test def testLocation001() {
		'''
			target "2020-03" location "https://download.eclipse.org/releases/2019-03"
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03"
		''')
	}

	@Test def testLocation002() {
		'''
			target "2020-03" location "https://download.eclipse.org/releases/2019-03" location "https://download.eclipse.org/releases/2019-06"
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03"
			
			location "https://download.eclipse.org/releases/2019-06"
		''')
	}

	@Test def testLocation003() {
		'''
			target "2020-03"
			
			location"https://download.eclipse.org/releases/2019-03"
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03"
		''')
	}

	@Test def testLocation004() {
		'''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03"
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03"
		''')
	}

	@Test def testLocation005() {
		'''
			target "2020-03"
			
			location  "https://download.eclipse.org/releases/2019-03"
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03"
		''')
	}

	@Test def testLocation006() {
		'''
			target "2020-03"
			
			location
			"https://download.eclipse.org/releases/2019-03"
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03"
		''')
	}

	@Test def testLocation007() {
		'''
			target "2020-03"
			
			location eclipse "https://download.eclipse.org/releases/2019-03"
		'''.isFormattedTo('''
			target "2020-03"
			
			location eclipse "https://download.eclipse.org/releases/2019-03"
		''')
	}

	@Test def testLocation008() {
		'''
			target "2020-03"
			
			location  eclipse "https://download.eclipse.org/releases/2019-03"
		'''.isFormattedTo('''
			target "2020-03"
			
			location eclipse "https://download.eclipse.org/releases/2019-03"
		''')
	}

	@Test def testLocation009() {
		'''
			target "2020-03"
			
			location eclipse  "https://download.eclipse.org/releases/2019-03"
		'''.isFormattedTo('''
			target "2020-03"
			
			location eclipse "https://download.eclipse.org/releases/2019-03"
		''')
	}

	@Test def testLocation010() {
		'''
			target "2020-03"
			
			location  eclipse  "https://download.eclipse.org/releases/2019-03"
		'''.isFormattedTo('''
			target "2020-03"
			
			location eclipse "https://download.eclipse.org/releases/2019-03"
		''')
	}

	@Test def testLocation011() {
		'''
			target "2020-03"
			
			location
			eclipse
			"https://download.eclipse.org/releases/2019-03"
		'''.isFormattedTo('''
			target "2020-03"
			
			location eclipse "https://download.eclipse.org/releases/2019-03"
		''')
	}

	@Test def testLocation012() {
		'''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03"   {}
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
			}
		''')
	}

	@Test def testIU001() {
		'''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {org.eclipse.sdk.ide}
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide
			}
		''')
	}

	@Test def testIU002() {
		'''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
			org.eclipse.sdk.ide
			}
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide
			}
		''')
	}

	@Test def testIU003() {
		'''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				
				org.eclipse.sdk.ide
			}
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide
			}
		''')
	}

	@Test def testIU004() {
		'''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide}
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide
			}
		''')
	}

	@Test def testIU005() {
		'''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide
			
			}
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide
			}
		''')
	}

	@Test def testIU006() {
		'''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
			org.eclipse.sdk.ide
			org.eclipse.xtext.sdk.feature.group
			}
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide
				org.eclipse.xtext.sdk.feature.group
			}
		''')
	}

	@Test def testIU007() {
		'''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
			org.eclipse.sdk.ide org.eclipse.xtext.sdk.feature.group
			}
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide
				org.eclipse.xtext.sdk.feature.group
			}
		''')
	}

	@Test def testIU008() {
		'''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide  
			}
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide
			}
		''')
	}

	@Test def testIU009() {
		'''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide  4.11.0
			}
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide 4.11.0
			}
		''')
	}

	@Test def testIU010() {
		'''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide
				4.11.0
			}
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide 4.11.0
			}
		''')
	}

	@Test def testIU011() {
		'''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide      4.11.0     
			}
		'''.isFormattedTo('''
			target "2020-03"
			
			location "https://download.eclipse.org/releases/2019-03" {
				org.eclipse.sdk.ide 4.11.0
			}
		''')
	}

	@Test def testComments001() {
		'''
			target "2020-03"
			
			// single comment belonging to the location
			location "https://download.eclipse.org/releases/2019-03" {
			// some single line comment belonging to the installable unit
				org.eclipse.sdk.ide
			}
		'''.isFormattedTo('''
			target "2020-03"

			// single comment belonging to the location
			location "https://download.eclipse.org/releases/2019-03" {
				// some single line comment belonging to the installable unit
				org.eclipse.sdk.ide
			}
		''')
	}

	@Test def testComments002() {
		'''
			target "2020-03"
			
			// single comment belonging to the location
			location "https://download.eclipse.org/releases/2019-03" {
				// some single line comment belonging to the installable unit
			org.eclipse.sdk.ide
			}
		'''.isFormattedTo('''
			target "2020-03"
			
			// single comment belonging to the location
			location "https://download.eclipse.org/releases/2019-03" {
				// some single line comment belonging to the installable unit
				org.eclipse.sdk.ide
			}
		''')
	}

	@Test def testComments003() {
		'''
			target "2020-03"
			
				// single comment belonging to the location
			location "https://download.eclipse.org/releases/2019-03" {
					// some single line comment belonging to the installable unit
			org.eclipse.sdk.ide
			}
		'''.isFormattedTo('''
			target "2020-03"
			
			// single comment belonging to the location
			location "https://download.eclipse.org/releases/2019-03" {
				// some single line comment belonging to the installable unit
				org.eclipse.sdk.ide
			}
		''')
	}

	@Test def testComments004() {
		'''
			target "2020-03"
			
			// single comment belonging to the location
			location "https://download.eclipse.org/releases/2019-03" {
			// comment1
			org.eclipse.sdk.ide
			// comment2
			org.eclipse.xtext.sdk.feature.group
			}
		'''.isFormattedTo('''
			target "2020-03"
			
			// single comment belonging to the location
			location "https://download.eclipse.org/releases/2019-03" {
				// comment1
				org.eclipse.sdk.ide
				// comment2
				org.eclipse.xtext.sdk.feature.group
			}
		''')
	}

	@Test def testComments005() {
		'''
			target "2020-03"
			
			 // single comment belonging to the location
			location "https://download.eclipse.org/releases/2019-03" {
			 // comment1
			org.eclipse.sdk.ide
			}
		'''.isFormattedTo('''
			target "2020-03"
			
			// single comment belonging to the location
			location "https://download.eclipse.org/releases/2019-03" {
				// comment1
				org.eclipse.sdk.ide
			}
		''')
	}

	private def isFormattedTo(CharSequence actual, CharSequence expected) {
		assertFormatted[
			toBeFormatted = actual
			expectation = expected
		]
	}
}