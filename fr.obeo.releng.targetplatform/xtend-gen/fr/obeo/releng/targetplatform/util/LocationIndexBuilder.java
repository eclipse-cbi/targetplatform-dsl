package fr.obeo.releng.targetplatform.util;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;
import com.google.inject.Inject;
import fr.obeo.releng.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.TargetContent;
import fr.obeo.releng.targetplatform.TargetPlatform;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class LocationIndexBuilder {
  @Inject
  private ImportUriResolver resolver;
  
  public ListMultimap<String, Location> getLocationIndex(final TargetPlatform targetPlatform) {
    LinkedHashSet<TargetPlatform> _newLinkedHashSet = CollectionLiterals.<TargetPlatform>newLinkedHashSet(targetPlatform);
    LinkedList<TargetPlatform> _newLinkedList = CollectionLiterals.<TargetPlatform>newLinkedList(targetPlatform);
    final List<Location> locationList = this.getLocations(_newLinkedHashSet, _newLinkedList);
    final Function<Location, String> _function = new Function<Location, String>() {
      public String apply(final Location it) {
        return it.getUri();
      }
    };
    ImmutableListMultimap<String, Location> _index = Multimaps.<String, Location>index(locationList, _function);
    return LinkedListMultimap.<String, Location>create(_index);
  }
  
  private List<Location> getLocations(final Set<TargetPlatform> visited, final List<TargetPlatform> toBeVisited) {
    final ArrayList<Location> locations = CollectionLiterals.<Location>newArrayList();
    final Procedure1<TargetPlatform> _function = new Procedure1<TargetPlatform>() {
      public void apply(final TargetPlatform it) {
        final LinkedList<IncludeDeclaration> includes = CollectionLiterals.<IncludeDeclaration>newLinkedList();
        EList<TargetContent> _contents = it.getContents();
        List<TargetContent> _reverseView = ListExtensions.<TargetContent>reverseView(_contents);
        final Procedure1<TargetContent> _function = new Procedure1<TargetContent>() {
          public void apply(final TargetContent content) {
            if ((content instanceof Location)) {
              boolean _isEmpty = includes.isEmpty();
              boolean _not = (!_isEmpty);
              if (_not) {
                List<Location> _locationFromVisitedIncludes = LocationIndexBuilder.this.getLocationFromVisitedIncludes(it, includes, visited);
                locations.addAll(_locationFromVisitedIncludes);
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
        IterableExtensions.<TargetContent>forEach(_reverseView, _function);
        boolean _isEmpty = includes.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          List<Location> _locationFromVisitedIncludes = LocationIndexBuilder.this.getLocationFromVisitedIncludes(it, includes, visited);
          locations.addAll(_locationFromVisitedIncludes);
          includes.clear();
        }
      }
    };
    IterableExtensions.<TargetPlatform>forEach(toBeVisited, _function);
    return locations;
  }
  
  private List<Location> getLocationFromVisitedIncludes(final TargetPlatform parent, final List<IncludeDeclaration> includes, final Set<TargetPlatform> visited) {
    final Function1<IncludeDeclaration, TargetPlatform> _function = new Function1<IncludeDeclaration, TargetPlatform>() {
      public TargetPlatform apply(final IncludeDeclaration it) {
        Resource _eResource = parent.eResource();
        return LocationIndexBuilder.this.getImportedTargetPlatform(_eResource, it);
      }
    };
    List<TargetPlatform> _map = ListExtensions.<IncludeDeclaration, TargetPlatform>map(includes, _function);
    Iterable<TargetPlatform> _filterNull = IterableExtensions.<TargetPlatform>filterNull(_map);
    final Function1<TargetPlatform, Boolean> _function_1 = new Function1<TargetPlatform, Boolean>() {
      public Boolean apply(final TargetPlatform it) {
        boolean _contains = visited.contains(it);
        return Boolean.valueOf((!_contains));
      }
    };
    Iterable<TargetPlatform> _filter = IterableExtensions.<TargetPlatform>filter(_filterNull, _function_1);
    final List<TargetPlatform> importedLocation = IterableExtensions.<TargetPlatform>toList(_filter);
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
    boolean _isEmpty = queue.isEmpty();
    boolean _not = (!_isEmpty);
    boolean _while = _not;
    while (_while) {
      {
        final LinkedList<TargetPlatform> tr = CollectionLiterals.<TargetPlatform>newLinkedList();
        final TargetPlatform t = queue.removeLast();
        EList<IncludeDeclaration> _includes = t.getIncludes();
        final Function1<IncludeDeclaration, TargetPlatform> _function = new Function1<IncludeDeclaration, TargetPlatform>() {
          public TargetPlatform apply(final IncludeDeclaration it) {
            Resource _eResource = t.eResource();
            return LocationIndexBuilder.this.getImportedTargetPlatform(_eResource, it);
          }
        };
        List<TargetPlatform> _map = ListExtensions.<IncludeDeclaration, TargetPlatform>map(_includes, _function);
        Iterable<TargetPlatform> _filterNull = IterableExtensions.<TargetPlatform>filterNull(_map);
        for (final TargetPlatform unvisited : _filterNull) {
          boolean _contains = visited.contains(unvisited);
          boolean _not_1 = (!_contains);
          if (_not_1) {
            visited.add(unvisited);
            queue.addLast(unvisited);
            tr.addFirst(unvisited);
          }
        }
        includeRet.addAll(tr);
      }
      boolean _isEmpty_1 = queue.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      _while = _not_1;
    }
    return includeRet;
  }
  
  public List<TargetPlatform> checkIncludeCycle(final TargetPlatform targetPlatform) {
    final LinkedHashSet<TargetPlatform> acc = CollectionLiterals.<TargetPlatform>newLinkedHashSet();
    final LinkedList<TargetPlatform> s = CollectionLiterals.<TargetPlatform>newLinkedList();
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
    EList<IncludeDeclaration> _includes = targetPlatform.getIncludes();
    final Function1<IncludeDeclaration, TargetPlatform> _function = new Function1<IncludeDeclaration, TargetPlatform>() {
      public TargetPlatform apply(final IncludeDeclaration it) {
        return LocationIndexBuilder.this.getImportedTargetPlatform(context, it);
      }
    };
    List<TargetPlatform> _map = ListExtensions.<IncludeDeclaration, TargetPlatform>map(_includes, _function);
    Iterable<TargetPlatform> _filterNull = IterableExtensions.<TargetPlatform>filterNull(_map);
    final Set<TargetPlatform> includedTPs = IterableExtensions.<TargetPlatform>toSet(_filterNull);
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
    String _resolve = this.resolver.resolve(include);
    final Resource resource = EcoreUtil2.getResource(context, _resolve);
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
