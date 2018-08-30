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

import com.google.common.collect.ListMultimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collections;
import org.eclipse.cbi.targetplatform.TargetPlatformInjectorProvider;
import org.eclipse.cbi.targetplatform.model.Location;
import org.eclipse.cbi.targetplatform.model.TargetPlatform;
import org.eclipse.cbi.targetplatform.util.LocationIndexBuilder;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(TargetPlatformInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class TestTargetPlatformIndexer {
  @Inject
  private ParseHelper<TargetPlatform> parser;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private LocationIndexBuilder indexBuilder;
  
  @Test
  public void testIncludeOverrideOrder() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"o\" include \"a.tpd\" include \"b.tpd\" include \"c.tpd\"");
      final TargetPlatform o = this.parser.parse(_builder, 
        URI.createURI("tmp:/o.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"a\" include \"d.tpd\" include \"e.tpd\" include \"f.tpd\"");
      this.parser.parse(_builder_1, 
        URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"b\" include \"g.tpd\" include \"h.tpd\" include \"i.tpd\"");
      this.parser.parse(_builder_2, 
        URI.createURI("tmp:/b.tpd"), resourceSet);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("target \"c\" include \"j.tpd\" include \"k.tpd\" include \"l.tpd\"");
      this.parser.parse(_builder_3, 
        URI.createURI("tmp:/c.tpd"), resourceSet);
      for (final String tp : Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("d", "e", "f", "g", "h", "i", "j", "k", "l"))) {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("target \"");
        _builder_4.append(tp);
        _builder_4.append("\"");
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("tmp:/");
        _builder_5.append(tp);
        _builder_5.append(".tpd");
        this.parser.parse(_builder_4, 
          URI.createURI(_builder_5.toString()), resourceSet);
      }
      final Function1<TargetPlatform, String> _function = (TargetPlatform it) -> {
        return it.getName();
      };
      Assert.assertEquals(
        Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("c", "b", "a", "l", "k", "j", "i", "h", "g", "f", "e", "d")), 
        ListExtensions.<TargetPlatform, String>map(this.indexBuilder.getImportedTargetPlatforms(o), _function));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncludeOverrideOrder2() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"o\" include \"a.tpd\" include \"b.tpd\" include \"c.tpd\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("location \"o1\"");
      _builder.newLine();
      final TargetPlatform o = this.parser.parse(_builder, 
        URI.createURI("tmp:/o.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"a\" include \"d.tpd\" include \"e.tpd\" include \"f.tpd\"");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("location \"a1\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, 
        URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"b\" include \"g.tpd\" include \"h.tpd\" include \"i.tpd\"");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("location \"b1\"");
      this.parser.parse(_builder_2, 
        URI.createURI("tmp:/b.tpd"), resourceSet);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("target \"c\" include \"j.tpd\" include \"k.tpd\" include \"l.tpd\"");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("location \"c1\"");
      this.parser.parse(_builder_3, 
        URI.createURI("tmp:/c.tpd"), resourceSet);
      for (final String tp : Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("d", "e", "f", "g", "h", "i", "j", "k", "l"))) {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("target \"");
        _builder_4.append(tp);
        _builder_4.append("\"");
        _builder_4.newLineIfNotEmpty();
        _builder_4.append("\t\t\t");
        _builder_4.append("location \"");
        _builder_4.append(tp, "\t\t\t");
        _builder_4.append("1\"");
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("tmp:/");
        _builder_5.append(tp);
        _builder_5.append(".tpd");
        this.parser.parse(_builder_4, 
          URI.createURI(_builder_5.toString()), resourceSet);
      }
      Assert.assertArrayEquals(
        new Object[] { "o1", "c1", "l1", "k1", "j1", "b1", "i1", "h1", "g1", "a1", "f1", "e1", "d1" }, 
        ((Object[])Conversions.unwrapArray(this.indexBuilder.getLocationIndex(o).keySet(), Object.class)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncludeOverrideOrder3() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"o\" ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("include \"a.tpd\" ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("include \"b.tpd\" ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("location \"o1\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("include \"c.tpd\"");
      _builder.newLine();
      final TargetPlatform o = this.parser.parse(_builder, 
        URI.createURI("tmp:/o.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"a\" ");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("include \"d.tpd\" ");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("location \"a1\"");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("include \"e.tpd\" ");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("include \"f.tpd\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, 
        URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"b\" ");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("location \"b1\"");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("include \"g.tpd\" ");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("include \"h.tpd\" ");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("include \"i.tpd\"");
      this.parser.parse(_builder_2, 
        URI.createURI("tmp:/b.tpd"), resourceSet);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("target \"c\" ");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("include \"j.tpd\" ");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("include \"k.tpd\" ");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("include \"l.tpd\"");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("location \"c1\"");
      this.parser.parse(_builder_3, 
        URI.createURI("tmp:/c.tpd"), resourceSet);
      for (final String tp : Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("d", "e", "f", "g", "h", "i", "j", "k", "l"))) {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("target \"");
        _builder_4.append(tp);
        _builder_4.append("\"");
        _builder_4.newLineIfNotEmpty();
        _builder_4.append("\t\t\t");
        _builder_4.append("location \"");
        _builder_4.append(tp, "\t\t\t");
        _builder_4.append("1\"");
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("tmp:/");
        _builder_5.append(tp);
        _builder_5.append(".tpd");
        this.parser.parse(_builder_4, 
          URI.createURI(_builder_5.toString()), resourceSet);
      }
      Assert.assertArrayEquals(
        new Object[] { "c1", "l1", "k1", "j1", "o1", "i1", "h1", "g1", "b1", "f1", "e1", "a1", "d1" }, 
        ((Object[])Conversions.unwrapArray(this.indexBuilder.getLocationIndex(o).keySet(), Object.class)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRemoteInclude() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"o\" ");
      _builder.newLine();
      _builder.append("include \"http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.git/plain/org.eclipse.emf.compare-parent/targetPlatforms/kepler-sdk.targetplatform?id=e9fbfd866f648083df83174d566ee1b9d61daeca\" ");
      _builder.newLine();
      final TargetPlatform o = this.parser.parse(_builder, 
        URI.createURI("tmp:/o.tpd"), resourceSet);
      final ListMultimap<String, Location> index = this.indexBuilder.getLocationIndex(o);
      Assert.assertEquals(4, index.size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
