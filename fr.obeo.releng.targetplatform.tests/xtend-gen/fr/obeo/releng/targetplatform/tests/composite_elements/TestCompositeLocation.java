package fr.obeo.releng.targetplatform.tests.composite_elements;

import com.google.common.collect.ListMultimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import fr.obeo.releng.targetplatform.IU;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider;
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
  public void testLocationWithMultipleStaticString() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget1\"");
      _builder.newLine();
      _builder.append("include \"subdir\" \"/\" \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget1 = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget1.tpd"), resourceSet);
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
      final LinkedList<TargetPlatform> importedTargetPlatforms = this.indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget1);
      Assert.assertEquals(1, ((Object[])Conversions.unwrapArray(importedTargetPlatforms, Object.class)).length);
      final TargetPlatform targetPlatform = importedTargetPlatforms.getFirst();
      Assert.assertEquals("subInclude", targetPlatform.getName());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", IterableExtensions.<Location>last(targetPlatform.getLocations()).getUri());
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", IterableExtensions.<IU>last(IterableExtensions.<Location>last(targetPlatform.getLocations()).getIus()).getID());
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(compositeIncludeTarget1);
      Assert.assertEquals(1, locationIndex.size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
