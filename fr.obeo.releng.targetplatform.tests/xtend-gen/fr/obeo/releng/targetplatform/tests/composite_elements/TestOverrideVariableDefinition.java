package fr.obeo.releng.targetplatform.tests.composite_elements;

import com.google.common.collect.ListMultimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import fr.obeo.releng.targetplatform.CompositeString;
import fr.obeo.releng.targetplatform.CompositeStringPart;
import fr.obeo.releng.targetplatform.IU;
import fr.obeo.releng.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider;
import fr.obeo.releng.targetplatform.util.ImportVariableManager;
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder;
import java.util.LinkedList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(TargetPlatformInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class TestOverrideVariableDefinition {
  @Inject
  private ParseHelper<TargetPlatform> parser;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private LocationIndexBuilder indexBuilder;
  
  @Inject
  private ImportVariableManager importVariableManager;
  
  @Test
  public void testVarDefinitionOverride1() {
    try {
      final String[] args = { "overrideDefTarget.tpd", "var1=overrideVal1", "var3=override val 3" };
      this.importVariableManager.processCommandLineArguments(args);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"overrideDefTarget\"");
      _builder.newLine();
      _builder.append("define var1=\"val1\"");
      _builder.newLine();
      _builder.append("define var2=\"val2\"");
      _builder.newLine();
      _builder.append("define var3=\"val3\"");
      _builder.newLine();
      _builder.append("include ${var1} + ${var2} + ${var3}");
      _builder.newLine();
      final TargetPlatform overrideDefTarget = this.parser.parse(_builder, URI.createURI("tmp:/overrideDefTarget.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(overrideDefTarget);
      Assert.assertEquals(0, locationIndex.size());
      final IncludeDeclaration include = IterableExtensions.<IncludeDeclaration>head(overrideDefTarget.getIncludes());
      Assert.assertEquals("overrideVal1val2override val 3", include.getImportURI());
      this.importVariableManager.clear();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testVarDefinitionOverride2() {
    try {
      final String[] args = { "overrideDefTarget.tpd", "subDirName=subdir", "emfVer=[2.9.2,3.0.0)" };
      this.importVariableManager.processCommandLineArguments(args);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"overrideDefTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("include ${subDirName} + \"/\" + \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform overrideDefTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("define subDirName=\"subdirNotOverride\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subInclude\"");
      _builder_2.newLine();
      _builder_2.append("define emfVer = \"[2.9.2,2.9.3)\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\" {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("org.eclipse.emf.sdk.feature.group ${emfVer}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(overrideDefTarget);
      Assert.assertEquals(1, locationIndex.size());
      final CompositeString compositeImportURI = IterableExtensions.<IncludeDeclaration>last(overrideDefTarget.getIncludes()).getCompositeImportURI();
      Assert.assertEquals("subdir", IterableExtensions.<CompositeStringPart>head(compositeImportURI.getStringParts()).getActualString());
      final LinkedList<TargetPlatform> importedTargetPlatforms = this.indexBuilder.getImportedTargetPlatforms(overrideDefTarget);
      final TargetPlatform targetPlatform = importedTargetPlatforms.getFirst();
      Assert.assertEquals("subInclude", targetPlatform.getName());
      final Location location = IterableExtensions.<Location>last(targetPlatform.getLocations());
      Assert.assertEquals("[2.9.2,3.0.0)", IterableExtensions.<IU>head(location.getIus()).getVersion());
      this.importVariableManager.clear();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
