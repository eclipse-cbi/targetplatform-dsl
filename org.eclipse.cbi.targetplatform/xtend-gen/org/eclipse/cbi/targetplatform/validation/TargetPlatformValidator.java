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
package org.eclipse.cbi.targetplatform.validation;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import org.eclipse.cbi.targetplatform.Environment;
import org.eclipse.cbi.targetplatform.IU;
import org.eclipse.cbi.targetplatform.IncludeDeclaration;
import org.eclipse.cbi.targetplatform.Location;
import org.eclipse.cbi.targetplatform.Option;
import org.eclipse.cbi.targetplatform.Options;
import org.eclipse.cbi.targetplatform.TargetContent;
import org.eclipse.cbi.targetplatform.TargetPlatform;
import org.eclipse.cbi.targetplatform.TargetPlatformPackage;
import org.eclipse.cbi.targetplatform.services.TargetPlatformGrammarAccess;
import org.eclipse.cbi.targetplatform.util.LocationIndexBuilder;
import org.eclipse.cbi.targetplatform.validation.AbstractTargetPlatformValidator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Custom validation rules.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
@SuppressWarnings("all")
public class TargetPlatformValidator extends AbstractTargetPlatformValidator {
  @Inject
  private LocationIndexBuilder indexBuilder;
  
  @Inject
  private IProvisioningAgent provisioningAgent;
  
  @Inject
  private TargetPlatformGrammarAccess grammarAccess;
  
  public final static String CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED = "CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED";
  
  public final static String CHECK__OPTIONS_EQUALS_ALL_LOCATIONS = "CHECK__OPTIONS_EQUALS_ALL_LOCATIONS";
  
  public final static String CHECK__NO_OPTIONS_ON_LOCATIONS_IF_GLOBAL_OPTIONS = "CHECK__NO_OPTIONS_ON_LOCATIONS_IF_GLOBAL_OPTIONS";
  
  public final static String DEPRECATE__OPTIONS_ON_LOCATIONS = "DEPRECATE__OPTIONS_ON_LOCATIONS";
  
  public final static String DEPRECATE__STRINGS_ON_IU_VERSION = "DEPRECATE__STRINGS_ON_IU_VERSION";
  
  public final static String CHECK__LOCATION_CONFLICTUAL_ID = "CHECK__LOCATION_CONFLICTUAL_ID";
  
  public final static String CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID = "CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID";
  
  public final static String CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION = "CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID";
  
  public final static String CHECK__LOCATION_ID_UNIQNESS = "CHECK__LOCATION_ID_UNIQNESS";
  
  public final static String CHECK__INCLUDE_CYCLE = "CHECK__INCLUDE_CYCLE";
  
  public final static String CHECK__IU_IN_LOCATION = "CHECK__IU_IN_LOCATION";
  
  public final static String CHECK__LOCATION_URI = "CHECK__LOCATION_URI";
  
  public final static String CHECK__ENVIRONMENT_VALIDITY = "CHECK__ENVIRONMENT_VALIDITY";
  
  public final static String CHECK__ENVIRONMENT_UNICITY = "CHECK__ENVIRONMENT_UNICITY";
  
  public final static String CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS = "CHECK__ENVIRONMENT_COHESION";
  
  public final static String CHECK__ESCAPE_CHAR_IU_ID = " CHECK__ESCAPE_CHAR_IU_ID";
  
  public final static String CHECK__VERSION_KEYWORDS = "CHECK__VERSION_KEYWORDS";
  
  public final static String CHECK__OPTIONS_UNICITY = "CHECK__OPTIONS_UNICITY";
  
  public final static String CHECK__NO_DUPLICATE_OPTIONS_OPTIONS = "CHECK__NO_DUPLICATE_OPTIONS_OPTIONS";
  
  public final static String CHECK__NO_DUPLICATED_IU = "CHECK__NO_DUPLICATED_IU";
  
  @Check
  public void checkAllEnvAndRequiredAreSelfExluding(final TargetPlatform targetPlatform) {
    final Function1<Options, EList<Option>> _function = new Function1<Options, EList<Option>>() {
      @Override
      public EList<Option> apply(final Options it) {
        return it.getOptions();
      }
    };
    final Set<Option> allOptions = IterableExtensions.<Option>toSet(Iterables.<Option>concat(IterableExtensions.<Options, EList<Option>>map(Iterables.<Options>filter(targetPlatform.getContents(), Options.class), _function)));
    if ((allOptions.contains(Option.INCLUDE_ALL_ENVIRONMENTS) && allOptions.contains(Option.INCLUDE_REQUIRED))) {
      final Consumer<Options> _function_1 = new Consumer<Options>() {
        @Override
        public void accept(final Options it) {
          TargetPlatformValidator.this.doReportAllEnvAndRequiredAreSelfExluding(it, it.getOptions(), TargetPlatformPackage.Literals.OPTIONS__OPTIONS);
        }
      };
      Iterables.<Options>filter(targetPlatform.getContents(), Options.class).forEach(_function_1);
    }
  }
  
  @Check
  public void checkAllEnvAndRequiredAreSelfExluding(final Location location) {
    final EList<Option> options = location.getOptions();
    if ((options.contains(Option.INCLUDE_ALL_ENVIRONMENTS) && options.contains(Option.INCLUDE_REQUIRED))) {
      this.doReportAllEnvAndRequiredAreSelfExluding(location, options, TargetPlatformPackage.Literals.LOCATION__OPTIONS);
    }
  }
  
  private void doReportAllEnvAndRequiredAreSelfExluding(final EObject optionOwner, final List<Option> options, final EStructuralFeature feature) {
    boolean _contains = options.contains(Option.INCLUDE_REQUIRED);
    if (_contains) {
      this.error("All environments can not be included along with required artifacts, you must choose one of the two options.", optionOwner, feature, 
        options.indexOf(Option.INCLUDE_REQUIRED), TargetPlatformValidator.CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED);
    }
    boolean _contains_1 = options.contains(Option.INCLUDE_ALL_ENVIRONMENTS);
    if (_contains_1) {
      this.error("All environments can not be included along with required artifacts, you must choose one of the two options.", optionOwner, feature, 
        options.indexOf(Option.INCLUDE_ALL_ENVIRONMENTS), TargetPlatformValidator.CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED);
    }
  }
  
