package fr.obeo.releng.targetplatform.pde;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import fr.obeo.releng.targetplatform.Option;
import fr.obeo.releng.targetplatform.resolved.ResolvedLocation;
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform;
import java.net.URI;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class TargetDefinitionGenerator {
  public String generate(final ResolvedTargetPlatform targetPlatform) {
    String _xblockexpression = null;
    {
      Preconditions.<ResolvedTargetPlatform>checkNotNull(targetPlatform);
      long _currentTimeMillis = System.currentTimeMillis();
      long _seconds = TimeUnit.MILLISECONDS.toSeconds(_currentTimeMillis);
      final int sequenceNumber = ((int) _seconds);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder.newLine();
      _builder.append("<?pde?>");
      _builder.newLine();
      _builder.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder.newLine();
      _builder.append("<target name=\"");
      String _name = targetPlatform.getName();
      _builder.append(_name, "");
      _builder.append("\" sequenceNumber=\"");
      _builder.append(sequenceNumber, "");
      _builder.append("\">");
      _builder.newLineIfNotEmpty();
      {
        boolean _and = false;
        List<ResolvedLocation> _locations = targetPlatform.getLocations();
        boolean _notEquals = (!Objects.equal(_locations, null));
        if (!_notEquals) {
          _and = false;
        } else {
          List<ResolvedLocation> _locations_1 = targetPlatform.getLocations();
          boolean _isEmpty = _locations_1.isEmpty();
          boolean _not = (!_isEmpty);
          _and = _not;
        }
        if (_and) {
          _builder.append("  ");
          _builder.append("<locations>");
          _builder.newLine();
          {
            List<ResolvedLocation> _locations_2 = targetPlatform.getLocations();
            for(final ResolvedLocation location : _locations_2) {
              _builder.append("  ");
              _builder.append("  ");
              String _generateLocation = this.generateLocation(targetPlatform, location);
              _builder.append(_generateLocation, "    ");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("  ");
          _builder.append("</locations>");
          _builder.newLine();
        }
      }
      _builder.append("</target>");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  private String generateLocation(final ResolvedTargetPlatform targetPlatform, final ResolvedLocation location) {
    String _xblockexpression = null;
    {
      EnumSet<Option> _xifexpression = null;
      EnumSet<Option> _options = targetPlatform.getOptions();
      boolean _isEmpty = _options.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _xifexpression = targetPlatform.getOptions();
      } else {
        _xifexpression = location.getOptions();
      }
      final EnumSet<Option> options = _xifexpression;
      String _xifexpression_1 = null;
      boolean _contains = options.contains(Option.INCLUDE_REQUIRED);
      if (_contains) {
        _xifexpression_1 = "planner";
      } else {
        _xifexpression_1 = "slicer";
      }
      String _plus = ("includeMode=\"" + _xifexpression_1);
      final String includeMode = (_plus + "\"");
      boolean _contains_1 = options.contains(Option.INCLUDE_ALL_ENVIRONMENTS);
      String _plus_1 = ("includeAllPlatforms=\"" + Boolean.valueOf(_contains_1));
      final String includeAllPlatforms = (_plus_1 + "\"");
      boolean _contains_2 = options.contains(Option.INCLUDE_SOURCE);
      String _plus_2 = ("includeSource=\"" + Boolean.valueOf(_contains_2));
      final String includeSource = (_plus_2 + "\"");
      boolean _contains_3 = options.contains(Option.INCLUDE_CONFIGURE_PHASE);
      String _plus_3 = ("includeConfigurePhase=\"" + Boolean.valueOf(_contains_3));
      final String includeConfigurePhase = (_plus_3 + "\"");
      final String locationAttributes = ((((((includeMode + " ") + includeAllPlatforms) + " ") + includeSource) + " ") + includeConfigurePhase);
      StringConcatenation _builder = new StringConcatenation();
      {
        String _iD = location.getID();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_iD);
        boolean _not_1 = (!_isNullOrEmpty);
        if (_not_1) {
          _builder.append("id=\"");
          String _iD_1 = location.getID();
          _builder.append(_iD_1, "");
          _builder.append("\" ");
        }
      }
      _builder.append("location=\"");
      URI _uRI = location.getURI();
      _builder.append(_uRI, "");
      _builder.append("\"");
      final String repositoryAttributes = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<location ");
      _builder_1.append(locationAttributes, "");
      _builder_1.append(" type=\"InstallableUnit\">");
      _builder_1.newLineIfNotEmpty();
      {
        List<IInstallableUnit> _resolvedIUs = location.getResolvedIUs();
        for(final IInstallableUnit iu : _resolvedIUs) {
          _builder_1.append("  ");
          _builder_1.append("<unit id=\"");
          String _id = iu.getId();
          _builder_1.append(_id, "  ");
          _builder_1.append("\" version=\"");
          Version _version = iu.getVersion();
          _builder_1.append(_version, "  ");
          _builder_1.append("\"/>");
          _builder_1.newLineIfNotEmpty();
        }
      }
      _builder_1.append("  ");
      _builder_1.append("<repository ");
      _builder_1.append(repositoryAttributes, "  ");
      _builder_1.append("/>");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("</location>");
      _builder_1.newLine();
      _xblockexpression = _builder_1.toString();
    }
    return _xblockexpression;
  }
}
