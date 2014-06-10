package fr.obeo.releng.targetplatform.tests;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import fr.obeo.releng.targetplatform.IU;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.Option;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
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
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      final Location fisrtLocation = IterableExtensions.<Location>head(_locations);
      String _uri = fisrtLocation.getUri();
      Assert.assertEquals("https://hudson.eclipse.org/hudson/view/Modeling/job/emf-core-head/lastSuccessfulBuild/artifact/EMF.p2.repository/", _uri);
      EList<IU> _ius = fisrtLocation.getIus();
      int _size = _ius.size();
      Assert.assertEquals(2, _size);
      EList<IU> _ius_1 = fisrtLocation.getIus();
      final IU iu0 = IterableExtensions.<IU>head(_ius_1);
      String _iD = iu0.getID();
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", _iD);
      String _version = iu0.getVersion();
      Assert.assertEquals("[2.9.0,3.0.0)", _version);
      EList<IU> _ius_2 = fisrtLocation.getIus();
      final IU iu1 = IterableExtensions.<IU>last(_ius_2);
      String _iD_1 = iu1.getID();
      Assert.assertEquals("com.google.common.cache", _iD_1);
      String _version_1 = iu1.getVersion();
      Assert.assertEquals("10.0.1", _version_1);
      EList<Location> _locations_1 = targetPlatform.getLocations();
      final Location lastLocation = IterableExtensions.<Location>last(_locations_1);
      String _uri_1 = lastLocation.getUri();
      Assert.assertEquals("https://hudson.eclipse.org/hudson/view/Modeling/job/mdt-uml2-master/lastSuccessfulBuild/artifact/UML2.p2.repository/", _uri_1);
      EList<IU> _ius_3 = lastLocation.getIus();
      int _size_1 = _ius_3.size();
      Assert.assertEquals(1, _size_1);
      EList<IU> _ius_4 = lastLocation.getIus();
      final IU uml2iu = IterableExtensions.<IU>head(_ius_4);
      String _iD_2 = uml2iu.getID();
      Assert.assertEquals("org.eclipse.uml2.sdk.feature.group", _iD_2);
      String _version_2 = uml2iu.getVersion();
      Assert.assertEquals(null, _version_2);
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
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      final Location fisrtLocation = IterableExtensions.<Location>head(_locations);
      EList<Option> _options = fisrtLocation.getOptions();
      boolean _contains = _options.contains(Option.INCLUDE_SOURCE);
      Assert.assertTrue(_contains);
      EList<Option> _options_1 = fisrtLocation.getOptions();
      boolean _contains_1 = _options_1.contains(Option.INCLUDE_ALL_ENVIRONMENTS);
      Assert.assertTrue(_contains_1);
      EList<Option> _options_2 = fisrtLocation.getOptions();
      boolean _contains_2 = _options_2.contains(Option.INCLUDE_REQUIRED);
      Assert.assertTrue(_contains_2);
      EList<Option> _options_3 = fisrtLocation.getOptions();
      boolean _contains_3 = _options_3.contains(Option.INCLUDE_CONFIGURE_PHASE);
      Assert.assertTrue(_contains_3);
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
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertFalse(_isEmpty);
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
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertFalse(_isEmpty);
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
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      final Location fisrtLocation = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = fisrtLocation.getIus();
      final IU iu0 = IterableExtensions.<IU>head(_ius);
      String _iD = iu0.getID();
      Assert.assertEquals("my.iu.with-dash", _iD);
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
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      final Location fisrtLocation = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = fisrtLocation.getIus();
      final IU iu0 = IterableExtensions.<IU>head(_ius);
      String _iD = iu0.getID();
      Assert.assertEquals("my.iu", _iD);
      String _version = iu0.getVersion();
      Assert.assertEquals("3.0.0", _version);
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
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      final Location fisrtLocation = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = fisrtLocation.getIus();
      final IU iu0 = IterableExtensions.<IU>head(_ius);
      String _iD = iu0.getID();
      Assert.assertEquals("myu", _iD);
      String _version = iu0.getVersion();
      Assert.assertEquals("3.2.1", _version);
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
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      final Location fisrtLocation = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = fisrtLocation.getIus();
      final IU iu0 = IterableExtensions.<IU>head(_ius);
      String _iD = iu0.getID();
      Assert.assertEquals("myu", _iD);
      String _version = iu0.getVersion();
      Assert.assertEquals("[3.2.1,10.0.0)", _version);
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
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      final Location fisrtLocation = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = fisrtLocation.getIus();
      final IU iu0 = IterableExtensions.<IU>head(_ius);
      String _iD = iu0.getID();
      Assert.assertEquals("myu", _iD);
      String _version = iu0.getVersion();
      Assert.assertEquals("[3.0.0,5.0.0)", _version);
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
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      final Location fisrtLocation = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = fisrtLocation.getIus();
      final IU iu0 = IterableExtensions.<IU>head(_ius);
      String _iD = iu0.getID();
      Assert.assertEquals("myu", _iD);
      String _version = iu0.getVersion();
      Assert.assertEquals("1.2.3.201404071200", _version);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWithKeywordInIUID() {
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
      String _name = tp.getName();
      Assert.assertEquals("TP1", _name);
      EList<Location> _locations = tp.getLocations();
      final Function1<Location,EList<IU>> _function = new Function1<Location,EList<IU>>() {
        public EList<IU> apply(final Location it) {
          return it.getIus();
        }
      };
      List<EList<IU>> _map = ListExtensions.<Location, EList<IU>>map(_locations, _function);
      Iterable<IU> _flatten = Iterables.<IU>concat(_map);
      int _size = IterableExtensions.size(_flatten);
      Assert.assertEquals(2, _size);
      EList<Location> _locations_1 = tp.getLocations();
      final Function1<Location,List<String>> _function_1 = new Function1<Location,List<String>>() {
        public List<String> apply(final Location it) {
          EList<IU> _ius = it.getIus();
          final Function1<IU,String> _function = new Function1<IU,String>() {
            public String apply(final IU it) {
              return it.getID();
            }
          };
          return ListExtensions.<IU, String>map(_ius, _function);
        }
      };
      List<List<String>> _map_1 = ListExtensions.<Location, List<String>>map(_locations_1, _function_1);
      final Iterable<String> ids = Iterables.<String>concat(_map_1);
      int _size_1 = IterableExtensions.size(ids);
      Assert.assertEquals(2, _size_1);
      String _head = IterableExtensions.<String>head(ids);
      Assert.assertEquals("com.google.guava", _head);
      Object _get = ((Object[])Conversions.unwrapArray(ids, Object.class))[1];
      Assert.assertEquals("com.google.guava.source", _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWithEnvironment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment Linux, x86_64, motif, en_US, JavaSE-1_7");
      _builder.newLine();
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
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