  @Check
  public void checkNoDuplicateOptions(final TargetPlatform targetPlatform) {
    final Function1<Options, EList<Option>> _function = new Function1<Options, EList<Option>>() {
      @Override
      public EList<Option> apply(final Options it) {
        return it.getOptions();
      }
    };
    final HashMultiset<Option> allOptions = HashMultiset.<Option>create(Iterables.<Option>concat(IterableExtensions.<Options, EList<Option>>map(Iterables.<Options>filter(targetPlatform.getContents(), Options.class), _function)));
    final Consumer<Multiset.Entry<Option>> _function_1 = new Consumer<Multiset.Entry<Option>>() {
      @Override
      public void accept(final Multiset.Entry<Option> e) {
        int _count = e.getCount();
        boolean _greaterThan = (_count > 1);
        if (_greaterThan) {
          final Consumer<Options> _function = new Consumer<Options>() {
            @Override
            public void accept(final Options o) {
              for (int i = 0; (i < o.getOptions().size()); i++) {
                {
                  final Option it = o.getOptions().get(i);
                  Option _element = e.getElement();
                  boolean _equals = Objects.equal(_element, it);
                  if (_equals) {
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append("Cannot define multiple option \'");
                    _builder.append(it);
                    _builder.append("\'.");
                    TargetPlatformValidator.this.error(_builder.toString(), o, TargetPlatformPackage.Literals.OPTIONS__OPTIONS, i, TargetPlatformValidator.CHECK__NO_DUPLICATE_OPTIONS_OPTIONS);
                  }
                }
              }
            }
          };
          Iterables.<Options>filter(targetPlatform.getContents(), Options.class).forEach(_function);
        }
      }
    };
    allOptions.entrySet().forEach(_function_1);
  }
  
  @Check
  public void checkNoLocationOptionIfGlobalOptions(final Location location) {
    if (((!location.getOptions().isEmpty()) && (!location.getTargetPlatform().getOptions().isEmpty()))) {
      final List<INode> nodes = NodeModelUtils.findNodesForFeature(location, TargetPlatformPackage.Literals.LOCATION__OPTIONS);
      INode _head = IterableExtensions.<INode>head(nodes);
      final INode withKeyword = ((CompositeNode) _head).getPreviousSibling();
      INode _last = IterableExtensions.<INode>last(nodes);
      final CompositeNode lastOption = ((CompositeNode) _last);
      int _offset = withKeyword.getOffset();
      int _endOffset = lastOption.getEndOffset();
      int _offset_1 = withKeyword.getOffset();
      int _minus = (_endOffset - _offset_1);
      this.acceptError("You can not define options on location and on target platform.", location, _offset, _minus, TargetPlatformValidator.CHECK__NO_OPTIONS_ON_LOCATIONS_IF_GLOBAL_OPTIONS);
    }
  }
  
