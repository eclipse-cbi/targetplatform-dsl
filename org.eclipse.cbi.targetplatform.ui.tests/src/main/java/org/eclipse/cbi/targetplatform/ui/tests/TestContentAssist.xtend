/*******************************************************************************
 * Copyright (c) 2012-2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.ui.tests

import com.google.common.collect.ImmutableList
import com.google.inject.Guice
import com.google.inject.Module
import com.google.inject.Provider
import java.net.URI
import java.util.Locale
import javax.inject.Inject
import org.eclipse.cbi.targetplatform.TargetPlatformRuntimeModule
import org.eclipse.cbi.targetplatform.TargetPlatformStandaloneSetup
import org.eclipse.cbi.targetplatform.tests.stubs.p2.IQueryResultProvider
import org.eclipse.cbi.targetplatform.tests.stubs.p2.IUStub
import org.eclipse.cbi.targetplatform.tests.stubs.p2.ProvisioningAgentStub
import org.eclipse.cbi.targetplatform.ui.TargetPlatformUiModule
import org.eclipse.cbi.targetplatform.ui.internal.TargetplatformActivator
import org.eclipse.core.runtime.Platform
import org.eclipse.equinox.p2.core.IProvisioningAgent
import org.eclipse.equinox.p2.metadata.IInstallableUnit
import org.eclipse.equinox.p2.metadata.Version
import org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager
import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.shared.SharedStateModule
import org.eclipse.xtext.util.Modules2
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(TargetPlatformUiInjectorProvider)
class TestContentAssist extends AbstractContentAssistProcessorTest {
	
	static val MOCK_RUNTIME_MODULE = new TargetPlatformRuntimeModule() {
		override provideIProvisioningAgent() {
			return new Provider<IProvisioningAgent>() {
				override IProvisioningAgent get() {
					return new ProvisioningAgentStub(new IQueryResultProvider<IInstallableUnit>() {
						override listIUs(URI location) {
							if ("location1".equals(location.toString)) {
								newImmutableList(
									IUStub::createFeature("org.iu1", Version.createOSGi(1,2,0))
								)
							} else if ("location2".equals(location.toString)) {
								newImmutableList(
									IUStub::createFeature("org.iu1", Version.createOSGi(1,2,0)),
									IUStub::createFeature("org.iu2", Version.createOSGi(3,7,72))
								)
							} else if ("location3".equals(location.toString)) {
								newImmutableList(
									IUStub::createFeature("org.iu1", Version.createOSGi(1,2,0)),
									IUStub::createFeature("org.iu1", Version.createOSGi(1,2,5)),
									IUStub::createFeature("org.iu1", Version.createOSGi(1,3,2)),
									IUStub::createFeature("org.iu1", Version.createOSGi(2,0,0)),
									IUStub::createFeature("org.iu1", Version.createOSGi(2,3,0)),
									IUStub::createFeature("org.iu1", Version.createOSGi(3,9,0))
								)
							} else if ("location4".equals(location.toString)) {
								newImmutableList(
									IUStub::createFeature("org.iu1", Version.createOSGi(1,2,0)),
									IUStub::createFeature("org.iu2", Version.createOSGi(3,7,72)),
									IUStub::createFeature("com.iu1", Version.createOSGi(1,2,0)),
									IUStub::createFeature("com.iu2", Version.createOSGi(3,7,72)),
									IUStub::createFeature("com.iu3", Version.createOSGi(3,7,72))
								)
							} else if ("badLocation".equals(location.toString)) {
								throw new RuntimeException("bad location")
							} else if ("emptyRepository".equals(location.toString)) {
								return emptyList
							} else {
								return emptyList
							}
						}
					});
				}
			};
		}
	}
	
	override protected doGetSetup() {
		return new TargetPlatformStandaloneSetup() {
			override createInjector() {
				return Guice.createInjector(Modules2.mixin(
						MOCK_RUNTIME_MODULE,
						new SharedStateModule(),
						new TargetPlatformUiModule(TargetplatformActivator.getInstance) as Module));
			}
		};
	}
	
	@Inject
	IExecutionEnvironmentsManager eeManager;
	
	@Test
	def void testTargetPlatform1() {
		newBuilder
			.assertText('''target "Target Platform Name"
			''')
			.applyProposal
			.expectContent('''target "Target Platform Name"
			''')
		
		
		newBuilder
			.assertText('''target "Target Platform Name"
			''')
			.assertProposal('''target "Target Platform Name"
			''')
			.withDisplayString('target "Target Platform Name" - create a new target platform')
	}
	
	@Test
	def void testTargetPlatform2() {
		newBuilder.append("target").assertText(''' "Target Platform Name"
		''')
		.applyProposal
			.expectContent('''target "Target Platform Name"
			''')
	}
	
	@Test
	def void testTargetPlatform3() {
		newBuilder.append("target ").assertText('''"Target Platform Name"
		''')
		.applyProposal
			.expectContent('''target "Target Platform Name"
			''')
	}
	
	@Test
	def void testTargetPlatform4() {
		newBuilder.append("tar").assertText('''target "Target Platform Name"
			''')
			.applyProposal
			.expectContent('''target "Target Platform Name"
			''')
	}
	
	@Test
	def void testTargetContent() {
		newBuilder.append('''
			target "TPName"
		''').assertText(
			"environment", "with", 
			'''include "includedFile.tpd"
			''', 
			'''
			location "http://p2.repository.url/" {
				
			}''')
	}
	
	@Test
	def void testTargetContentOptions1() {
		newBuilder.append('''
			target "TPName"
			with ''').assertText("requirements", "allEnvironments", "source", "configurePhase")
	}
	
	@Test
	def void testTargetContentOptions2() {
		newBuilder.append('''
			target "TPName"
			with source ''').assertText("requirements", "allEnvironments", "configurePhase")
			.append("requirements ").assertText("allEnvironments", "configurePhase")
	}
	
	@Test
	def void testTargetContentOptions3() {
		newBuilder.append('''
			target "TPName"
			with source
		''').assertText(
			"environment", 
			'''include "includedFile.tpd"
			''', 
			'''
			location "http://p2.repository.url/" {
				
			}''')
	}
	
	@Test
	def void testTargetContentEnv0() {
		
		val p = ImmutableList.builder()
			.addAll(Platform.knownOSValues)
			.addAll(Platform.knownWSValues)
			.addAll(Platform.knownOSArchValues)
			.addAll(eeManager.executionEnvironments.map[id])
			.addAll(Locale.getAvailableLocales.map[toString]).build()
		
		newBuilder.append('''
			target "TPName"
			environment ''')
		.assertText(p)
	}
	
	@Test
	def void testTargetContentEnv1() {
		newBuilder.append('''
			target "TPName"
			environment win32
		''').assertText(
			"with", 
			'''include "includedFile.tpd"
			''', 
			'''
			location "http://p2.repository.url/" {
				
			}'''
		)
	}
	
	@Test
	def void testTargetContentEnv2() {
		
		val p = ImmutableList.builder()
			.addAll(Platform.knownWSValues)
			.addAll(Platform.knownOSArchValues)
			.addAll(eeManager.executionEnvironments.map[id])
			.addAll(Locale.getAvailableLocales.map[toString]).build()
		
		newBuilder.append('''
			target "TPName"
			environment macosx ''')
		.assertText(p)
	}
	
	@Test
	def void testTargetContentEnv3() {
		
		val p = ImmutableList.builder()
			.addAll(Platform.knownOSValues)
			.addAll(Platform.knownOSArchValues)
			.addAll(eeManager.executionEnvironments.map[id])
			.addAll(Locale.getAvailableLocales.map[toString]).build()
		
		newBuilder.append('''
			target "TPName"
			environment cocoa ''')
		.assertText(p)
	}
	
	@Test
	def void testTargetContentOptionsAndEnv() {
		newBuilder.append('''
			target "TPName"
			environment win32
			with source
		''').assertText(
			'''include "includedFile.tpd"
			''', 
			'''
			location "http://p2.repository.url/" {
				
			}'''
		)
	}
	
	@Test 
	def void testIUContentAssist1() {
		'''
			target "TPName"
			location "location1" {
				«c»
			}
		'''.assertProposals(
			'org.iu1'
		)
	}
	
	@Test 
	def void testIUContentAssist2() {
		'''
			target "TPName"
			location "location2" {
				«c»
			}
		'''.assertProposals(
			'org.iu1',
			'org.iu2'
		)
	}
	
	@Test 
	def void testIUContentAssist3() {
		'''
			target "TPName"
			location "location3" {
				«c»
			}
		'''.assertProposals(
			'org.iu1'
		)
	}
	
	@Test 
	def void testIUContentAssist4() {
		'''
			target "TPName"
			location "location4" {
				«c»
			}
		'''.assertProposals(
			'org.iu1',
			'org.iu2',
			'com.iu1',
			'com.iu2',
			'com.iu3'
		)
	}
	
	@Test 
	def void testIUContentAssist5() {
		'''
			target "TPName"
			location "location4" {
				o«c»
			}
		'''.assertProposals(
			'org.iu1',
			'org.iu2'
		)
	}
	
	@Test 
	def void testIUContentAssist6() {
		'''
			target "TPName"
			location "location4" {
				c«c»
			}
		'''.assertProposals(
			'com.iu1',
			'com.iu2',
			'com.iu3'
		)
	}
	
	@Test 
	def void testIUContentAssist7() {
		'''
			target "TPName"
			location "emptyLocation" {
				«c»
			}
		'''.assertProposals
	}
	
	@Test 
	def void testIUContentAssist8() {
		'''
			target "TPName"
			location "badLocation" {
				«c»
			}
		'''.assertProposals
	}
	
	@Test 
	def void testIUVersionContentAssist1() {
		'''
			target "TPName"
			location "location1" {
				org.iu1 «c»
			}
		'''.assertProposals(
			'[1.2.0,1.2.1)',
			'[1.2.0,1.3.0)',
			'[1.2.0,2.0.0)',
			'[1.2.0,1.2.0]',
			
			'lazy'
		)
	}
	
	@Test 
	def void testIUVersionContentAssist2() {
		'''
			target "TPName"
			location "location3" {
				org.iu1 «c»
			}
		'''.assertProposals(
			'[1.2.0,1.2.1)',
			'[1.2.0,1.3.0)',
			'[1.2.0,2.0.0)',
			'[1.2.0,1.2.0]',
			
			'[1.2.5,1.2.6)',
			'[1.2.5,1.3.0)',
			'[1.2.5,2.0.0)',
			'[1.2.5,1.2.5]',
			
			'[1.3.2,1.3.3)',
			'[1.3.2,1.4.0)',
			'[1.3.2,2.0.0)',
			'[1.3.2,1.3.2]',
			
			'[2.0.0,2.0.1)',
			'[2.0.0,2.1.0)',
			'[2.0.0,3.0.0)',
			'[2.0.0,2.0.0]',
			
			'[2.3.0,2.3.1)',
			'[2.3.0,2.4.0)',
			'[2.3.0,3.0.0)',
			'[2.3.0,2.3.0]',
			
			
			'[3.9.0,3.9.1)',
			'[3.9.0,3.10.0)',
			'[3.9.0,4.0.0)',
			'[3.9.0,3.9.0]',
			
			'lazy'
		)
	}
	
	@Test 
	def void testIUVersionContentAssist3() {
		'''
			target "TPName"
			location "location2" {
				org.iu1
				«c»
			}
		'''.assertProposals(
			'org.iu2'
		)
	}
	
	@Test 
	def void testIUVersionContentAssist4() {
		'''
			target "TPName"
			location "location2" {
				org.iu1
				org.iu2
				«c»
			}
		'''.assertProposals
	}
	
	@Test 
	def void testIUVersionContentAssist5() {
		'''
			target "TPName"
			location "location1" {
				org.iu1«c»
			}
		'''.assertProposals(
			' [1.2.0,1.2.1)',
			' [1.2.0,1.3.0)',
			' [1.2.0,2.0.0)',
			' [1.2.0,1.2.0]',
			
			' lazy'
		)
	}
	
	@Test
	def void testLocationURIAndID1ContentAssist() {
		newBuilder.append('''
			target "TPName"
			location ''').assertText(
			'"http://p2.repository.url/" ',
			'locationID '
		)
	}
	
	@Test
	def void testLocationURIAndID2ContentAssist() {
		newBuilder.append('''
			target "TPName"
			location''').assertText(
			' "http://p2.repository.url/" ',
			' locationID ',
			'''
			location "http://p2.repository.url/" {
				
			}'''
		)
	}
	
	@Test
	def void testLocationURIAndID3ContentAssist() {
		newBuilder.append('''
			target "TPName"
			location 
		''').assertText(
			'"http://p2.repository.url/" ',
			'locationID '
		)
	}
	
	@Test
	def void testLocationURIAndID4ContentAssist() {
		newBuilder.append('''
			target "TPName"
			location
		''').assertText(
			'"http://p2.repository.url/" ',
			'locationID '
		)
	}
	
	@Test
	def void testLocationURIAndID5ContentAssist() {
		'''
			target "TPName"
			location
			«c»
			location "uri" {
				
			}
		'''.assertProposals(
			'"http://p2.repository.url/" ',
			'locationID '
		)
	}
	
	@Test
	def void testLocationURIAndID6ContentAssist() {
		'''
			target "TPName"
			location«c»
			
			location "uri" {
				
			}
		'''.assertProposals(
			' "http://p2.repository.url/" ',
			' locationID ',
			'''
			location "http://p2.repository.url/" {
				
			}'''
		)
	}
	
	@Test
	def void testLocationURIAndID7ContentAssist() {
		'''
			target "TPName"
			location «c»
			
			location "uri" {
				
			}
		'''.assertProposals(
			'"http://p2.repository.url/" ',
			'locationID '
		)
	}
	
	@Test
	def void testLocationID1() {
		'''
			target "TPName"
			location "locationURI" «c»{
				
			}
		'''.assertProposals(
			'locationID '
		)
	}
	
	@Test
	def void testLocationID2() {
		'''
			target "TPName"
			location "locationURI"«c» {
				
			}
		'''.assertProposals(
			' locationID'
		)
	}
	
	@Test
	def void testLocationID3() {
		'''
			target "TPName"
			location "locationURI"«c»{
				
			}
		'''.assertProposals(
			' locationID '
		)
	}

	// cursor position marker
	val c = '''<|>'''

	private def void assertProposals(CharSequence text, String... expectedProposals) {
		val cursorPosition = text.toString.indexOf(c)
		val content = text.toString.replace(c, "")

		newBuilder.append(content).
		assertTextAtCursorPosition(cursorPosition, expectedProposals)
	}
}