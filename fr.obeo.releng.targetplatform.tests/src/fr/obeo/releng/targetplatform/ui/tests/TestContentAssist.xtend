package fr.obeo.releng.targetplatform.ui.tests

import com.google.common.collect.ImmutableList
import com.google.inject.Guice
import com.google.inject.Module
import com.google.inject.Provider
import fr.obeo.releng.targetplatform.TargetPlatformRuntimeModule
import fr.obeo.releng.targetplatform.TargetPlatformStandaloneSetup
import fr.obeo.releng.targetplatform.tests.IQueryResultProvider
import fr.obeo.releng.targetplatform.tests.MockIU
import fr.obeo.releng.targetplatform.tests.MockProvisioningAgent
import fr.obeo.releng.targetplatform.ui.TargetPlatformUiModule
import fr.obeo.releng.targetplatform.ui.internal.TargetPlatformActivator
import java.net.URI
import java.util.Locale
import org.eclipse.core.runtime.Platform
import org.eclipse.equinox.p2.core.IProvisioningAgent
import org.eclipse.equinox.p2.metadata.IInstallableUnit
import org.eclipse.equinox.p2.metadata.Version
import org.eclipse.jdt.launching.JavaRuntime
import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest
import org.eclipse.xtext.ui.shared.SharedStateModule
import org.eclipse.xtext.util.Modules2
import org.junit.Test

import static fr.obeo.releng.targetplatform.ui.tests.TestContentAssist.*

class TestContentAssist extends AbstractContentAssistProcessorTest {
	
