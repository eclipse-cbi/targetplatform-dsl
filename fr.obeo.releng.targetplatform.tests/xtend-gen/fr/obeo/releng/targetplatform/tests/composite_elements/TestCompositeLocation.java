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
import fr.obeo.releng.targetplatform.VarCall;
import fr.obeo.releng.targetplatform.VarDefinition;
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder;
import java.util.LinkedList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(TargetPlatformInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class TestCompositeLocation {
  @Inject
  private ParseHelper<TargetPlatform> parser;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private LocationIndexBuilder indexBuilder;
  
  @Test
  public void testIncludeWithMultipleStaticString() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("include \"subdir\" + \"/\" + \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subInclude\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("org.eclipse.emf.sdk.feature.group");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet);
      final LinkedList<TargetPlatform> importedTargetPlatforms = this.indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget);
      Assert.assertEquals(1, ((Object[])Conversions.unwrapArray(importedTargetPlatforms, Object.class)).length);
      final TargetPlatform targetPlatform = importedTargetPlatforms.getFirst();
      Assert.assertEquals("subInclude", targetPlatform.getName());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", IterableExtensions.<Location>last(targetPlatform.getLocations()).getUri());
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", IterableExtensions.<IU>last(IterableExtensions.<Location>last(targetPlatform.getLocations()).getIus()).getID());
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(compositeIncludeTarget);
      Assert.assertEquals(1, locationIndex.size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncludeWithVarCall1() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("define subDirName=\"subdir\"");
      _builder.newLine();
      _builder.append("include ${subDirName} + \"/\" + \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subInclude\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("org.eclipse.emf.sdk.feature.group");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet);
      final CompositeString compositeImportURI = IterableExtensions.<IncludeDeclaration>last(compositeIncludeTarget.getIncludes()).getCompositeImportURI();
      Assert.assertEquals("subdir", IterableExtensions.<CompositeStringPart>head(compositeImportURI.getStringParts()).getActualString());
      final LinkedList<TargetPlatform> importedTargetPlatforms = this.indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget);
      final TargetPlatform targetPlatform = importedTargetPlatforms.getFirst();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", IterableExtensions.<Location>last(targetPlatform.getLocations()).getUri());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncludeWithVarCall2() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("define subDirName=\"subdir\"");
      _builder.newLine();
      _builder.append("define tpdFilename=\"subInclude.tpd\"");
      _builder.newLine();
      _builder.append("include ${subDirName} + \"/\" + ${tpdFilename}");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subInclude\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("org.eclipse.emf.sdk.feature.group");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet);
      final CompositeString compositeImportURI = IterableExtensions.<IncludeDeclaration>last(compositeIncludeTarget.getIncludes()).getCompositeImportURI();
      Assert.assertEquals("subdir", IterableExtensions.<CompositeStringPart>head(compositeImportURI.getStringParts()).getActualString());
      Assert.assertEquals("subInclude.tpd", IterableExtensions.<CompositeStringPart>last(compositeImportURI.getStringParts()).getActualString());
      final LinkedList<TargetPlatform> importedTargetPlatforms = this.indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget);
      final TargetPlatform targetPlatform = importedTargetPlatforms.getFirst();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", IterableExtensions.<Location>last(targetPlatform.getLocations()).getUri());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncludeWithVarCallFromSubTpd() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("include ${subDirName} + \"/\" + \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("define subDirName=\"subdir\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subInclude\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\" {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("org.eclipse.emf.sdk.feature.group");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(compositeIncludeTarget);
      Assert.assertEquals(1, locationIndex.size());
      final CompositeString compositeImportURI = IterableExtensions.<IncludeDeclaration>last(compositeIncludeTarget.getIncludes()).getCompositeImportURI();
      Assert.assertEquals("subdir", IterableExtensions.<CompositeStringPart>head(compositeImportURI.getStringParts()).getActualString());
      final LinkedList<TargetPlatform> importedTargetPlatforms = this.indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget);
      final TargetPlatform targetPlatform = importedTargetPlatforms.getFirst();
      Assert.assertEquals("subInclude", targetPlatform.getName());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", IterableExtensions.<Location>last(targetPlatform.getLocations()).getUri());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncludeWithVarCallFromSubTpd2() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("define subTpdFile=\"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("include ${subTpdFile}");
      _builder.newLine();
      _builder.append("include ${subDirName} + \"/\" + \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("define subDirName=\"subdir\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subInclude\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\" {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("org.eclipse.emf.sdk.feature.group");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(compositeIncludeTarget);
      Assert.assertEquals(1, locationIndex.size());
      final CompositeString compositeImportURI = IterableExtensions.<IncludeDeclaration>last(compositeIncludeTarget.getIncludes()).getCompositeImportURI();
      Assert.assertEquals("subdir", IterableExtensions.<CompositeStringPart>head(compositeImportURI.getStringParts()).getActualString());
      final LinkedList<TargetPlatform> importedTargetPlatforms = this.indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget);
      final TargetPlatform targetPlatform = importedTargetPlatforms.getFirst();
      Assert.assertEquals("subInclude", targetPlatform.getName());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", IterableExtensions.<Location>last(targetPlatform.getLocations()).getUri());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncludeWithVarCallFromSubSubTpd() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("include ${subDirName} + \"/\" + \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("include \"subsubTpd.tpd\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subsubTpd\"");
      _builder_2.newLine();
      _builder_2.append("define subDirName=\"subdir\"");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/subsubTpd.tpd"), resourceSet);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("target \"subInclude\"");
      _builder_3.newLine();
      _builder_3.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\" {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("org.eclipse.emf.sdk.feature.group");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this.parser.parse(_builder_3, URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(compositeIncludeTarget);
      Assert.assertEquals(1, locationIndex.size());
      final CompositeString compositeImportURI = IterableExtensions.<IncludeDeclaration>last(compositeIncludeTarget.getIncludes()).getCompositeImportURI();
      Assert.assertEquals("subdir", IterableExtensions.<CompositeStringPart>head(compositeImportURI.getStringParts()).getActualString());
      final LinkedList<TargetPlatform> importedTargetPlatforms = this.indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget);
      Assert.assertEquals(3, importedTargetPlatforms.size());
      final TargetPlatform targetPlatform = importedTargetPlatforms.getFirst();
      Assert.assertEquals("subInclude", targetPlatform.getName());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", IterableExtensions.<Location>last(targetPlatform.getLocations()).getUri());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncludeWithVarDefintionOverride1() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("include ${subDirName} + \"/\" + \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("include \"subsubTpd.tpd\"");
      _builder_1.newLine();
      _builder_1.append("define subDirName=\"subdir\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subsubTpd\"");
      _builder_2.newLine();
      _builder_2.append("define subDirName=\"wrongSubdir\"");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/subsubTpd.tpd"), resourceSet);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("target \"subInclude\"");
      _builder_3.newLine();
      _builder_3.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\" {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("org.eclipse.emf.sdk.feature.group");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this.parser.parse(_builder_3, URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(compositeIncludeTarget);
      Assert.assertEquals(1, locationIndex.size());
      final CompositeString compositeImportURI = IterableExtensions.<IncludeDeclaration>last(compositeIncludeTarget.getIncludes()).getCompositeImportURI();
      Assert.assertEquals("subdir", IterableExtensions.<CompositeStringPart>head(compositeImportURI.getStringParts()).getActualString());
      final LinkedList<TargetPlatform> importedTargetPlatforms = this.indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget);
      final TargetPlatform targetPlatform = importedTargetPlatforms.getFirst();
      Assert.assertEquals("subInclude", targetPlatform.getName());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", IterableExtensions.<Location>last(targetPlatform.getLocations()).getUri());
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", IterableExtensions.<IU>head(IterableExtensions.<Location>last(targetPlatform.getLocations()).getIus()).getID());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncludeWithVarDefintionOverride2() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("include ${subDirName} + \"/\" + \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("include \"subsubTpd.tpd\"");
      _builder_1.newLine();
      _builder_1.append("define subDirName=\"wrongSubdir\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subsubTpd\"");
      _builder_2.newLine();
      _builder_2.append("define subDirName=\"subdir\"");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/subsubTpd.tpd"), resourceSet);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("target \"subInclude\"");
      _builder_3.newLine();
      _builder_3.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\" {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("org.eclipse.emf.sdk.feature.group");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this.parser.parse(_builder_3, URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(compositeIncludeTarget);
      Assert.assertEquals(0, locationIndex.size());
      final CompositeString compositeImportURI = IterableExtensions.<IncludeDeclaration>last(compositeIncludeTarget.getIncludes()).getCompositeImportURI();
      Assert.assertEquals("wrongSubdir", IterableExtensions.<CompositeStringPart>head(compositeImportURI.getStringParts()).getActualString());
      CompositeStringPart _head = IterableExtensions.<CompositeStringPart>head(compositeImportURI.getStringParts());
      final VarCall varCall = ((VarCall) _head);
      Assert.assertEquals("subDirName", varCall.getVarName().getName());
      final LinkedList<TargetPlatform> importedTargetPlatforms = this.indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget);
      TargetContent _head_1 = IterableExtensions.<TargetContent>head(importedTargetPlatforms.getLast().getContents());
      final VarDefinition varDef = ((VarDefinition) _head_1);
      Assert.assertEquals("subdir", varDef.getValue().computeActualString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncludeGetLocationIndexCallmanyTimes() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("include ${subDirName} + \"/\" + \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("include \"subsubTpd.tpd\"");
      _builder_1.newLine();
      _builder_1.append("define subDirName=\"wrongSubdir\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subsubTpd\"");
      _builder_2.newLine();
      _builder_2.append("define subDirName=\"subdir\"");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/subsubTpd.tpd"), resourceSet);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("target \"subInclude\"");
      _builder_3.newLine();
      _builder_3.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\" {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("org.eclipse.emf.sdk.feature.group");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this.parser.parse(_builder_3, URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(compositeIncludeTarget);
      Assert.assertEquals(0, locationIndex.size());
      final CompositeString compositeImportURI = IterableExtensions.<IncludeDeclaration>last(compositeIncludeTarget.getIncludes()).getCompositeImportURI();
      Assert.assertEquals("wrongSubdir", IterableExtensions.<CompositeStringPart>head(compositeImportURI.getStringParts()).getActualString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCompositeLocation() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeLocationTarget\"");
      _builder.newLine();
      _builder.append("define locationUrl=\"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\"");
      _builder.newLine();
      _builder.append("location ${locationUrl} {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.sdk.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform compositeLocationTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeLocationTarget.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(compositeLocationTarget);
      Assert.assertEquals(1, locationIndex.size());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", IterableExtensions.<Location>head(compositeLocationTarget.getLocations()).getUri());
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", IterableExtensions.<IU>head(IterableExtensions.<Location>last(compositeLocationTarget.getLocations()).getIus()).getID());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCompositeLocation2() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeLocationTarget\"");
      _builder.newLine();
      _builder.append("define locationUrlBase=\"http://download.eclipse.org/\"");
      _builder.newLine();
      _builder.append("define locationUrlVersion=\"R201402030812/\"");
      _builder.newLine();
      _builder.append("location ${locationUrlBase} + \"modeling/emf/emf/updates/2.9.x/core/\" + ${locationUrlVersion} {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.sdk.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform compositeLocationTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeLocationTarget.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(compositeLocationTarget);
      Assert.assertEquals(1, locationIndex.size());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", IterableExtensions.<Location>head(compositeLocationTarget.getLocations()).getUri());
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", IterableExtensions.<IU>head(IterableExtensions.<Location>last(compositeLocationTarget.getLocations()).getIus()).getID());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCompositeLocationFromCompositeInclude() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("include \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("define locationUrlBase=\"http://download.eclipse.org/\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subInclude\"");
      _builder_2.newLine();
      _builder_2.append("include \"subTpd.tpd\"");
      _builder_2.newLine();
      _builder_2.append("define locationUrlVersion=\"R201402030812/\"");
      _builder_2.newLine();
      _builder_2.append("location ${locationUrlBase} + \"modeling/emf/emf/updates/2.9.x/core/\" + ${locationUrlVersion} {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("org.eclipse.emf.sdk.feature.group");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/subInclude.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(compositeIncludeTarget);
      Assert.assertEquals(1, locationIndex.size());
      final LinkedList<TargetPlatform> importedTargetPlatforms = this.indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget);
      final TargetPlatform targetPlatform = importedTargetPlatforms.getFirst();
      Assert.assertEquals("subInclude", targetPlatform.getName());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", IterableExtensions.<Location>last(targetPlatform.getLocations()).getUri());
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", IterableExtensions.<IU>head(IterableExtensions.<Location>last(targetPlatform.getLocations()).getIus()).getID());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUVersionFromVariable() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"uiVersionTarget\"");
      _builder.newLine();
      _builder.append("define emf.version.a=\"[2.10.0,3.0.0)\"");
      _builder.newLine();
      _builder.append("define emf.version.b = \"2.10.2\"");
      _builder.newLine();
      _builder.append("define emf.version.c = \"[1.2.0,2.0.0)\"");
      _builder.newLine();
      _builder.append("define emf.version.d = \"[1.2.1.v20140909-0808,1.2.1.v20140909-0808]\"");
      _builder.newLine();
      _builder.append("define emf.version.e = \"lazy\"");
      _builder.newLine();
      _builder.append("define emf.version.f = \"erroneousVersion\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.10.x/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.sdk.feature.group ${emf.version.a}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.sdk.source.feature.group ; version = ${emf.version.b}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.ecore.xcore.feature.group ${emf.version.c}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.ecore.xcore.source.feature.group ${emf.version.d}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.codegen.ecore.feature.group ${emf.version.e}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.codegen.ecore.xtext.source ${emf.version.f}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform uiVersionTarget = this.parser.parse(_builder, URI.createURI("tmp:/uiVersionTarget.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(uiVersionTarget);
      Assert.assertEquals(1, locationIndex.size());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.10.x/", IterableExtensions.<Location>head(uiVersionTarget.getLocations()).getUri());
      final Location location = IterableExtensions.<Location>head(locationIndex.values());
      final IU firstIU = location.getIus().get(0);
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", firstIU.getID());
      Assert.assertEquals("[2.10.0,3.0.0)", firstIU.getVersion());
      final IU secondIU = location.getIus().get(1);
      Assert.assertEquals("org.eclipse.emf.sdk.source.feature.group", secondIU.getID());
      Assert.assertEquals("2.10.2", secondIU.getVersion());
      final IU thirdIU = location.getIus().get(2);
      Assert.assertEquals("org.eclipse.emf.ecore.xcore.feature.group", thirdIU.getID());
      Assert.assertEquals("[1.2.0,2.0.0)", thirdIU.getVersion());
      final IU fourthIU = location.getIus().get(3);
      Assert.assertEquals("org.eclipse.emf.ecore.xcore.source.feature.group", fourthIU.getID());
      Assert.assertEquals("[1.2.1.v20140909-0808,1.2.1.v20140909-0808]", fourthIU.getVersion());
      final IU fifthIU = location.getIus().get(4);
      Assert.assertEquals("org.eclipse.emf.codegen.ecore.feature.group", fifthIU.getID());
      Assert.assertEquals("lazy", fifthIU.getVersion());
      final IU sixthIU = location.getIus().get(5);
      Assert.assertEquals("org.eclipse.emf.codegen.ecore.xtext.source", sixthIU.getID());
      Assert.assertEquals("erroneousVersion", sixthIU.getVersion());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUVersionFromSubTpd() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("include \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform uiVersionTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("define locationUrlBase=\"http://download.eclipse.org/\"");
      _builder_1.newLine();
      _builder_1.append("define emf.version=\"[2.10.0,3.0.0)\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subInclude\"");
      _builder_2.newLine();
      _builder_2.append("include \"subTpd.tpd\"");
      _builder_2.newLine();
      _builder_2.append("location ${locationUrlBase} + \"modeling/emf/emf/updates/2.9.x/\" {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("org.eclipse.emf.sdk.feature.group ${emf.version}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/subInclude.tpd"), resourceSet);
      final LinkedList<TargetPlatform> importedTargetPlatforms = this.indexBuilder.getImportedTargetPlatforms(uiVersionTarget);
      final Location location = IterableExtensions.<Location>head(IterableExtensions.<TargetPlatform>head(importedTargetPlatforms).getLocations());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/", location.getUri());
      final IU iu = location.getIus().get(0);
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", iu.getID());
      Assert.assertEquals("[2.10.0,3.0.0)", iu.getVersion());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
