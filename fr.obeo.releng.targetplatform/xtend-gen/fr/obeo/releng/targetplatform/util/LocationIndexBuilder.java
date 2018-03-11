/**
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 */
package fr.obeo.releng.targetplatform.util;

import com.google.common.base.Function;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;
import com.google.inject.Inject;
import fr.obeo.releng.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.TargetContent;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.VarDefinition;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class LocationIndexBuilder {
  @Inject
  private ImportUriResolver resolver;
  
  public ListMultimap<String, Location> getLocationIndex(final TargetPlatform targetPlatform) {
    this.searchAndAppendDefineFromIncludedTpd(targetPlatform);
    final List<Location> locationList = this.getLocations(
      CollectionLiterals.<TargetPlatform>newLinkedHashSet(targetPlatform), 
      CollectionLiterals.<TargetPlatform>newLinkedList(targetPlatform));
    final Function<Location, String> _function = new Function<Location, String>() {
      @Override
      public String apply(final Location it) {
        return it.getUri();
      }
    };
    return LinkedListMultimap.<String, Location>create(Multimaps.<String, Location>index(locationList, _function));
  }
  
  private void searchAndAppendDefineFromIncludedTpd(final TargetPlatform targetPlatform) {
    final HashSet<TargetPlatform> alreadyVisitedTarget = CollectionLiterals.<TargetPlatform>newHashSet();
    this.searchAndAppendDefineFromIncludedTpd(targetPlatform, alreadyVisitedTarget);
  }
  
  private void searchAndAppendDefineFromIncludedTpd(final TargetPlatform targetPlatform, final Set<TargetPlatform> alreadyVisitedTarget) {
    final HashSet<VarDefinition> ImportedDefineFromSubTpd = CollectionLiterals.<VarDefinition>newHashSet();
    final LinkedList<TargetPlatform> processedTargetPlatform = CollectionLiterals.<TargetPlatform>newLinkedList();
    alreadyVisitedTarget.add(targetPlatform);
    List<TargetPlatform> directlyImportedTargetPlatforms = this.searchDirectlyImportedTpd(targetPlatform);
    while ((directlyImportedTargetPlatforms.size() > processedTargetPlatform.size())) {
      {
        final Function1<TargetPlatform, Boolean> _function = new Function1<TargetPlatform, Boolean>() {
          @Override
          public Boolean apply(final TargetPlatform it) {
            boolean _contains = alreadyVisitedTarget.contains(it);
            return Boolean.valueOf((!_contains));
          }
        };
        final Function1<TargetPlatform, Boolean> _function_1 = new Function1<TargetPlatform, Boolean>() {
          @Override
          public Boolean apply(final TargetPlatform it) {
            boolean _contains = processedTargetPlatform.contains(it);
            return Boolean.valueOf((!_contains));
          }
        };
        final Consumer<TargetPlatform> _function_2 = new Consumer<TargetPlatform>() {
          @Override
          public void accept(final TargetPlatform it) {
            TargetPlatform notProcessedTargetPlatform = it;
            LocationIndexBuilder.this.searchAndAppendDefineFromIncludedTpd(notProcessedTargetPlatform, CollectionLiterals.<TargetPlatform>newHashSet(((TargetPlatform[])Conversions.unwrapArray(alreadyVisitedTarget, TargetPlatform.class))));
            final Consumer<TargetContent> _function = new Consumer<TargetContent>() {
              @Override
              public void accept(final TargetContent it) {
                if ((it instanceof VarDefinition)) {
                  ImportedDefineFromSubTpd.add(((VarDefinition)it));
                }
              }
            };
            notProcessedTargetPlatform.getContents().forEach(_function);
          }
        };
        IterableExtensions.<TargetPlatform>filter(IterableExtensions.<TargetPlatform>filter(directlyImportedTargetPlatforms, _function), _function_1).forEach(_function_2);
        final Function1<TargetPlatform, Boolean> _function_3 = new Function1<TargetPlatform, Boolean>() {
          @Override
          public Boolean apply(final TargetPlatform it) {
            boolean _contains = processedTargetPlatform.contains(it);
            return Boolean.valueOf((!_contains));
          }
        };
        final Set<TargetPlatform> newlyProcessedTarget = IterableExtensions.<TargetPlatform>toSet(IterableExtensions.<TargetPlatform>filter(directlyImportedTargetPlatforms, _function_3));
        processedTargetPlatform.addAll(newlyProcessedTarget);
        this.mergeImportedDefine(targetPlatform, ImportedDefineFromSubTpd);
        directlyImportedTargetPlatforms = this.searchDirectlyImportedTpd(targetPlatform);
      }
    }
  }
  
  protected List<TargetPlatform> searchDirectlyImportedTpd(final TargetPlatform targetPlatform) {
    final Function1<IncludeDeclaration, TargetPlatform> _function = new Function1<IncludeDeclaration, TargetPlatform>() {
      @Override
      public TargetPlatform apply(final IncludeDeclaration it) {
        return LocationIndexBuilder.this.getImportedTargetPlatform(targetPlatform.eResource(), it);
      }
    };
    final Function1<TargetPlatform, Boolean> _function_1 = new Function1<TargetPlatform, Boolean>() {
      @Override
      public Boolean apply(final TargetPlatform it) {
        return Boolean.valueOf((it != null));
      }
    };
    return IterableExtensions.<TargetPlatform>toList(IterableExtensions.<TargetPlatform>filter(ListExtensions.<IncludeDeclaration, TargetPlatform>map(targetPlatform.getIncludes(), _function), _function_1));
  }
  
  /**
   * "variable define" of deepest include are override by "define" of lowest level
   */
  private void mergeImportedDefine(final TargetPlatform targetPlatform, final Set<VarDefinition> ImportedDefineFromSubTpd) {
    final HashSet<VarDefinition> toBeAddedDefine = CollectionLiterals.<VarDefinition>newHashSet();
    final EList<TargetContent> targetContent = targetPlatform.getContents();
    final Consumer<VarDefinition> _function = new Consumer<VarDefinition>() {
      @Override
      public void accept(final VarDefinition it) {
        final VarDefinition currentImportedDefine = it;
        final Function1<TargetContent, Boolean> _function = new Function1<TargetContent, Boolean>() {
          @Override
          public Boolean apply(final TargetContent it) {
            return Boolean.valueOf((it instanceof VarDefinition));
          }
        };
        final Function1<TargetContent, Boolean> _function_1 = new Function1<TargetContent, Boolean>() {
          @Override
          public Boolean apply(final TargetContent it) {
            boolean _xblockexpression = false;
            {
              final VarDefinition alreadyExistingDefine = ((VarDefinition) it);
              final String varName = alreadyExistingDefine.getName();
              boolean _equals = currentImportedDefine.getName().equals(varName);
              _xblockexpression = (!_equals);
            }
            return Boolean.valueOf(_xblockexpression);
          }
        };
        boolean toBeAdded = IterableExtensions.<TargetContent>forall(IterableExtensions.<TargetContent>filter(targetContent, _function), _function_1);
        if (toBeAdded) {
          toBeAddedDefine.add(currentImportedDefine);
        }
      }
    };
    ImportedDefineFromSubTpd.forEach(_function);
    targetContent.addAll(toBeAddedDefine);
  }
  
  private List<Location> getLocations(final Set<TargetPlatform> visited, final List<TargetPlatform> toBeVisited) {
    final ArrayList<Location> locations = CollectionLiterals.<Location>newArrayList();
    final Consumer<TargetPlatform> _function = new Consumer<TargetPlatform>() {
      @Override
      public void accept(final TargetPlatform it) {
        final LinkedList<IncludeDeclaration> includes = CollectionLiterals.<IncludeDeclaration>newLinkedList();
        final Consumer<TargetContent> _function = new Consumer<TargetContent>() {
          @Override
          public void accept(final TargetContent content) {
            if ((content instanceof Location)) {
              boolean _isEmpty = includes.isEmpty();
              boolean _not = (!_isEmpty);
              if (_not) {
                locations.addAll(LocationIndexBuilder.this.getLocationFromVisitedIncludes(it, includes, visited));
                includes.clear();
              }
              locations.add(((Location)content));
            } else {
              if ((content instanceof IncludeDeclaration)) {
                includes.add(((IncludeDeclaration)content));
              }
            }
          }
        };
        ListExtensions.<TargetContent>reverseView(it.getContents()).forEach(_function);
        boolean _isEmpty = includes.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          locations.addAll(LocationIndexBuilder.this.getLocationFromVisitedIncludes(it, includes, visited));
          includes.clear();
        }
      }
    };
    toBeVisited.forEach(_function);
    return locations;
  }
  
  private List<Location> getLocationFromVisitedIncludes(final TargetPlatform parent, final List<IncludeDeclaration> includes, final Set<TargetPlatform> visited) {
    final Function1<IncludeDeclaration, TargetPlatform> _function = new Function1<IncludeDeclaration, TargetPlatform>() {
      @Override
      public TargetPlatform apply(final IncludeDeclaration it) {
        return LocationIndexBuilder.this.getImportedTargetPlatform(parent.eResource(), it);
      }
    };
    final Function1<TargetPlatform, Boolean> _function_1 = new Function1<TargetPlatform, Boolean>() {
      @Override
      public Boolean apply(final TargetPlatform it) {
        boolean _contains = visited.contains(it);
        return Boolean.valueOf((!_contains));
      }
    };
    final List<TargetPlatform> importedLocation = IterableExtensions.<TargetPlatform>toList(IterableExtensions.<TargetPlatform>filter(IterableExtensions.<TargetPlatform>filterNull(ListExtensions.<IncludeDeclaration, TargetPlatform>map(includes, _function)), _function_1));
    visited.addAll(importedLocation);
    return this.getLocations(visited, importedLocation);
  }
  
  /**
   * Returns all imported target platforms in a BSF fashion. The returned collection has
   * an iteration order reflecting the import overriding: the last import override precedent ones
   * and the deepest import is of least importance. E.g.
   * A includes B, C and D
   * B includes E, F and G
   * C includes H, I and J
   * D includes K, L and M
   * 
   * The returned collection for A is : D, C, B, M, L, K, J, I, H, G, F, E
   */
  public LinkedList<TargetPlatform> getImportedTargetPlatforms(final TargetPlatform targetPlatform) {
    final LinkedHashSet<TargetPlatform> visited = CollectionLiterals.<TargetPlatform>newLinkedHashSet();
    final LinkedList<TargetPlatform> queue = CollectionLiterals.<TargetPlatform>newLinkedList();
    final LinkedList<TargetPlatform> includeRet = CollectionLiterals.<TargetPlatform>newLinkedList();
    queue.addLast(targetPlatform);
    visited.add(targetPlatform);
    while ((!queue.isEmpty())) {
      {
        final LinkedList<TargetPlatform> tr = CollectionLiterals.<TargetPlatform>newLinkedList();
        final TargetPlatform t = queue.removeLast();
        final Function1<IncludeDeclaration, TargetPlatform> _function = new Function1<IncludeDeclaration, TargetPlatform>() {
          @Override
          public TargetPlatform apply(final IncludeDeclaration it) {
            return LocationIndexBuilder.this.getImportedTargetPlatform(t.eResource(), it);
          }
        };
        Iterable<TargetPlatform> _filterNull = IterableExtensions.<TargetPlatform>filterNull(ListExtensions.<IncludeDeclaration, TargetPlatform>map(t.getIncludes(), _function));
        for (final TargetPlatform unvisited : _filterNull) {
          boolean _contains = visited.contains(unvisited);
          boolean _not = (!_contains);
          if (_not) {
            visited.add(unvisited);
            queue.addLast(unvisited);
            tr.addFirst(unvisited);
          }
        }
        includeRet.addAll(tr);
      }
    }
    return includeRet;
  }
  
  public List<TargetPlatform> checkIncludeCycle(final TargetPlatform targetPlatform) {
    final LinkedHashSet<TargetPlatform> acc = CollectionLiterals.<TargetPlatform>newLinkedHashSet();
    final LinkedList<TargetPlatform> s = CollectionLiterals.<TargetPlatform>newLinkedList();
    this.searchAndAppendDefineFromIncludedTpd(targetPlatform);
    List<TargetPlatform> _xifexpression = null;
    boolean _checkIncludeCycle = this.checkIncludeCycle(targetPlatform, acc, s);
    if (_checkIncludeCycle) {
      _xifexpression = ListExtensions.<TargetPlatform>reverse(s);
    } else {
      _xifexpression = CollectionLiterals.<TargetPlatform>newImmutableList();
    }
    return _xifexpression;
  }
  
  private boolean checkIncludeCycle(final TargetPlatform targetPlatform, final Set<TargetPlatform> visited, final LinkedList<TargetPlatform> s) {
    s.addFirst(targetPlatform);
    final Resource context = targetPlatform.eResource();
    final Function1<IncludeDeclaration, TargetPlatform> _function = new Function1<IncludeDeclaration, TargetPlatform>() {
      @Override
      public TargetPlatform apply(final IncludeDeclaration it) {
        return LocationIndexBuilder.this.getImportedTargetPlatform(context, it);
      }
    };
    final Set<TargetPlatform> includedTPs = IterableExtensions.<TargetPlatform>toSet(IterableExtensions.<TargetPlatform>filterNull(ListExtensions.<IncludeDeclaration, TargetPlatform>map(targetPlatform.getIncludes(), _function)));
    for (final TargetPlatform includedTP : includedTPs) {
      {
        boolean _contains = s.contains(includedTP);
        if (_contains) {
          s.addFirst(includedTP);
          return true;
        }
        visited.add(includedTP);
        boolean _checkIncludeCycle = this.checkIncludeCycle(includedTP, visited, s);
        if (_checkIncludeCycle) {
          return true;
        }
      }
    }
    s.removeFirst();
    return false;
  }
  
  public TargetPlatform getImportedTargetPlatform(final Resource context, final IncludeDeclaration include) {
    TargetPlatform ret = null;
    include.generateImportURI();
    final Resource resource = EcoreUtil2.getResource(context, this.resolver.resolve(include));
    EList<EObject> _contents = null;
    if (resource!=null) {
      _contents=resource.getContents();
    }
    EObject _head = null;
    if (_contents!=null) {
      _head=IterableExtensions.<EObject>head(_contents);
    }
    EObject root = _head;
    if ((root instanceof TargetPlatform)) {
      ret = ((TargetPlatform) root);
    }
    return ret;
  }
}
