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

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.cbi.targetplatform.Environment;
import org.eclipse.cbi.targetplatform.IU;
import org.eclipse.cbi.targetplatform.Location;
import org.eclipse.cbi.targetplatform.Option;
import org.eclipse.cbi.targetplatform.TargetContent;
import org.eclipse.cbi.targetplatform.TargetPlatform;
import org.eclipse.cbi.targetplatform.TargetPlatformInjectorProvider;
import java.util.List;
import java.util.Locale;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(TargetPlatformInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class TestGrammar {
  @Inject
  private ParseHelper<TargetPlatform> parser;
  
  @Test
  public void testEmpty() {
    try {
      final TargetPlatform targetPlatform = this.parser.parse("");
      Assert.assertNull(targetPlatform);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStandardFile() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"Latest target for EMF Compare based on Kepler interim\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"https://hudson.eclipse.org/hudson/view/Modeling/job/emf-core-head/lastSuccessfulBuild/artifact/EMF.p2.repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.sdk.feature.group;version=\"[2.9.0,3.0.0)\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.common.cache;version=\"10.0.1\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"https://hudson.eclipse.org/hudson/view/Modeling/job/mdt-uml2-master/lastSuccessfulBuild/artifact/UML2.p2.repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.uml2.sdk.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"https://hudson.eclipse.org/hudson/view/Modeling/job/mdt-uml2-master/lastSuccessfulBuild/artifact/UML2.p2.repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.uml2.sdk.feature.group;version=10.1.1.20141228-2310-BUILD1 ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      final Location fisrtLocation = IterableExtensions.<Location>head(targetPlatform.getLocations());
      Assert.assertEquals("https://hudson.eclipse.org/hudson/view/Modeling/job/emf-core-head/lastSuccessfulBuild/artifact/EMF.p2.repository/", fisrtLocation.getUri());
      Assert.assertEquals(2, fisrtLocation.getIus().size());
      final IU iu0 = IterableExtensions.<IU>head(fisrtLocation.getIus());
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", iu0.getID());
      Assert.assertEquals("[2.9.0,3.0.0)", iu0.getVersion());
      final IU iu1 = IterableExtensions.<IU>last(fisrtLocation.getIus());
      Assert.assertEquals("com.google.common.cache", iu1.getID());
      Assert.assertEquals("10.0.1", iu1.getVersion());
      final Location lastLocation = IterableExtensions.<Location>last(targetPlatform.getLocations());
      Assert.assertEquals("https://hudson.eclipse.org/hudson/view/Modeling/job/mdt-uml2-master/lastSuccessfulBuild/artifact/UML2.p2.repository/", lastLocation.getUri());
      Assert.assertEquals(1, lastLocation.getIus().size());
      final IU uml2iu = IterableExtensions.<IU>head(lastLocation.getIus());
      Assert.assertEquals("org.eclipse.uml2.sdk.feature.group", uml2iu.getID());
      Assert.assertEquals("10.1.1.20141228-2310-BUILD1", uml2iu.getVersion());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOption() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"my location URL\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("with source, allEnvironments, requirements, configurePhase");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.sdk.feature.group;version=\"[2.9.0,3.0.0)\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      final Location fisrtLocation = IterableExtensions.<Location>head(targetPlatform.getLocations());
      Assert.assertTrue(fisrtLocation.getOptions().contains(Option.INCLUDE_SOURCE));
      Assert.assertTrue(fisrtLocation.getOptions().contains(Option.INCLUDE_ALL_ENVIRONMENTS));
      Assert.assertTrue(fisrtLocation.getOptions().contains(Option.INCLUDE_REQUIRED));
      Assert.assertTrue(fisrtLocation.getOptions().contains(Option.INCLUDE_CONFIGURE_PHASE));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIdWithSpaceInIt() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"my location URL\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("my. iu");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertFalse(targetPlatform.eResource().getErrors().isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIdWithSpaceInIt2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"my location URL\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("my .iu");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertFalse(targetPlatform.eResource().getErrors().isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIdWithDash() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"my location URL\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("my.iu.with-dash");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      final Location fisrtLocation = IterableExtensions.<Location>head(targetPlatform.getLocations());
      final IU iu0 = IterableExtensions.<IU>head(fisrtLocation.getIus());
      Assert.assertEquals("my.iu.with-dash", iu0.getID());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIdWithVersionNonString() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"my location URL\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("my.iu;version=3");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      final Location fisrtLocation = IterableExtensions.<Location>head(targetPlatform.getLocations());
      final IU iu0 = IterableExtensions.<IU>head(fisrtLocation.getIus());
      Assert.assertEquals("my.iu", iu0.getID());
      Assert.assertEquals("3.0.0", iu0.getVersion());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIdWithVersionNonString2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"my location URL\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("myu;version=3.2.1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      final Location fisrtLocation = IterableExtensions.<Location>head(targetPlatform.getLocations());
      final IU iu0 = IterableExtensions.<IU>head(fisrtLocation.getIus());
      Assert.assertEquals("myu", iu0.getID());
      Assert.assertEquals("3.2.1", iu0.getVersion());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIdWithVersionNonString3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"my location URL\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("myu;version=[3.2.1,10.0)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      final Location fisrtLocation = IterableExtensions.<Location>head(targetPlatform.getLocations());
      final IU iu0 = IterableExtensions.<IU>head(fisrtLocation.getIus());
      Assert.assertEquals("myu", iu0.getID());
      Assert.assertEquals("[3.2.1,10.0.0)", iu0.getVersion());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIdWithVersionNonString4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"my location URL\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("myu;version=[ 3 , 5 )");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      final Location fisrtLocation = IterableExtensions.<Location>head(targetPlatform.getLocations());
      final IU iu0 = IterableExtensions.<IU>head(fisrtLocation.getIus());
      Assert.assertEquals("myu", iu0.getID());
      Assert.assertEquals("[3.0.0,5.0.0)", iu0.getVersion());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUWithIntQualifier() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"my location URL\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("myu;version=1.2.3.201404071200");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      final Location fisrtLocation = IterableExtensions.<Location>head(targetPlatform.getLocations());
      final IU iu0 = IterableExtensions.<IU>head(fisrtLocation.getIus());
      Assert.assertEquals("myu", iu0.getID());
      Assert.assertEquals("1.2.3.201404071200", iu0.getVersion());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWithKeywordInIUID1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava.^source");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp = this.parser.parse(_builder);
      Assert.assertEquals("TP1", tp.getName());
      final Function1<Location, EList<IU>> _function = new Function1<Location, EList<IU>>() {
        @Override
        public EList<IU> apply(final Location it) {
          return it.getIus();
        }
      };
      Assert.assertEquals(2, IterableExtensions.size(Iterables.<IU>concat(ListExtensions.<Location, EList<IU>>map(tp.getLocations(), _function))));
      final Function1<Location, List<String>> _function_1 = new Function1<Location, List<String>>() {
        @Override
        public List<String> apply(final Location it) {
          final Function1<IU, String> _function = new Function1<IU, String>() {
            @Override
            public String apply(final IU it) {
              return it.getID();
            }
          };
          return ListExtensions.<IU, String>map(it.getIus(), _function);
        }
      };
      final Iterable<String> ids = Iterables.<String>concat(ListExtensions.<Location, List<String>>map(tp.getLocations(), _function_1));
      Assert.assertEquals(2, IterableExtensions.size(ids));
      Assert.assertEquals("com.google.guava", IterableExtensions.<String>head(ids));
      Assert.assertEquals("com.google.guava.source", ((Object[])Conversions.unwrapArray(ids, Object.class))[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWithKeywordInIUID2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava.source");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp = this.parser.parse(_builder);
      Assert.assertEquals("TP1", tp.getName());
      final Function1<Location, EList<IU>> _function = new Function1<Location, EList<IU>>() {
        @Override
        public EList<IU> apply(final Location it) {
          return it.getIus();
        }
      };
      Assert.assertEquals(2, IterableExtensions.size(Iterables.<IU>concat(ListExtensions.<Location, EList<IU>>map(tp.getLocations(), _function))));
      final Function1<Location, List<String>> _function_1 = new Function1<Location, List<String>>() {
        @Override
        public List<String> apply(final Location it) {
          final Function1<IU, String> _function = new Function1<IU, String>() {
            @Override
            public String apply(final IU it) {
              return it.getID();
            }
          };
          return ListExtensions.<IU, String>map(it.getIus(), _function);
        }
      };
      final Iterable<String> ids = Iterables.<String>concat(ListExtensions.<Location, List<String>>map(tp.getLocations(), _function_1));
      Assert.assertEquals(2, IterableExtensions.size(ids));
      Assert.assertEquals("com.google.guava", IterableExtensions.<String>head(ids));
      Assert.assertEquals("com.google.guava.source", ((Object[])Conversions.unwrapArray(ids, Object.class))[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWithEnvironment1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment win32 x86_64 motif en_US JavaSE-1.7");
      _builder.newLine();
      final TargetPlatform tp = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(tp.eResource().getErrors(), "\n"), tp.eResource().getErrors().isEmpty());
      final Environment env = IterableExtensions.<Environment>head(Iterables.<Environment>filter(tp.getContents(), Environment.class));
      Assert.assertEquals("win32", env.getOperatingSystem());
      Assert.assertEquals("x86_64", env.getArchitecture());
      Assert.assertEquals("motif", env.getWindowingSystem());
      Locale _locale = new Locale("en", "us");
      Assert.assertEquals(_locale, env.getLocalization());
      Assert.assertEquals(JavaRuntime.getExecutionEnvironmentsManager().getEnvironment("JavaSE-1.7"), env.getExecutionEnvironment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWithEnvironment2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment win32 ");
      _builder.newLine();
      _builder.append("environment win32");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      Assert.assertEquals("win32", targetPlatform.getEnvironment().getOperatingSystem());
      Assert.assertEquals("win32", targetPlatform.getEnvironment().getWindowingSystem());
      TargetContent _get = targetPlatform.getContents().get(0);
      Assert.assertEquals("win32", ((Environment) _get).getOperatingSystem());
      TargetContent _get_1 = targetPlatform.getContents().get(0);
      Assert.assertEquals("win32", ((Environment) _get_1).getWindowingSystem());
      TargetContent _get_2 = targetPlatform.getContents().get(1);
      Assert.assertEquals("win32", ((Environment) _get_2).getWindowingSystem());
      TargetContent _get_3 = targetPlatform.getContents().get(1);
      Assert.assertEquals("win32", ((Environment) _get_3).getOperatingSystem());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWithEnvironment5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment win32 linux");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      Assert.assertEquals("linux", targetPlatform.getEnvironment().getOperatingSystem());
      Assert.assertEquals("win32", targetPlatform.getEnvironment().getWindowingSystem());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWithEnvironment6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment win32 cocoa");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      Assert.assertEquals("win32", targetPlatform.getEnvironment().getOperatingSystem());
      Assert.assertEquals("cocoa", targetPlatform.getEnvironment().getWindowingSystem());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWithEnvironment7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment linux win32");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      Assert.assertEquals("linux", targetPlatform.getEnvironment().getOperatingSystem());
      Assert.assertEquals("win32", targetPlatform.getEnvironment().getWindowingSystem());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWithEnvironment8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment cocoa win32");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      Assert.assertEquals("win32", targetPlatform.getEnvironment().getOperatingSystem());
      Assert.assertEquals("cocoa", targetPlatform.getEnvironment().getWindowingSystem());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testVersionWithoutKeywords1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava 1.2.0");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      final Function1<Location, List<String>> _function = new Function1<Location, List<String>>() {
        @Override
        public List<String> apply(final Location it) {
          final Function1<IU, String> _function = new Function1<IU, String>() {
            @Override
            public String apply(final IU it) {
              return it.getID();
            }
          };
          return ListExtensions.<IU, String>map(it.getIus(), _function);
        }
      };
      final Iterable<String> ids = Iterables.<String>concat(ListExtensions.<Location, List<String>>map(targetPlatform.getLocations(), _function));
      final Function1<Location, List<String>> _function_1 = new Function1<Location, List<String>>() {
        @Override
        public List<String> apply(final Location it) {
          final Function1<IU, String> _function = new Function1<IU, String>() {
            @Override
            public String apply(final IU it) {
              return it.getVersion();
            }
          };
          return ListExtensions.<IU, String>map(it.getIus(), _function);
        }
      };
      final Iterable<String> versions = Iterables.<String>concat(ListExtensions.<Location, List<String>>map(targetPlatform.getLocations(), _function_1));
      Assert.assertEquals(1, IterableExtensions.size(ids));
      Assert.assertEquals("com.google.guava", IterableExtensions.<String>head(ids));
      Assert.assertEquals("1.2.0", IterableExtensions.<String>head(versions));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testVersionWithoutKeywords2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava [1.2.0 , 2.4.54)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      final Function1<Location, List<String>> _function = new Function1<Location, List<String>>() {
        @Override
        public List<String> apply(final Location it) {
          final Function1<IU, String> _function = new Function1<IU, String>() {
            @Override
            public String apply(final IU it) {
              return it.getID();
            }
          };
          return ListExtensions.<IU, String>map(it.getIus(), _function);
        }
      };
      final Iterable<String> ids = Iterables.<String>concat(ListExtensions.<Location, List<String>>map(targetPlatform.getLocations(), _function));
      final Function1<Location, List<String>> _function_1 = new Function1<Location, List<String>>() {
        @Override
        public List<String> apply(final Location it) {
          final Function1<IU, String> _function = new Function1<IU, String>() {
            @Override
            public String apply(final IU it) {
              return it.getVersion();
            }
          };
          return ListExtensions.<IU, String>map(it.getIus(), _function);
        }
      };
      final Iterable<String> versions = Iterables.<String>concat(ListExtensions.<Location, List<String>>map(targetPlatform.getLocations(), _function_1));
      Assert.assertEquals(1, IterableExtensions.size(ids));
      Assert.assertEquals("com.google.guava", IterableExtensions.<String>head(ids));
      Assert.assertEquals("[1.2.0,2.4.54)", IterableExtensions.<String>head(versions));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testVersionWithoutKeywords3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava [1.2.0 , 2.4.54)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.apacahe.commons");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      final Function1<Location, List<String>> _function = new Function1<Location, List<String>>() {
        @Override
        public List<String> apply(final Location it) {
          final Function1<IU, String> _function = new Function1<IU, String>() {
            @Override
            public String apply(final IU it) {
              return it.getID();
            }
          };
          return ListExtensions.<IU, String>map(it.getIus(), _function);
        }
      };
      final Iterable<String> ids = Iterables.<String>concat(ListExtensions.<Location, List<String>>map(targetPlatform.getLocations(), _function));
      final Function1<Location, List<String>> _function_1 = new Function1<Location, List<String>>() {
        @Override
        public List<String> apply(final Location it) {
          final Function1<IU, String> _function = new Function1<IU, String>() {
            @Override
            public String apply(final IU it) {
              return it.getVersion();
            }
          };
          return ListExtensions.<IU, String>map(it.getIus(), _function);
        }
      };
      final Iterable<String> versions = Iterables.<String>concat(ListExtensions.<Location, List<String>>map(targetPlatform.getLocations(), _function_1));
      Assert.assertEquals(2, IterableExtensions.size(ids));
      Assert.assertEquals("com.google.guava", IterableExtensions.<String>head(ids));
      Assert.assertEquals("org.apacahe.commons", ((Object[])Conversions.unwrapArray(ids, Object.class))[1]);
      Assert.assertEquals("[1.2.0,2.4.54)", IterableExtensions.<String>head(versions));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testVersionWithoutKeywords4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava 1.2.0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.apacahe.commons");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Assert.assertTrue(IterableExtensions.join(targetPlatform.eResource().getErrors(), "\n"), targetPlatform.eResource().getErrors().isEmpty());
      final Function1<Location, List<String>> _function = new Function1<Location, List<String>>() {
        @Override
        public List<String> apply(final Location it) {
          final Function1<IU, String> _function = new Function1<IU, String>() {
            @Override
            public String apply(final IU it) {
              return it.getID();
            }
          };
          return ListExtensions.<IU, String>map(it.getIus(), _function);
        }
      };
      final Iterable<String> ids = Iterables.<String>concat(ListExtensions.<Location, List<String>>map(targetPlatform.getLocations(), _function));
      final Function1<Location, List<String>> _function_1 = new Function1<Location, List<String>>() {
        @Override
        public List<String> apply(final Location it) {
          final Function1<IU, String> _function = new Function1<IU, String>() {
            @Override
            public String apply(final IU it) {
              return it.getVersion();
            }
          };
          return ListExtensions.<IU, String>map(it.getIus(), _function);
        }
      };
      final Iterable<String> versions = Iterables.<String>concat(ListExtensions.<Location, List<String>>map(targetPlatform.getLocations(), _function_1));
      Assert.assertEquals(2, IterableExtensions.size(ids));
      Assert.assertEquals("com.google.guava", IterableExtensions.<String>head(ids));
      Assert.assertEquals("org.apacahe.commons", ((Object[])Conversions.unwrapArray(ids, Object.class))[1]);
      Assert.assertEquals("1.2.0", IterableExtensions.<String>head(versions));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
