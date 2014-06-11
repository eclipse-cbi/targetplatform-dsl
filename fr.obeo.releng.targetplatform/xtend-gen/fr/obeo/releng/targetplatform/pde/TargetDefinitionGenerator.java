package fr.obeo.releng.targetplatform.pde;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import fr.obeo.releng.targetplatform.Option;
import fr.obeo.releng.targetplatform.resolved.ResolvedLocation;
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform;
import java.net.URI;
import java.util.EnumSet;
import java.util.List;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class TargetDefinitionGenerator {
  public String generate(final ResolvedTargetPlatform targetPlatform, final int sequenceNumber) {
    String _xblockexpression = null;
    {
      Preconditions.<ResolvedTargetPlatform>checkNotNull(targetPlatform);
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
      {
        boolean _and_1 = false;
        ResolvedTargetPlatform.Environment _environment = targetPlatform.getEnvironment();
        boolean _notEquals_1 = (!Objects.equal(_environment, null));
        if (!_notEquals_1) {
          _and_1 = false;
        } else {
          boolean _or = false;
          boolean _or_1 = false;
          boolean _or_2 = false;
          ResolvedTargetPlatform.Environment _environment_1 = targetPlatform.getEnvironment();
          String _os = _environment_1.getOs();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_os);
          boolean _not_1 = (!_isNullOrEmpty);
          if (_not_1) {
            _or_2 = true;
          } else {
            ResolvedTargetPlatform.Environment _environment_2 = targetPlatform.getEnvironment();
            String _ws = _environment_2.getWs();
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_ws);
            boolean _not_2 = (!_isNullOrEmpty_1);
            _or_2 = _not_2;
          }
          if (_or_2) {
            _or_1 = true;
          } else {
            ResolvedTargetPlatform.Environment _environment_3 = targetPlatform.getEnvironment();
            String _arch = _environment_3.getArch();
            boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_arch);
            boolean _not_3 = (!_isNullOrEmpty_2);
            _or_1 = _not_3;
          }
          if (_or_1) {
            _or = true;
          } else {
            ResolvedTargetPlatform.Environment _environment_4 = targetPlatform.getEnvironment();
            String _nl = _environment_4.getNl();
            boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_nl);
            boolean _not_4 = (!_isNullOrEmpty_3);
            _or = _not_4;
          }
          _and_1 = _or;
        }
        if (_and_1) {
          _builder.append("  ");
          _builder.append("<environment>");
          _builder.newLine();
          {
            ResolvedTargetPlatform.Environment _environment_5 = targetPlatform.getEnvironment();
            String _os_1 = _environment_5.getOs();
            boolean _isNullOrEmpty_4 = StringExtensions.isNullOrEmpty(_os_1);
            boolean _not_5 = (!_isNullOrEmpty_4);
            if (_not_5) {
              _builder.append("  ");
              _builder.append("  ");
              _builder.append("<os>");
              ResolvedTargetPlatform.Environment _environment_6 = targetPlatform.getEnvironment();
              String _os_2 = _environment_6.getOs();
              _builder.append(_os_2, "    ");
              _builder.append("</os>");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            ResolvedTargetPlatform.Environment _environment_7 = targetPlatform.getEnvironment();
            String _ws_1 = _environment_7.getWs();
            boolean _isNullOrEmpty_5 = StringExtensions.isNullOrEmpty(_ws_1);
            boolean _not_6 = (!_isNullOrEmpty_5);
            if (_not_6) {
              _builder.append("  ");
              _builder.append("  ");
              _builder.append("<ws>");
              ResolvedTargetPlatform.Environment _environment_8 = targetPlatform.getEnvironment();
              String _ws_2 = _environment_8.getWs();
              _builder.append(_ws_2, "    ");
              _builder.append("</ws>");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            ResolvedTargetPlatform.Environment _environment_9 = targetPlatform.getEnvironment();
            String _arch_1 = _environment_9.getArch();
            boolean _isNullOrEmpty_6 = StringExtensions.isNullOrEmpty(_arch_1);
            boolean _not_7 = (!_isNullOrEmpty_6);
            if (_not_7) {
              _builder.append("  ");
              _builder.append("  ");
              _builder.append("<arch>");
              ResolvedTargetPlatform.Environment _environment_10 = targetPlatform.getEnvironment();
              String _arch_2 = _environment_10.getArch();
              _builder.append(_arch_2, "    ");
              _builder.append("</arch>");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            ResolvedTargetPlatform.Environment _environment_11 = targetPlatform.getEnvironment();
            String _nl_1 = _environment_11.getNl();
            boolean _isNullOrEmpty_7 = StringExtensions.isNullOrEmpty(_nl_1);
            boolean _not_8 = (!_isNullOrEmpty_7);
            if (_not_8) {
              _builder.append("  ");
              _builder.append("  ");
              _builder.append("<nl>");
              ResolvedTargetPlatform.Environment _environment_12 = targetPlatform.getEnvironment();
              String _nl_2 = _environment_12.getNl();
              _builder.append(_nl_2, "    ");
              _builder.append("</nl>");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("  ");
          _builder.append("</environment>");
          _builder.newLine();
        }
      }
      {
        boolean _and_2 = false;
        ResolvedTargetPlatform.Environment _environment_13 = targetPlatform.getEnvironment();
        boolean _notEquals_2 = (!Objects.equal(_environment_13, null));
        if (!_notEquals_2) {
          _and_2 = false;
        } else {
          ResolvedTargetPlatform.Environment _environment_14 = targetPlatform.getEnvironment();
          String _targetJRE = _environment_14.getTargetJRE();
          boolean _isNullOrEmpty_8 = StringExtensions.isNullOrEmpty(_targetJRE);
          boolean _not_9 = (!_isNullOrEmpty_8);
          _and_2 = _not_9;
        }
        if (_and_2) {
          _builder.append("  ");
          _builder.append("<targetJRE path=\"");
          ResolvedTargetPlatform.Environment _environment_15 = targetPlatform.getEnvironment();
          String _targetJRE_1 = _environment_15.getTargetJRE();
          _builder.append(_targetJRE_1, "  ");
          _builder.append("\"/>");
          _builder.newLineIfNotEmpty();
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
