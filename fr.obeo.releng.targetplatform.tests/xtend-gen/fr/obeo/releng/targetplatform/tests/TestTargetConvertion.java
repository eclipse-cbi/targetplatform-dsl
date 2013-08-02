package fr.obeo.releng.targetplatform.tests;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import fr.obeo.releng.TargetPlatformInjectorProvider;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.pde.IConverter;
import fr.obeo.releng.validation.TargetPlatformJavaValidator;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.BasicMonitor.Printing;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.pde.core.target.ITargetDefinition;
import org.eclipse.pde.core.target.ITargetLocation;
import org.eclipse.pde.internal.core.target.IUBundleContainer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = TargetPlatformInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class TestTargetConvertion {
  @Inject
  private ParseHelper<TargetPlatform> parser;
  
  @Inject
  private TargetPlatformJavaValidator validator;
  
  @Inject
  private EValidatorRegistrar validatorRegistrar;
  
  @Inject
  @Named(value = Constants.LANGUAGE_NAME)
  private String languageName;
  
  @Test
  public void testBasicBundle() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TestTarget\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("with source, requirements");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava;version=\"[11.0.0,12.0.0)\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.junit");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      ClassLoader _classLoader = IConverter.class.getClassLoader();
      final Class<? extends Object> converterClass = _classLoader.loadClass("fr.obeo.releng.targetplatform.internal.pde.Converter");
      Method[] _declaredMethods = converterClass.getDeclaredMethods();
      final Function1<Method,Boolean> _function = new Function1<Method,Boolean>() {
          public Boolean apply(final Method it) {
            String _name = it.getName();
            boolean _equals = Objects.equal(_name, "convertToTargetDefinition");
            return Boolean.valueOf(_equals);
          }
        };
      final Method converterMethod = IterableExtensions.<Method>findFirst(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
      Object _newInstance = converterClass.newInstance();
      final IConverter converter = ((IConverter) _newInstance);
      final File tmpDir = Files.createTempDir();
      String _absolutePath = tmpDir.getAbsolutePath();
      String _plus = ("file:" + _absolutePath);
      final URI agentUri = URI.create(_plus);
      Printing _printing = new Printing(System.out);
      IProgressMonitor _iProgressMonitor = BasicMonitor.toIProgressMonitor(_printing);
      final ArrayList<Object> args = Lists.<Object>newArrayList(targetPlatform, agentUri, _iProgressMonitor);
      Object[] _array = args.toArray();
      Object _invoke = converterMethod.invoke(converter, _array);
      final ITargetDefinition targetDef = ((ITargetDefinition) _invoke);
      ITargetLocation[] _targetLocations = targetDef.getTargetLocations();
      for (final ITargetLocation loc : _targetLocations) {
        if ((loc instanceof IUBundleContainer)) {
          final Method getIds = IUBundleContainer.class.getDeclaredMethod("getIds");
          final Method getVersions = IUBundleContainer.class.getDeclaredMethod("getVersions");
          getIds.setAccessible(true);
          getVersions.setAccessible(true);
          Object _invoke_1 = getIds.invoke(loc);
          final String[] ids = ((String[]) _invoke_1);
          Object _invoke_2 = getVersions.invoke(loc);
          final Version[] versions = ((Version[]) _invoke_2);
          String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(ids)));
          Assert.assertEquals(_head, "com.google.guava");
          Version _head_1 = IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions)));
          Version _parseVersion = Version.parseVersion("11.0.2.v201303041551");
          int _compareTo = _head_1.compareTo(_parseVersion);
          Assert.assertEquals(0, _compareTo);
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