  @Check
  public void checkOptionsOnLocationAreIdentical(final TargetPlatform targetPlatform) {
    boolean _isEmpty = targetPlatform.getOptions().isEmpty();
    if (_isEmpty) {
      final EList<Location> listOptions = targetPlatform.getLocations();
      final Location first = IterableExtensions.<Location>head(listOptions);
      final Function1<Location, Boolean> _function = new Function1<Location, Boolean>() {
        @Override
        public Boolean apply(final Location _) {
          boolean _isEmpty = Sets.<Option>symmetricDifference(IterableExtensions.<Option>toSet(_.getOptions()), IterableExtensions.<Option>toSet(first.getOptions())).isEmpty();
          return Boolean.valueOf((!_isEmpty));
        }
      };
      final Iterable<Location> conflicts = IterableExtensions.<Location>filter(IterableExtensions.<Location>tail(listOptions), _function);
      boolean _isEmpty_1 = IterableExtensions.isEmpty(conflicts);
      boolean _not = (!_isEmpty_1);
      if (_not) {
        final Consumer<Location> _function_1 = new Consumer<Location>() {
          @Override
          public void accept(final Location _) {
            final List<INode> nodes = NodeModelUtils.findNodesForFeature(_, TargetPlatformPackage.Literals.LOCATION__OPTIONS);
            boolean _isEmpty = nodes.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              INode _head = IterableExtensions.<INode>head(nodes);
              final INode withKeyword = ((CompositeNode) _head).getPreviousSibling();
              INode _last = IterableExtensions.<INode>last(nodes);
              final CompositeNode lastOption = ((CompositeNode) _last);
              int _offset = withKeyword.getOffset();
              int _endOffset = lastOption.getEndOffset();
              int _offset_1 = withKeyword.getOffset();
              int _minus = (_endOffset - _offset_1);
              TargetPlatformValidator.this.acceptError("Options of every locations must be the same", _, _offset, _minus, TargetPlatformValidator.CHECK__OPTIONS_EQUALS_ALL_LOCATIONS);
            } else {
              final ICompositeNode node = NodeModelUtils.getNode(_);
              TargetPlatformValidator.this.acceptError("Options of every locations must be the same", _, node.getOffset(), node.getLength(), TargetPlatformValidator.CHECK__OPTIONS_EQUALS_ALL_LOCATIONS);
            }
          }
        };
        listOptions.forEach(_function_1);
      }
    }
  }
  
  @Check
  public void deprecateOptionsOnLocation(final Location location) {
    final TargetPlatform targetPlatform = location.getTargetPlatform();
    if ((targetPlatform.getOptions().isEmpty() && (!location.getOptions().isEmpty()))) {
      final List<INode> nodes = NodeModelUtils.findNodesForFeature(location, TargetPlatformPackage.Literals.LOCATION__OPTIONS);
      INode _head = IterableExtensions.<INode>head(nodes);
      final INode withKeyword = ((CompositeNode) _head).getPreviousSibling();
      INode _last = IterableExtensions.<INode>last(nodes);
      final CompositeNode lastOption = ((CompositeNode) _last);
      int _offset = withKeyword.getOffset();
      int _endOffset = lastOption.getEndOffset();
      int _offset_1 = withKeyword.getOffset();
      int _minus = (_endOffset - _offset_1);
      this.acceptWarning("Options on location are deprecated. Define the option at the target level.", location, _offset, _minus, TargetPlatformValidator.DEPRECATE__OPTIONS_ON_LOCATIONS);
    }
  }
  
  @Check
  public void deprecateIUVersionRangeWihString(final IU iu) {
    String _version = iu.getVersion();
    boolean _notEquals = (!Objects.equal(_version, null));
    if (_notEquals) {
      final List<INode> nodes = NodeModelUtils.findNodesForFeature(iu, TargetPlatformPackage.Literals.IU__VERSION);
      EObject _grammarElement = IterableExtensions.<INode>head(nodes).getGrammarElement();
      boolean _equals = "STRING".equals(((RuleCall) _grammarElement).getRule().getName());
      if (_equals) {
        this.warning("Usage of strings is deprecated for version range. You should remove the quotes.", iu, 
          TargetPlatformPackage.Literals.IU__VERSION, 
          TargetPlatformValidator.DEPRECATE__STRINGS_ON_IU_VERSION);
      }
    }
  }
  
  @Check
  public void checkIDUniqueOnAllLocations(final TargetPlatform targetPlatform) {
    final ListMultimap<String, Location> locationsByURI = this.indexBuilder.getLocationIndex(targetPlatform);
    final Resource resource = targetPlatform.eResource();
    final LinkedHashMultimap<String, String> locationIDsByURI = LinkedHashMultimap.<String, String>create();
    final Consumer<String> _function = new Consumer<String>() {
      @Override
      public void accept(final String it) {
        final Function1<Location, String> _function = new Function1<Location, String>() {
          @Override
          public String apply(final Location it) {
            return it.getID();
          }
        };
        locationIDsByURI.putAll(it, IterableExtensions.<String>toSet(ListExtensions.<Location, String>map(locationsByURI.get(it), _function)));
      }
    };
    locationsByURI.keySet().forEach(_function);
    final Function2<String, Collection<String>, Boolean> _function_1 = new Function2<String, Collection<String>, Boolean>() {
      @Override
      public Boolean apply(final String key, final Collection<String> value) {
        int _size = value.size();
        return Boolean.valueOf((_size <= 1));
      }
    };
    final Set<String> locationsURIWithoutConflictingID = MapExtensions.<String, Collection<String>>filter(locationIDsByURI.asMap(), _function_1).keySet();
    final Function1<String, List<Location>> _function_2 = new Function1<String, List<Location>>() {
      @Override
      public List<Location> apply(final String it) {
        return locationsByURI.get(it);
      }
    };
    final Iterable<Location> locationsWithoutConflictingID = Iterables.<Location>concat(IterableExtensions.<String, List<Location>>map(locationsURIWithoutConflictingID, _function_2));
    final Function1<Location, Boolean> _function_3 = new Function1<Location, Boolean>() {
      @Override
      public Boolean apply(final Location it) {
        String _iD = it.getID();
        return Boolean.valueOf((!Objects.equal(_iD, null)));
      }
    };
    final Function<Location, String> _function_4 = new Function<Location, String>() {
      @Override
      public String apply(final Location it) {
        return it.getID();
      }
    };
    final ImmutableListMultimap<String, Location> locationsWithoutConflictingIDByID = Multimaps.<String, Location>index(IterableExtensions.<Location>filter(locationsWithoutConflictingID, _function_3), _function_4);
    final Function2<String, Collection<Location>, Boolean> _function_5 = new Function2<String, Collection<Location>, Boolean>() {
      @Override
      public Boolean apply(final String key, final Collection<Location> value) {
        final Function1<Location, String> _function = new Function1<Location, String>() {
          @Override
          public String apply(final Location it) {
            return it.getUri();
          }
        };
        int _size = IterableExtensions.<String>toSet(IterableExtensions.<Location, String>map(value, _function)).size();
        return Boolean.valueOf((_size > 1));
      }
    };
    final Iterable<Location> locationsWithDuplicateID = Iterables.<Location>concat(MapExtensions.<String, Collection<Location>>filter(locationsWithoutConflictingIDByID.asMap(), _function_5).values());
    final Consumer<Location> _function_6 = new Consumer<Location>() {
      @Override
      public void accept(final Location location) {
        Resource _eResource = location.eResource();
        boolean _equals = Objects.equal(_eResource, resource);
        if (_equals) {
          TargetPlatformValidator.this.error("ID must be unique for each location", location, 
            TargetPlatformPackage.Literals.LOCATION__ID, 
            TargetPlatformValidator.CHECK__LOCATION_ID_UNIQNESS);
        } else {
          final Function1<IncludeDeclaration, Boolean> _function = new Function1<IncludeDeclaration, Boolean>() {
            @Override
            public Boolean apply(final IncludeDeclaration it) {
              boolean _xblockexpression = false;
              {
                final TargetPlatform direct = TargetPlatformValidator.this.indexBuilder.getImportedTargetPlatform(resource, it);
                _xblockexpression = (direct.getLocations().contains(location) || 
                  IterableExtensions.<Location>toSet(Iterables.<Location>concat(ListExtensions.<TargetPlatform, EList<Location>>map(TargetPlatformValidator.this.indexBuilder.getImportedTargetPlatforms(direct), new Function1<TargetPlatform, EList<Location>>() {
                    @Override
                    public EList<Location> apply(final TargetPlatform it) {
                      return it.getLocations();
                    }
                  }))).contains(location));
              }
              return Boolean.valueOf(_xblockexpression);
            }
          };
          final Set<IncludeDeclaration> conflictualInclude = IterableExtensions.<IncludeDeclaration>toSet(IterableExtensions.<IncludeDeclaration>filter(targetPlatform.getIncludes(), _function));
          final Consumer<IncludeDeclaration> _function_1 = new Consumer<IncludeDeclaration>() {
            @Override
            public void accept(final IncludeDeclaration it) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("ID \'");
              String _iD = location.getID();
              _builder.append(_iD);
              _builder.append("\' is duplicated in the included target platform");
              TargetPlatformValidator.this.error(_builder.toString(), it, 
                TargetPlatformPackage.Literals.INCLUDE_DECLARATION__IMPORT_URI, 
                TargetPlatformValidator.CHECK__LOCATION_ID_UNIQNESS);
            }
          };
          conflictualInclude.forEach(_function_1);
        }
      }
    };
    locationsWithDuplicateID.forEach(_function_6);
  }
  
  @Check
  public void checkImportCycle(final TargetPlatform targetPlatform) {
    final List<TargetPlatform> cycle = this.indexBuilder.checkIncludeCycle(targetPlatform);
    boolean _isEmpty = cycle.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Function1<IncludeDeclaration, Boolean> _function = new Function1<IncludeDeclaration, Boolean>() {
        @Override
        public Boolean apply(final IncludeDeclaration it) {
          return Boolean.valueOf(cycle.get(1).equals(TargetPlatformValidator.this.indexBuilder.getImportedTargetPlatform(targetPlatform.eResource(), it)));
        }
      };
      final IncludeDeclaration cyclingImport = IterableExtensions.<IncludeDeclaration>findFirst(targetPlatform.getIncludes(), _function);
      boolean _notEquals = (!Objects.equal(cyclingImport, null));
      if (_notEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Cycle detected in the included target platforms. Cycle is \'");
        final Function1<TargetPlatform, URI> _function_1 = new Function1<TargetPlatform, URI>() {
          @Override
          public URI apply(final TargetPlatform it) {
            return it.eResource().getURI();
          }
        };
        String _join = IterableExtensions.join(IterableExtensions.<TargetPlatform, URI>map(IterableExtensions.<TargetPlatform>drop(cycle, 1), _function_1), "\'\' -> \'");
        _builder.append(_join);
        _builder.append("\'.");
        this.error(_builder.toString(), cyclingImport, 
          TargetPlatformPackage.Literals.INCLUDE_DECLARATION__IMPORT_URI, 
          TargetPlatformValidator.CHECK__INCLUDE_CYCLE);
      }
    }
  }
  
  @Check
  public void checkSameIDForAllLocationWithSameURI(final TargetPlatform targetPlatform) {
    final ListMultimap<String, Location> locationsByURI = this.indexBuilder.getLocationIndex(targetPlatform);
    final Resource resource = targetPlatform.eResource();
    Set<String> _keySet = locationsByURI.keySet();
    for (final String locationURI : _keySet) {
      {
        final Function1<Location, Boolean> _function = new Function1<Location, Boolean>() {
          @Override
          public Boolean apply(final Location it) {
            Resource _eResource = it.eResource();
            return Boolean.valueOf((!Objects.equal(_eResource, resource)));
          }
        };
        final Iterable<Location> externalLocations = IterableExtensions.<Location>filter(locationsByURI.get(locationURI), _function);
        final Function1<Location, String> _function_1 = new Function1<Location, String>() {
          @Override
          public String apply(final Location it) {
            return Strings.nullToEmpty(it.getID());
          }
        };
        final Set<String> externalIDs = IterableExtensions.<String>toSet(IterableExtensions.<Location, String>map(externalLocations, _function_1));
        final Function1<Location, Boolean> _function_2 = new Function1<Location, Boolean>() {
          @Override
          public Boolean apply(final Location it) {
            Resource _eResource = it.eResource();
            return Boolean.valueOf(Objects.equal(_eResource, resource));
          }
        };
        final Iterable<Location> internalLocations = IterableExtensions.<Location>filter(locationsByURI.get(locationURI), _function_2);
        final Function1<Location, String> _function_3 = new Function1<Location, String>() {
          @Override
          public String apply(final Location it) {
            return Strings.nullToEmpty(it.getID());
          }
        };
        final Set<String> internalIDs = IterableExtensions.<String>toSet(IterableExtensions.<Location, String>map(internalLocations, _function_3));
        int _size = externalIDs.size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          final Function1<Location, Boolean> _function_4 = new Function1<Location, Boolean>() {
            @Override
            public Boolean apply(final Location it) {
              return Boolean.valueOf(externalIDs.contains(it.getID()));
            }
          };
          final Iterable<Location> externalLocationsWithConflictualID = IterableExtensions.<Location>filter(externalLocations, _function_4);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("The ID for location \'");
          _builder.append(locationURI);
          _builder.append("\' must be unique. Found \'");
          String _join = IterableExtensions.join(externalIDs, "\', \'");
          _builder.append(_join);
          _builder.append("\'  in \'");
          final Function1<Location, String> _function_5 = new Function1<Location, String>() {
            @Override
            public String apply(final Location it) {
              return it.eResource().getURI().toString();
            }
          };
          String _join_1 = IterableExtensions.join(IterableExtensions.<String>toSet(IterableExtensions.<Location, String>map(externalLocationsWithConflictualID, _function_5)), "\', \'");
          _builder.append(_join_1);
          _builder.append("\'.");
          final String msg = _builder.toString();
          final Function1<Location, Iterable<IncludeDeclaration>> _function_6 = new Function1<Location, Iterable<IncludeDeclaration>>() {
            @Override
            public Iterable<IncludeDeclaration> apply(final Location location) {
              final Function1<IncludeDeclaration, Boolean> _function = new Function1<IncludeDeclaration, Boolean>() {
                @Override
                public Boolean apply(final IncludeDeclaration it) {
                  boolean _xblockexpression = false;
                  {
                    final TargetPlatform direct = TargetPlatformValidator.this.indexBuilder.getImportedTargetPlatform(resource, it);
                    _xblockexpression = (direct.getLocations().contains(location) || 
                      IterableExtensions.<Location>toSet(Iterables.<Location>concat(ListExtensions.<TargetPlatform, EList<Location>>map(TargetPlatformValidator.this.indexBuilder.getImportedTargetPlatforms(direct), new Function1<TargetPlatform, EList<Location>>() {
                        @Override
                        public EList<Location> apply(final TargetPlatform it) {
                          return it.getLocations();
                        }
                      }))).contains(location));
                  }
                  return Boolean.valueOf(_xblockexpression);
                }
              };
              return IterableExtensions.<IncludeDeclaration>filter(targetPlatform.getIncludes(), _function);
            }
          };
          final Set<IncludeDeclaration> conflictualInclude = IterableExtensions.<IncludeDeclaration>toSet(Iterables.<IncludeDeclaration>concat(IterableExtensions.<Location, Iterable<IncludeDeclaration>>map(externalLocationsWithConflictualID, _function_6)));
          final Consumer<IncludeDeclaration> _function_7 = new Consumer<IncludeDeclaration>() {
            @Override
            public void accept(final IncludeDeclaration it) {
              TargetPlatformValidator.this.error(msg, it, 
                TargetPlatformPackage.Literals.INCLUDE_DECLARATION__IMPORT_URI, 
                TargetPlatformValidator.CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION);
            }
          };
          conflictualInclude.forEach(_function_7);
        }
        int _size_1 = externalIDs.size();
        boolean _equals = (_size_1 == 1);
        if (_equals) {
          final Sets.SetView<String> diff = Sets.<String>symmetricDifference(externalIDs, internalIDs);
          boolean _isEmpty = diff.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("The ID for location \'");
            _builder_1.append(locationURI);
            _builder_1.append("\' must be unique across included target platforms and the current one. Found \'");
            String _head = IterableExtensions.<String>head(externalIDs);
            _builder_1.append(_head);
            _builder_1.append("\'  in \'");
            final Function1<Location, String> _function_8 = new Function1<Location, String>() {
              @Override
              public String apply(final Location it) {
                return it.eResource().getURI().toString();
              }
            };
            String _join_2 = IterableExtensions.join(IterableExtensions.<String>toSet(IterableExtensions.<Location, String>map(externalLocations, _function_8)), "\', \'");
            _builder_1.append(_join_2);
            _builder_1.append("\'.");
            _builder_1.newLineIfNotEmpty();
            final String msg_1 = _builder_1.toString();
            final Function1<Location, Boolean> _function_9 = new Function1<Location, Boolean>() {
              @Override
              public Boolean apply(final Location it) {
                boolean _contains = externalIDs.contains(Strings.nullToEmpty(it.getID()));
                return Boolean.valueOf((!_contains));
              }
            };
            final Consumer<Location> _function_10 = new Consumer<Location>() {
              @Override
              public void accept(final Location it) {
                TargetPlatformValidator.this.error(msg_1, it, TargetPlatformPackage.Literals.LOCATION__ID, TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, IterableExtensions.<String>head(externalIDs), IterableExtensions.<Location>head(externalLocations).getUri());
              }
            };
            IterableExtensions.<Location>filter(internalLocations, _function_9).forEach(_function_10);
          }
        }
        if (((externalIDs.size() < 1) && (internalIDs.size() > 1))) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("The ID for location \'");
          _builder_2.append(locationURI);
          _builder_2.append("\' must be unique. Found \'");
          String _join_3 = IterableExtensions.join(internalIDs, "\', \'");
          _builder_2.append(_join_3);
          _builder_2.append("\'.");
          final String msg_2 = _builder_2.toString();
          final Consumer<Location> _function_11 = new Consumer<Location>() {
            @Override
            public void accept(final Location it) {
              TargetPlatformValidator.this.error(msg_2, it, TargetPlatformPackage.Literals.LOCATION__ID, TargetPlatformValidator.CHECK__LOCATION_CONFLICTUAL_ID);
            }
          };
          internalLocations.forEach(_function_11);
        }
      }
    }
  }
  
  @Check(value = CheckType.EXPENSIVE)
  public IMetadataRepository checkLocationURI(final Location location) {
    IMetadataRepository _xblockexpression = null;
    {
      IProgressMonitor _xifexpression = null;
      if (((!Objects.equal(this.getContext(), null)) && (!Objects.equal(this.getContext().get(IProgressMonitor.class), null)))) {
        Object _get = this.getContext().get(IProgressMonitor.class);
        _xifexpression = ((IProgressMonitor) _get);
      } else {
        _xifexpression = new NullProgressMonitor();
      }
      final IProgressMonitor monitor = _xifexpression;
      IMetadataRepository _xifexpression_1 = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(location.getUri());
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        IMetadataRepository _xblockexpression_1 = null;
        {
          Object _service = this.provisioningAgent.getService(IMetadataRepositoryManager.SERVICE_NAME);
          final IMetadataRepositoryManager repositoryManager = ((IMetadataRepositoryManager) _service);
          IMetadataRepository _xtrycatchfinallyexpression = null;
          try {
            String _uri = location.getUri();
            java.net.URI _uRI = new java.net.URI(_uri);
            _xtrycatchfinallyexpression = repositoryManager.loadRepository(_uRI, monitor);
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(e.getMessage());
              if (_isNullOrEmpty_1) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("Error occured while loading p2 repository at \'");
                String _uri_1 = location.getUri();
                _builder.append(_uri_1);
                _builder.append("\'.");
                this.error(_builder.toString(), location, TargetPlatformPackage.Literals.LOCATION__URI, TargetPlatformValidator.CHECK__LOCATION_URI);
              } else {
                this.error(e.getMessage(), location, TargetPlatformPackage.Literals.LOCATION__URI, TargetPlatformValidator.CHECK__LOCATION_URI);
              }
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          _xblockexpression_1 = _xtrycatchfinallyexpression;
        }
        _xifexpression_1 = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression_1;
    }
    return _xblockexpression;
  }
  
  @Check(value = CheckType.EXPENSIVE)
  public Object checkIUIDAndRangeInRepository(final IU iu) {
    Object _xblockexpression = null;
    {
      Object _service = this.provisioningAgent.getService(IMetadataRepositoryManager.SERVICE_NAME);
      final IMetadataRepositoryManager repositoryManager = ((IMetadataRepositoryManager) _service);
      Object _xtrycatchfinallyexpression = null;
      try {
        String _uri = iu.getLocation().getUri();
        java.net.URI _uRI = new java.net.URI(_uri);
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        final IMetadataRepository metadataRepository = repositoryManager.loadRepository(_uRI, _nullProgressMonitor);
        IQuery<IInstallableUnit> _createIUQuery = QueryUtil.createIUQuery(iu.getID());
        NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
        final Set<IInstallableUnit> idResults = metadataRepository.query(_createIUQuery, _nullProgressMonitor_1).toUnmodifiableSet();
        boolean _isEmpty = idResults.isEmpty();
        if (_isEmpty) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("No installable unit with ID \'");
          String _iD = iu.getID();
          _builder.append(_iD);
          _builder.append("\' can be found in \'");
          String _uri_1 = iu.getLocation().getUri();
          _builder.append(_uri_1);
          _builder.append("\'.");
          this.error(_builder.toString(), iu, TargetPlatformPackage.Literals.IU__ID, TargetPlatformValidator.CHECK__IU_IN_LOCATION);
        } else {
          if (((!StringExtensions.isNullOrEmpty(iu.getVersion())) && (!"lazy".equals(iu.getVersion())))) {
            String _iD_1 = iu.getID();
            String _version = iu.getVersion();
            VersionRange _versionRange = new VersionRange(_version);
            IQuery<IInstallableUnit> _createQuery = QueryUtil.createQuery("latest(x | x.id == $0 && x.version ~= $1)", _iD_1, _versionRange);
            NullProgressMonitor _nullProgressMonitor_2 = new NullProgressMonitor();
            final IQueryResult<IInstallableUnit> versionResult = metadataRepository.query(_createQuery, _nullProgressMonitor_2);
            boolean _isEmpty_1 = versionResult.isEmpty();
            if (_isEmpty_1) {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("No installable unit with ID \'");
              String _iD_2 = iu.getID();
              _builder_1.append(_iD_2);
              _builder_1.append("\' can be found with range constraint \'");
              String _version_1 = iu.getVersion();
              _builder_1.append(_version_1);
              _builder_1.append("\'.");
              this.error(_builder_1.toString(), iu, TargetPlatformPackage.Literals.IU__VERSION, TargetPlatformValidator.CHECK__IU_IN_LOCATION);
            }
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Check
  public void checkEnvironment(final Environment env) {
    final ArrayList<String> dupEnv = Lists.<String>newArrayList(env.getEnv());
    final Iterator<String> dupEnvIt = dupEnv.iterator();
    final Function1<String, String> _function = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return it.toUpperCase();
      }
    };
    final List<String> knownOSUpperValues = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(Platform.knownOSValues())), _function);
    final Function1<String, String> _function_1 = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return it.toUpperCase();
      }
    };
    final List<String> knownWSUpperValues = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(Platform.knownWSValues())), _function_1);
    final Function1<String, String> _function_2 = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return it.toUpperCase();
      }
    };
    final List<String> knownArchUpperValues = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(Platform.knownOSArchValues())), _function_2);
    final Function1<Locale, String> _function_3 = new Function1<Locale, String>() {
      @Override
      public String apply(final Locale it) {
        return it.toString();
      }
    };
    final Function1<String, String> _function_4 = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return it.toUpperCase();
      }
    };
    final List<String> knownLocale = ListExtensions.<String, String>map(ListExtensions.<Locale, String>map(((List<Locale>)Conversions.doWrapArray(Locale.getAvailableLocales())), _function_3), _function_4);
    final Function1<IExecutionEnvironment, String> _function_5 = new Function1<IExecutionEnvironment, String>() {
      @Override
      public String apply(final IExecutionEnvironment it) {
        return it.getId().toUpperCase();
      }
    };
    final List<String> knownEE = ListExtensions.<IExecutionEnvironment, String>map(((List<IExecutionEnvironment>)Conversions.doWrapArray(JavaRuntime.getExecutionEnvironmentsManager().getExecutionEnvironments())), _function_5);
    while (dupEnvIt.hasNext()) {
      {
        final String envValue = dupEnvIt.next().toUpperCase();
        if (((((knownOSUpperValues.contains(envValue) || 
          knownWSUpperValues.contains(envValue)) || 
          knownArchUpperValues.contains(envValue)) || 
          knownLocale.contains(envValue)) || 
          knownEE.contains(envValue))) {
          dupEnvIt.remove();
        }
      }
    }
    for (final String errorEnv : dupEnv) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\'");
      _builder.append(errorEnv);
      _builder.append("\' is not a valid environment specification value.");
      this.error(_builder.toString(), env, 
        TargetPlatformPackage.Literals.ENVIRONMENT__ENV, 
        env.getEnv().indexOf(errorEnv), TargetPlatformValidator.CHECK__ENVIRONMENT_VALIDITY);
    }
  }
  
  @Check
  public void checkOneEnvironment(final TargetPlatform tp) {
    final List<Environment> envList = IterableExtensions.<Environment>toList(Iterables.<Environment>filter(tp.getContents(), Environment.class));
    int _size = envList.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      final Consumer<Environment> _function = new Consumer<Environment>() {
        @Override
        public void accept(final Environment it) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Environment definition should not be splitted accros the file.");
          TargetPlatformValidator.this.warning(_builder.toString(), tp, TargetPlatformPackage.Literals.TARGET_PLATFORM__CONTENTS, tp.getContents().indexOf(it), TargetPlatformValidator.CHECK__ENVIRONMENT_UNICITY);
        }
      };
      IterableExtensions.<Environment>tail(envList).forEach(_function);
    }
  }
  
  @Check
  public void checkOneOptions(final TargetPlatform tp) {
    final List<Options> envList = IterableExtensions.<Options>toList(Iterables.<Options>filter(tp.getContents(), Options.class));
    int _size = envList.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      final Consumer<Options> _function = new Consumer<Options>() {
        @Override
        public void accept(final Options it) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Options definition should not be splitted accros the file.");
          TargetPlatformValidator.this.warning(_builder.toString(), tp, TargetPlatformPackage.Literals.TARGET_PLATFORM__CONTENTS, tp.getContents().indexOf(it), TargetPlatformValidator.CHECK__OPTIONS_UNICITY);
        }
      };
      IterableExtensions.<Options>tail(envList).forEach(_function);
    }
  }
  
  @Check
  public void checkNoDuplicateEnvironmentOptions(final TargetPlatform tp) {
    final Environment tpEnv = tp.getEnvironment();
    final Function1<String, String> _function = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return it.toUpperCase();
      }
    };
    final List<String> knownOSUpperValues = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(Platform.knownOSValues())), _function);
    final Function1<String, String> _function_1 = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return it.toUpperCase();
      }
    };
    final List<String> knownWSUpperValues = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(Platform.knownWSValues())), _function_1);
    final Function1<String, String> _function_2 = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return it.toUpperCase();
      }
    };
    final List<String> knownArchUpperValues = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(Platform.knownOSArchValues())), _function_2);
    final Function1<Locale, String> _function_3 = new Function1<Locale, String>() {
      @Override
      public String apply(final Locale it) {
        return it.toString().toUpperCase();
      }
    };
    final List<String> knownLocale = ListExtensions.<Locale, String>map(((List<Locale>)Conversions.doWrapArray(Locale.getAvailableLocales())), _function_3);
    final Function1<IExecutionEnvironment, String> _function_4 = new Function1<IExecutionEnvironment, String>() {
      @Override
      public String apply(final IExecutionEnvironment it) {
        return it.getId().toUpperCase();
      }
    };
    final List<String> knownEE = ListExtensions.<IExecutionEnvironment, String>map(((List<IExecutionEnvironment>)Conversions.doWrapArray(JavaRuntime.getExecutionEnvironmentsManager().getExecutionEnvironments())), _function_4);
    final Function1<Environment, EList<String>> _function_5 = new Function1<Environment, EList<String>>() {
      @Override
      public EList<String> apply(final Environment it) {
        return it.getEnv();
      }
    };
    final Function1<String, Boolean> _function_6 = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
        return Boolean.valueOf((!_isNullOrEmpty));
      }
    };
    final List<String> envList = IterableExtensions.<String>toList(IterableExtensions.<String>filter(Iterables.<String>concat(IterableExtensions.<Environment, EList<String>>map(Iterables.<Environment>filter(tp.getContents(), Environment.class), _function_5)), _function_6));
    final Function1<String, Boolean> _function_7 = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        String _upperCase = it.toUpperCase();
        String _windowingSystem = tpEnv.getWindowingSystem();
        String _upperCase_1 = null;
        if (_windowingSystem!=null) {
          _upperCase_1=_windowingSystem.toUpperCase();
        }
        boolean _equals = _upperCase.equals(_upperCase_1);
        return Boolean.valueOf((!_equals));
      }
    };
    final Function1<String, Boolean> _function_8 = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(knownOSUpperValues.contains(it.toUpperCase()));
      }
    };
    final LinkedHashMultiset<String> allOS = LinkedHashMultiset.<String>create(IterableExtensions.<String>filter(IterableExtensions.<String>filter(envList, _function_7), _function_8));
    final Function1<String, Boolean> _function_9 = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        String _upperCase = it.toUpperCase();
        String _operatingSystem = tpEnv.getOperatingSystem();
        String _upperCase_1 = null;
        if (_operatingSystem!=null) {
          _upperCase_1=_operatingSystem.toUpperCase();
        }
        boolean _equals = _upperCase.equals(_upperCase_1);
        return Boolean.valueOf((!_equals));
      }
    };
    final Function1<String, Boolean> _function_10 = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(knownWSUpperValues.contains(it.toUpperCase()));
      }
    };
    final LinkedHashMultiset<String> allWS = LinkedHashMultiset.<String>create(IterableExtensions.<String>filter(IterableExtensions.<String>filter(envList, _function_9), _function_10));
    final Function1<String, Boolean> _function_11 = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(knownArchUpperValues.contains(it.toUpperCase()));
      }
    };
    final LinkedHashMultiset<String> allArch = LinkedHashMultiset.<String>create(IterableExtensions.<String>filter(envList, _function_11));
    final Function1<String, Boolean> _function_12 = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(knownLocale.contains(it.toUpperCase()));
      }
    };
    final LinkedHashMultiset<String> allLocale = LinkedHashMultiset.<String>create(IterableExtensions.<String>filter(envList, _function_12));
    final Function1<String, Boolean> _function_13 = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(knownEE.contains(it.toUpperCase()));
      }
    };
    final LinkedHashMultiset<String> allEE = LinkedHashMultiset.<String>create(IterableExtensions.<String>filter(envList, _function_13));
    this.reportDuplicatedEnvironmentOptions(tp, allOS, "Cannot define multiple operating system.");
    this.reportDuplicatedEnvironmentOptions(tp, allWS, "Cannot define multiple windowing system.");
    this.reportDuplicatedEnvironmentOptions(tp, allArch, "Cannot define multiple processor architecture.");
    this.reportDuplicatedEnvironmentOptions(tp, allLocale, "Cannot define multiple localization.");
    this.reportDuplicatedEnvironmentOptions(tp, allEE, "Cannot define multiple execution environment.");
  }
  
  private void reportDuplicatedEnvironmentOptions(final TargetPlatform targetPlatform, final Multiset<String> valuesInFile, final String msg) {
    if (((valuesInFile.size() > 1) || IterableExtensions.<Multiset.Entry<String>>exists(valuesInFile.entrySet(), new Function1<Multiset.Entry<String>, Boolean>() {
      @Override
      public Boolean apply(final Multiset.Entry<String> it) {
        int _count = it.getCount();
        return Boolean.valueOf((_count > 1));
      }
    }))) {
      final Consumer<String> _function = new Consumer<String>() {
        @Override
        public void accept(final String e) {
          final Consumer<Environment> _function = new Consumer<Environment>() {
            @Override
            public void accept(final Environment env) {
              for (int i = 0; (i < env.getEnv().size()); i++) {
                {
                  final String it = env.getEnv().get(i);
                  boolean _equals = e.equals(it);
                  if (_equals) {
                    TargetPlatformValidator.this.error(msg, env, TargetPlatformPackage.Literals.ENVIRONMENT__ENV, i, TargetPlatformValidator.CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS);
                  }
                }
              }
            }
          };
          Iterables.<Environment>filter(targetPlatform.getContents(), Environment.class).forEach(_function);
        }
      };
      valuesInFile.elementSet().forEach(_function);
    }
  }
  
  @Check
  public void checkNoEscapeCharacterInIUID(final IU iu) {
    final ICompositeNode node = NodeModelUtils.getNode(iu);
    final Function1<INode, Boolean> _function = new Function1<INode, Boolean>() {
      @Override
      public Boolean apply(final INode it) {
        EObject _grammarElement = it.getGrammarElement();
        RuleCall _iDIDTerminalRuleCall_0_0 = TargetPlatformValidator.this.grammarAccess.getIUAccess().getIDIDTerminalRuleCall_0_0();
        return Boolean.valueOf(Objects.equal(_grammarElement, _iDIDTerminalRuleCall_0_0));
      }
    };
    final INode idRule = IterableExtensions.<INode>findFirst(node.getAsTreeIterable(), _function);
    String _xifexpression = null;
    if ((idRule.getText().startsWith("^") && (!idRule.getText().contains(".")))) {
      _xifexpression = idRule.getText().substring(1);
    } else {
      _xifexpression = idRule.getText();
    }
    final String id = _xifexpression;
    boolean _contains = id.contains("^");
    if (_contains) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Usage of escape character \'^\' in the ID of IUs is not required anymore and has been deprecated.");
      this.warning(_builder.toString(), iu, TargetPlatformPackage.Literals.IU__ID, TargetPlatformValidator.CHECK__ESCAPE_CHAR_IU_ID);
    }
  }
  
  @Check
  public void checkVersionKeywords(final IU iu) {
    final ICompositeNode node = NodeModelUtils.getNode(iu);
    final Function1<INode, Boolean> _function = new Function1<INode, Boolean>() {
      @Override
      public Boolean apply(final INode it) {
        EObject _grammarElement = it.getGrammarElement();
        Keyword _semicolonKeyword_1_0_0 = TargetPlatformValidator.this.grammarAccess.getIUAccess().getSemicolonKeyword_1_0_0();
        return Boolean.valueOf(Objects.equal(_grammarElement, _semicolonKeyword_1_0_0));
      }
    };
    final INode semicolonKeywordRule = IterableExtensions.<INode>findFirst(node.getAsTreeIterable(), _function);
    final Function1<INode, Boolean> _function_1 = new Function1<INode, Boolean>() {
      @Override
      public Boolean apply(final INode it) {
        EObject _grammarElement = it.getGrammarElement();
        Keyword _equalsSignKeyword_1_0_2 = TargetPlatformValidator.this.grammarAccess.getIUAccess().getEqualsSignKeyword_1_0_2();
        return Boolean.valueOf(Objects.equal(_grammarElement, _equalsSignKeyword_1_0_2));
      }
    };
    final INode equalSignKeywordRule = IterableExtensions.<INode>findFirst(node.getAsTreeIterable(), _function_1);
    boolean _notEquals = (!Objects.equal(semicolonKeywordRule, null));
    if (_notEquals) {
      int _offset = semicolonKeywordRule.getOffset();
      int _endOffset = equalSignKeywordRule.getEndOffset();
      int _offset_1 = semicolonKeywordRule.getOffset();
      int _minus = (_endOffset - _offset_1);
      this.acceptWarning("Usage of keywords \';version=\' are not required anymore and has been deprecated.", iu, _offset, _minus, TargetPlatformValidator.CHECK__VERSION_KEYWORDS);
    }
  }
  
  @Check
  public void checkNoDuplicatedIU(final TargetPlatform targetPlatform) {
    final LinkedList<TargetPlatform> importedTPs = this.indexBuilder.getImportedTargetPlatforms(targetPlatform);
    final Function1<TargetPlatform, EList<Location>> _function = new Function1<TargetPlatform, EList<Location>>() {
      @Override
      public EList<Location> apply(final TargetPlatform it) {
        return it.getLocations();
      }
    };
    final Function1<Location, EList<IU>> _function_1 = new Function1<Location, EList<IU>>() {
      @Override
      public EList<IU> apply(final Location it) {
        return it.getIus();
      }
    };
    final Set<IU> importedIUs = IterableExtensions.<IU>toSet(Iterables.<IU>concat(IterableExtensions.<Location, EList<IU>>map(Iterables.<Location>concat(ListExtensions.<TargetPlatform, EList<Location>>map(importedTPs, _function)), _function_1)));
    final Function1<Location, EList<IU>> _function_2 = new Function1<Location, EList<IU>>() {
      @Override
      public EList<IU> apply(final Location it) {
        return it.getIus();
      }
    };
    final Function1<IU, String> _function_3 = new Function1<IU, String>() {
      @Override
      public String apply(final IU it) {
        return it.getID();
      }
    };
    final HashMultiset<String> localIUsID = HashMultiset.<String>create(IterableExtensions.<IU, String>map(Iterables.<IU>concat(ListExtensions.<Location, EList<IU>>map(targetPlatform.getLocations(), _function_2)), _function_3));
    final Function1<IU, String> _function_4 = new Function1<IU, String>() {
      @Override
      public String apply(final IU it) {
        return it.getID();
      }
    };
    final Set<String> importedIUsID = IterableExtensions.<String>toSet(IterableExtensions.<IU, String>map(importedIUs, _function_4));
    final Function1<Location, EList<IU>> _function_5 = new Function1<Location, EList<IU>>() {
      @Override
      public EList<IU> apply(final Location it) {
        return it.getIus();
      }
    };
    final Function1<IU, Boolean> _function_6 = new Function1<IU, Boolean>() {
      @Override
      public Boolean apply(final IU it) {
        return Boolean.valueOf((importedIUsID.contains(it.getID()) || (localIUsID.count(it.getID()) > 1)));
      }
    };
    final Consumer<IU> _function_7 = new Consumer<IU>() {
      @Override
      public void accept(final IU entry) {
        final Function1<Location, Boolean> _function = new Function1<Location, Boolean>() {
          @Override
          public Boolean apply(final Location it) {
            final Function1<IU, String> _function = new Function1<IU, String>() {
              @Override
              public String apply(final IU it) {
                return it.getID();
              }
            };
            return Boolean.valueOf(ListExtensions.<IU, String>map(it.getIus(), _function).contains(entry.getID()));
          }
        };
        final Function1<Location, String> _function_1 = new Function1<Location, String>() {
          @Override
          public String apply(final Location it) {
            return it.getUri();
          }
        };
        final Set<String> localLocationsWithDup = IterableExtensions.<String>toSet(IterableExtensions.<Location, String>map(IterableExtensions.<Location>filter(targetPlatform.getLocations(), _function), _function_1));
        final Function1<IU, Boolean> _function_2 = new Function1<IU, Boolean>() {
          @Override
          public Boolean apply(final IU it) {
            return Boolean.valueOf(it.getID().equals(entry.getID()));
          }
        };
        final Function1<IU, URI> _function_3 = new Function1<IU, URI>() {
          @Override
          public URI apply(final IU it) {
            return it.eResource().getURI();
          }
        };
        final Set<URI> importedTPsWithDup = IterableExtensions.<URI>toSet(IterableExtensions.<IU, URI>map(IterableExtensions.<IU>filter(importedIUs, _function_2), _function_3));
        String _xifexpression = null;
        boolean _contains = importedIUsID.contains(entry.getID());
        if (_contains) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Duplicated IU \'");
          String _iD = entry.getID();
          _builder.append(_iD);
          _builder.append("\' for locations \'");
          String _join = IterableExtensions.join(localLocationsWithDup, "\', \'");
          _builder.append(_join);
          _builder.append("\'. It is included from target platforms \'");
          String _join_1 = IterableExtensions.join(importedTPsWithDup, "\', \'");
          _builder.append(_join_1);
          _builder.append("\'.");
          _xifexpression = _builder.toString();
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Duplicated IU \'");
          String _iD_1 = entry.getID();
          _builder_1.append(_iD_1);
          _builder_1.append("\' for locations \'");
          String _join_2 = IterableExtensions.join(localLocationsWithDup, "\', \'");
          _builder_1.append(_join_2);
          _builder_1.append("\'.");
          _xifexpression = _builder_1.toString();
        }
        final String msg = _xifexpression;
        TargetPlatformValidator.this.warning(msg, entry.getLocation(), TargetPlatformPackage.Literals.LOCATION__IUS, entry.getLocation().getIus().indexOf(entry), TargetPlatformValidator.CHECK__NO_DUPLICATED_IU);
      }
    };
    IterableExtensions.<IU>filter(Iterables.<IU>concat(ListExtensions.<Location, EList<IU>>map(targetPlatform.getLocations(), _function_5)), _function_6).forEach(_function_7);
  }
}