	static val MOCK_RUNTIME_MODULE = new TargetPlatformRuntimeModule() {
		override provideIProvisioningAgent() {
			return new Provider<IProvisioningAgent>() {
				override IProvisioningAgent get() {
					return new MockProvisioningAgent(new IQueryResultProvider<IInstallableUnit>() {
						override listIUs(URI location) {
							if ("location1".equals(location.toString)) {
								newImmutableList(
									MockIU::createFeature("org.iu1", Version.createOSGi(1,2,0))
								)
							} else if ("location2".equals(location.toString)) {
								newImmutableList(
									MockIU::createFeature("org.iu1", Version.createOSGi(1,2,0)),
									MockIU::createFeature("org.iu2", Version.createOSGi(3,7,72))
								)
							} else if ("location3".equals(location.toString)) {
								newImmutableList(
									MockIU::createFeature("org.iu1", Version.createOSGi(1,2,0)),
									MockIU::createFeature("org.iu1", Version.createOSGi(1,2,5)),
									MockIU::createFeature("org.iu1", Version.createOSGi(1,3,2)),
									MockIU::createFeature("org.iu1", Version.createOSGi(2,0,0)),
									MockIU::createFeature("org.iu1", Version.createOSGi(2,3,0)),
									MockIU::createFeature("org.iu1", Version.createOSGi(3,9,0))
								)
							} else if ("location4".equals(location.toString)) {
								newImmutableList(
									MockIU::createFeature("org.iu1", Version.createOSGi(1,2,0)),
									MockIU::createFeature("org.iu2", Version.createOSGi(3,7,72)),
									MockIU::createFeature("com.iu1", Version.createOSGi(1,2,0)),
									MockIU::createFeature("com.iu2", Version.createOSGi(3,7,72)),
									MockIU::createFeature("com.iu3", Version.createOSGi(3,7,72))
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
						new TargetPlatformUiModule(TargetPlatformActivator.getInstance) as Module));
			}
		};
	}
	
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
			.addAll(JavaRuntime.executionEnvironmentsManager.executionEnvironments.map[id])
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
			.addAll(JavaRuntime.executionEnvironmentsManager.executionEnvironments.map[id])
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
			.addAll(JavaRuntime.executionEnvironmentsManager.executionEnvironments.map[id])
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
		newBuilder.append('''
			target "TPName"
			location "location1" {
				
			}
		''').cursorBack(3).assertText(
			'org.iu1'
		)
	}
	
	@Test 
	def void testIUContentAssist2() {
		newBuilder.append('''
			target "TPName"
			location "location2" {
				
			}
		''').cursorBack(3).assertText(
			'org.iu1',
			'org.iu2'
		)
	}
	
	@Test 
	def void testIUContentAssist3() {
		newBuilder.append('''
			target "TPName"
			location "location3" {
				
			}
		''').cursorBack(3).assertText(
			'org.iu1'
		)
	}
	
	@Test 
	def void testIUContentAssist4() {
		newBuilder.append('''
			target "TPName"
			location "location4" {
				
			}
		''').cursorBack(3).assertText(
			'org.iu1',
			'org.iu2',
			'com.iu1',
			'com.iu2',
			'com.iu3'
		)
	}
	
	@Test 
	def void testIUContentAssist5() {
		newBuilder.append('''
			target "TPName"
			location "location4" {
				o
			}
		''').cursorBack(3).assertText(
			'org.iu1',
			'org.iu2'
		)
	}
	
	@Test 
	def void testIUContentAssist6() {
		newBuilder.append('''
			target "TPName"
			location "location4" {
				c
			}
		''').cursorBack(3).assertText(
			'com.iu1',
			'com.iu2',
			'com.iu3'
		)
	}
	
	@Test 
	def void testIUContentAssist7() {
		newBuilder.append('''
			target "TPName"
			location "emptyLocation" {
				
			}
		''').cursorBack(3).assertText('')
	}
	
	@Test 
	def void testIUContentAssist8() {
		newBuilder.append('''
			target "TPName"
			location "badLocation" {
				
			}
		''').cursorBack(3).assertText('')
	}
	
	@Test 
	def void testIUVersionContentAssist1() {
		newBuilder.append('''
			target "TPName"
			location "location1" {
				org.iu1 
			}
		''').cursorBack(3).assertText(
			'[1.2.0,1.2.1)',
			'[1.2.0,1.3.0)',
			'[1.2.0,2.0.0)',
			'[1.2.0,1.2.0]',
			
			'lazy'
		)
	}
	
	@Test 
	def void testIUVersionContentAssist2() {
		newBuilder.append('''
			target "TPName"
			location "location3" {
				org.iu1 
			}
		''').cursorBack(3).assertText(
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
		newBuilder.append('''
			target "TPName"
			location "location2" {
				org.iu1
				
			}
		''').cursorBack(3).assertText(
			'org.iu2'
		)
	}
	
	@Test 
	def void testIUVersionContentAssist4() {
		newBuilder.append('''
			target "TPName"
			location "location2" {
				org.iu1
				org.iu2
				
			}
		''').cursorBack(3).assertText('')
	}
	
	@Test 
	def void testIUVersionContentAssist5() {
		newBuilder.append('''
			target "TPName"
			location "location1" {
				org.iu1
			}
		''').cursorBack(3).assertText(
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
		newBuilder.append('''
			target "TPName"
			location
			
			location "uri" {
				
			}
		''').cursorBack(22).assertText( // cursor location\n|\n
			'"http://p2.repository.url/" ',
			'locationID '
		)
	}
	
	@Test
	def void testLocationURIAndID6ContentAssist() {
		newBuilder.append('''
			target "TPName"
			location
			
			location "uri" {
				
			}
		''').cursorBack(23).assertText(
			' "http://p2.repository.url/" ',
			' locationID ',
			'''
			location "http://p2.repository.url/" {
				
			}'''
		)
	}
	
	@Test
	def void testLocationURIAndID7ContentAssist() {
		newBuilder.append('''
			target "TPName"
			location 
			
			location "uri" {
				
			}
		''').cursorBack(22).assertText(
			'"http://p2.repository.url/" ',
			'locationID '
		)
	}
	
	@Test
	def void testLocationID1() {
		newBuilder.append('''
			target "TPName"
			location "locationURI" {
				
			}
		''').cursorBack(6).assertText( // cursor: " |{
			'locationID '
		)
	}
	
	@Test
	def void testLocationID2() {
		newBuilder.append('''
			target "TPName"
			location "locationURI" {
				
			}
		''').cursorBack(7).assertText( // cursor: "| {
			' locationID'
		)
	}
	
	@Test
	def void testLocationID3() {
		newBuilder.append('''
			target "TPName"
			location "locationURI"{
				
			}
		''').cursorBack(6).assertText( // cursor: "|{
			' locationID '
		)
	}
}