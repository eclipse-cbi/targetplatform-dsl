/**
 * Copyright (c) 2012-2014 Obeo and others.
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
package org.eclipse.cbi.targetplatform.tests

import com.google.inject.Inject
import java.net.URI
import java.util.List
import org.eclipse.cbi.targetplatform.model.TargetPlatform
import org.eclipse.cbi.targetplatform.pde.TargetDefinitionGenerator
import org.eclipse.cbi.targetplatform.resolved.ResolvedTargetPlatform
import org.eclipse.cbi.targetplatform.tests.stubs.p2.IQueryResultProvider
import org.eclipse.cbi.targetplatform.tests.stubs.p2.MetadataRepositoryManagerStub
import org.eclipse.cbi.targetplatform.tests.stubs.p2.IUStub
import org.eclipse.cbi.targetplatform.tests.util.CustomTargetPlatformInjectorProvider
import org.eclipse.cbi.targetplatform.util.LocationIndexBuilder
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.equinox.p2.metadata.IInstallableUnit
import org.eclipse.equinox.p2.metadata.Version
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(CustomTargetPlatformInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestTargetGeneration {
	
	
	@Inject
	ParseHelper<TargetPlatform> parser
	
	@Inject
	LocationIndexBuilder indexBuilder;
	
	@Test(expected=typeof(IllegalArgumentException))
	def void testEmptyTP() {
		val tp1 = parser.parse('''
		''')
		ResolvedTargetPlatform.create(tp1, indexBuilder);
	}
	
	@Test
	def void testNamedTP() {
		val tp1 = parser.parse('''
			target "TP1"
		''')
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testSingleLocationSingleIU() {
		val tp1 = parser.parse('''
			target "TP1"
			
			location "http://location.org/p2" {
				an.iu
			}
		''')
		
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		resolvedTargetPlatform.resolve(new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(URI location) {
				if ("http://location.org/p2".equals(location.toString)) {
					newImmutableList(
						IUStub.createBundle("an.iu", Version.createOSGi(1,0,0, "thequalifier"))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <locations>
		    <location includeMode="slicer" includeAllPlatforms="false" includeSource="false" includeConfigurePhase="false" type="InstallableUnit">
		      <unit id="an.iu" version="1.0.0.thequalifier"/>
		      <repository location="http://location.org/p2"/>
		    </location>
		  </locations>
		</target>
		'''.toString, content)
	}

	@Test
	def void testSingleLocationManyIU() {
		val tp1 = parser.parse('''
			target "TP1"
			
			location "http://location.org/p2" {
				an.iu
				an.iu2;version=[1.2.0,2.0.0)
			}
		''')
		
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		resolvedTargetPlatform.resolve(new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(URI location) {
				var List<IInstallableUnit> ret
				if ("http://location.org/p2".equals(location.toString)) {
						ret = newImmutableList(
							IUStub.createBundle("an.iu", Version.createOSGi(1,0,0, "thequalifier")), 
							IUStub.createBundle("an.iu2", Version.createOSGi(1,3,74, null))
						)
				} else {
					ret = emptyList
				}
				return ret;
			}
			
		}), new NullProgressMonitor());
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <locations>
		    <location includeMode="slicer" includeAllPlatforms="false" includeSource="false" includeConfigurePhase="false" type="InstallableUnit">
		      <unit id="an.iu" version="1.0.0.thequalifier"/>
		      <unit id="an.iu2" version="1.3.74"/>
		      <repository location="http://location.org/p2"/>
		    </location>
		  </locations>
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testManyLocationManyIU() {
		val tp1 = parser.parse('''
			target "TP1"
			
			location "http://location.org/p2" {
				an.iu
			}
			
			location "http://location2.org/p2" {
				an.iu2
			}
		''')
		
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		resolvedTargetPlatform.resolve(new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(URI location) {
				var List<IInstallableUnit> ret
				if ("http://location.org/p2".equals(location.toString)) {
						ret = newImmutableList(
							IUStub.createBundle("an.iu", Version.createOSGi(1,0,0)) 
						)
				} else if ("http://location2.org/p2".equals(location.toString)) {
						ret = newImmutableList(
							IUStub.createBundle("an.iu2", Version.createOSGi(1,3,74, null))
						)
				} else {
					ret = emptyList
				}
				return ret;
			}
			
		}), new NullProgressMonitor());
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <locations>
		    <location includeMode="slicer" includeAllPlatforms="false" includeSource="false" includeConfigurePhase="false" type="InstallableUnit">
		      <unit id="an.iu" version="1.0.0"/>
		      <repository location="http://location.org/p2"/>
		    </location>
		    <location includeMode="slicer" includeAllPlatforms="false" includeSource="false" includeConfigurePhase="false" type="InstallableUnit">
		      <unit id="an.iu2" version="1.3.74"/>
		      <repository location="http://location2.org/p2"/>
		    </location>
		  </locations>
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testOptionSource() {
		val tp1 = parser.parse('''
			target "TP1"
			
			with source
			
			location "http://location.org/p2" {
				an.iu
			}
		''')
		
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		resolvedTargetPlatform.resolve(new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(URI location) {
				if ("http://location.org/p2".equals(location.toString)) {
					newImmutableList(
						IUStub.createBundle("an.iu", Version.createOSGi(1,0,0, "thequalifier"))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <locations>
		    <location includeMode="slicer" includeAllPlatforms="false" includeSource="true" includeConfigurePhase="false" type="InstallableUnit">
		      <unit id="an.iu" version="1.0.0.thequalifier"/>
		      <repository location="http://location.org/p2"/>
		    </location>
		  </locations>
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testOptionRequirement() {
		val tp1 = parser.parse('''
			target "TP1"
			
			with requirements
			
			location "http://location.org/p2" {
				an.iu
			}
		''')
		
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		resolvedTargetPlatform.resolve(new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(URI location) {
				if ("http://location.org/p2".equals(location.toString)) {
					newImmutableList(
						IUStub.createBundle("an.iu", Version.createOSGi(1,0,0, "thequalifier"))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <locations>
		    <location includeMode="planner" includeAllPlatforms="false" includeSource="false" includeConfigurePhase="false" type="InstallableUnit">
		      <unit id="an.iu" version="1.0.0.thequalifier"/>
		      <repository location="http://location.org/p2"/>
		    </location>
		  </locations>
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testOptionIncludeAllPlatforms() {
		val tp1 = parser.parse('''
			target "TP1"
			
			with allEnvironments
			
			location "http://location.org/p2" {
				an.iu
			}
		''')
		
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		resolvedTargetPlatform.resolve(new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(URI location) {
				if ("http://location.org/p2".equals(location.toString)) {
					newImmutableList(
						IUStub.createBundle("an.iu", Version.createOSGi(1,0,0, "thequalifier"))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <locations>
		    <location includeMode="slicer" includeAllPlatforms="true" includeSource="false" includeConfigurePhase="false" type="InstallableUnit">
		      <unit id="an.iu" version="1.0.0.thequalifier"/>
		      <repository location="http://location.org/p2"/>
		    </location>
		  </locations>
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testOptionConfigurePhase() {
		val tp1 = parser.parse('''
			target "TP1"
			
			with configurePhase
			
			location "http://location.org/p2" {
				an.iu
			}
		''')
		
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		resolvedTargetPlatform.resolve(new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(URI location) {
				if ("http://location.org/p2".equals(location.toString)) {
					newImmutableList(
						IUStub.createBundle("an.iu", Version.createOSGi(1,0,0, "thequalifier"))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <locations>
		    <location includeMode="slicer" includeAllPlatforms="false" includeSource="false" includeConfigurePhase="true" type="InstallableUnit">
		      <unit id="an.iu" version="1.0.0.thequalifier"/>
		      <repository location="http://location.org/p2"/>
		    </location>
		  </locations>
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testEnvOS() {
		val tp1 = parser.parse('''
			target "TP1"
			
			environment Win32
		''')
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <environment>
		    <os>win32</os>
		  </environment>
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testEnvOSWin32WSWin32() {
		val tp1 = parser.parse('''
			target "TP1"
			
			environment Win32 wiN32
		''')
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <environment>
		    <os>win32</os>
		    <ws>win32</ws>
		  </environment>
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testEnvWS() {
		val tp1 = parser.parse('''
			target "TP1"
			
			environment cocoa
		''')
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <environment>
		    <ws>cocoa</ws>
		  </environment>
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testEnvArch() {
		val tp1 = parser.parse('''
			target "TP1"
			
			environment x86_64
		''')
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <environment>
		    <arch>x86_64</arch>
		  </environment>
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testEnvLocale() {
		val tp1 = parser.parse('''
			target "TP1"
			
			environment fr_fr
		''')
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <environment>
		    <nl>fr_FR</nl>
		  </environment>
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testEnvEE() {
		val tp1 = parser.parse('''
			target "TP1"
			
			environment JavaSE-1.7
		''')
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <targetJRE path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7"/>
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testEnv1() {
		val tp1 = parser.parse('''
			target "TP1"
			
			environment JavaSE-1.7 win32 cocoa x86 en_us
		''')
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <environment>
		    <os>win32</os>
		    <ws>cocoa</ws>
		    <arch>x86</arch>
		    <nl>en_US</nl>
		  </environment>
		  <targetJRE path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7"/>
		</target>
		'''.toString, content)
	}
	
	@Test
	def void testEnv2() {
		val tp1 = parser.parse('''
			target "TP1"
			
			environment win32 linux
		''')
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, indexBuilder);
		
		val gen = new TargetDefinitionGenerator();
		val content = gen.generate(resolvedTargetPlatform, 1);
		assertEquals('''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="TP1" sequenceNumber="1">
		  <environment>
		    <os>linux</os>
		    <ws>win32</ws>
		  </environment>
		</target>
		'''.toString, content)
	}
}
