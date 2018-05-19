package fr.obeo.releng.targetplatform.tests.composite_elements;

import com.google.common.collect.ListMultimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import fr.obeo.releng.targetplatform.CompositeString;
import fr.obeo.releng.targetplatform.CompositeStringPart;
import fr.obeo.releng.targetplatform.IU;
import fr.obeo.releng.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.TargetContent;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider;
import fr.obeo.releng.targetplatform.VarDefinition;
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
public class TestVariableVariableDefinition {
  @Inject
  private ParseHelper<TargetPlatform> parser;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private LocationIndexBuilder indexBuilder;
  
  @Test
  public void testDefinitionFromVariableCallSimple1() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varCallDefTarget\"");
      _builder.newLine();
      _builder.append("define var1=\"val1\"");
      _builder.newLine();
      _builder.append("define var2=${var1}");
      _builder.newLine();
      final TargetPlatform varCallDefTarget = this.parser.parse(_builder, URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet);
      TargetContent _last = IterableExtensions.<TargetContent>last(varCallDefTarget.getContents());
      final VarDefinition varDef = ((VarDefinition) _last);
      Assert.assertEquals("var2", varDef.getName());
      Assert.assertEquals("val1", varDef.getValue().computeActualString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDefinitionFromVariableCallSimple2() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varCallDefTarget\"");
      _builder.newLine();
      _builder.append("define var1=\"val1\"");
      _builder.newLine();
      _builder.append("define var2=${var1}");
      _builder.newLine();
      _builder.append("define var3=${var2}");
      _builder.newLine();
      final TargetPlatform varCallDefTarget = this.parser.parse(_builder, URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet);
      TargetContent _last = IterableExtensions.<TargetContent>last(varCallDefTarget.getContents());
      final VarDefinition varDef = ((VarDefinition) _last);
      Assert.assertEquals("var3", varDef.getName());
      Assert.assertEquals("val1", varDef.getValue().computeActualString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDefinitionFromVariableCallSimple3() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varCallDefTarget\"");
      _builder.newLine();
      _builder.append("define var3=${var2}");
      _builder.newLine();
      _builder.append("define var2=${var1}");
      _builder.newLine();
      _builder.append("define var1=\"val1\"");
      _builder.newLine();
      final TargetPlatform varCallDefTarget = this.parser.parse(_builder, URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet);
      TargetContent _head = IterableExtensions.<TargetContent>head(varCallDefTarget.getContents());
      final VarDefinition varDef = ((VarDefinition) _head);
      Assert.assertEquals("var3", varDef.getName());
      Assert.assertEquals("val1", varDef.getValue().computeActualString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDefinitionFromVariableCallSimple4() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varCallDefTarget\"");
      _builder.newLine();
      _builder.append("define var1=\"val1\"");
      _builder.newLine();
      _builder.append("define var2=${var1} + \"_str2_\"");
      _builder.newLine();
      _builder.append("define var3=${var2} + \"_str3_\" + ${var1}");
      _builder.newLine();
      final TargetPlatform varCallDefTarget = this.parser.parse(_builder, URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet);
      TargetContent _last = IterableExtensions.<TargetContent>last(varCallDefTarget.getContents());
      final VarDefinition varDef = ((VarDefinition) _last);
      Assert.assertEquals("var3", varDef.getName());
      Assert.assertEquals("val1_str2__str3_val1", varDef.getValue().computeActualString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDefinitionFromNestedVariableCall() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varCallDefTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("define subDirNameRef = ${subDirName} + \"/\"");
      _builder.newLine();
      _builder.append("include ${subDirNameRef} + \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform varCallDefTarget = this.parser.parse(_builder, URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("define subDirName=\"subdir\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subInclude\"");
      _builder_2.newLine();
      _builder_2.append("include \"subSubInclude.tpd\"");
      _builder_2.newLine();
      _builder_2.append("define emfVer = \"[\" + ${emfVerStart} + \",\" + ${emfVerEnd} + \")\"");
      _builder_2.newLine();
      _builder_2.append("define someLocationUri = ${serverAddress} + \"modeling/emf/emf/updates/2.9.x/core/R201402030812/\"");
      _builder_2.newLine();
      _builder_2.append("location ${someLocationUri} {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("org.eclipse.emf.sdk.feature.group ${emfVer}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("target \"subSubInclude\"");
      _builder_3.newLine();
      _builder_3.append("define serverAddress = \"http://download.eclipse.org/\"");
      _builder_3.newLine();
      _builder_3.append("define emfVerStart = \"2.9.2\"");
      _builder_3.newLine();
      _builder_3.append("define emfVerEnd = \"3.0.0\"");
      _builder_3.newLine();
      this.parser.parse(_builder_3, URI.createURI("tmp:/subdir/subSubInclude.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(varCallDefTarget);
      Assert.assertEquals(1, locationIndex.size());
      final CompositeString compositeImportURI = IterableExtensions.<IncludeDeclaration>last(varCallDefTarget.getIncludes()).getCompositeImportURI();
      Assert.assertEquals("subdir/", IterableExtensions.<CompositeStringPart>head(compositeImportURI.getStringParts()).getActualString());
      final LinkedList<TargetPlatform> importedTargetPlatforms = this.indexBuilder.getImportedTargetPlatforms(varCallDefTarget);
      final TargetPlatform targetPlatform = importedTargetPlatforms.getFirst();
      Assert.assertEquals("subInclude", targetPlatform.getName());
      final Location location = IterableExtensions.<Location>last(targetPlatform.getLocations());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", location.getUri());
      Assert.assertEquals("[2.9.2,3.0.0)", IterableExtensions.<IU>head(location.getIus()).getVersion());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDefinitionFromNestedVariableCallOverload1() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varCallDefTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("define var1 = ${var2}");
      _builder.newLine();
      _builder.append("define var2b = \"value2\"");
      _builder.newLine();
      final TargetPlatform varCallDefTarget = this.parser.parse(_builder, URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("define var2 = ${var2b}");
      _builder_1.newLine();
      _builder_1.append("define var2b = \"value2Sub\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(varCallDefTarget);
      Assert.assertEquals(0, locationIndex.size());
      TargetContent _get = varCallDefTarget.getContents().get(1);
      final VarDefinition varDef = ((VarDefinition) _get);
      Assert.assertEquals("var1", varDef.getName());
      Assert.assertEquals("value2", varDef.getValue().computeActualString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDefinitionFromNestedVariableCallOverload2() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varCallDefTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("define var1 = ${var2}");
      _builder.newLine();
      final TargetPlatform varCallDefTarget = this.parser.parse(_builder, URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("include \"subSubTpd.tpd\"");
      _builder_1.newLine();
      _builder_1.append("define var2 = ${var3}");
      _builder_1.newLine();
      _builder_1.append("define var4 = \"sub\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subSubTpd\"");
      _builder_2.newLine();
      _builder_2.append("define var3 = ${var4}");
      _builder_2.newLine();
      _builder_2.append("define var4 = \"subSub\"");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/subSubTpd.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(varCallDefTarget);
      Assert.assertEquals(0, locationIndex.size());
      TargetContent _get = varCallDefTarget.getContents().get(1);
      final VarDefinition varDef = ((VarDefinition) _get);
      Assert.assertEquals("var1", varDef.getName());
      Assert.assertEquals("sub", varDef.getValue().computeActualString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDefinitionFromNestedVariableCallOverload3() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varCallDefTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("define var1 = ${var2}");
      _builder.newLine();
      _builder.append("define var4 = \"value4\"");
      _builder.newLine();
      final TargetPlatform varCallDefTarget = this.parser.parse(_builder, URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("define var2 = ${var3}");
      _builder_1.newLine();
      _builder_1.append("define var3 = ${var4}");
      _builder_1.newLine();
      _builder_1.append("define var4 = \"value4Sub\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(varCallDefTarget);
      Assert.assertEquals(0, locationIndex.size());
      TargetContent _get = varCallDefTarget.getContents().get(1);
      final VarDefinition varDef = ((VarDefinition) _get);
      Assert.assertEquals("var1", varDef.getName());
      Assert.assertEquals("value4", varDef.getValue().computeActualString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDefinitionFromNestedVariableCallOverload4() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varCallDefTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("define var1 = ${var2} + \"_\" + ${var4} + \"_\" + ${var5}");
      _builder.newLine();
      _builder.append("define var4 = \"value4\"");
      _builder.newLine();
      _builder.append("define var6 = \"value6\"");
      _builder.newLine();
      final TargetPlatform varCallDefTarget = this.parser.parse(_builder, URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("define var2 = ${var3}");
      _builder_1.newLine();
      _builder_1.append("define var3 = ${var4}");
      _builder_1.newLine();
      _builder_1.append("define var4 = \"value4Sub\"");
      _builder_1.newLine();
      _builder_1.append("define var5 = ${var6}");
      _builder_1.newLine();
      _builder_1.append("define var6 = \"value6Sub\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(varCallDefTarget);
      Assert.assertEquals(0, locationIndex.size());
      TargetContent _get = varCallDefTarget.getContents().get(1);
      final VarDefinition varDef = ((VarDefinition) _get);
      Assert.assertEquals("var1", varDef.getName());
      Assert.assertEquals("value4_value4_value6", varDef.getValue().computeActualString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
