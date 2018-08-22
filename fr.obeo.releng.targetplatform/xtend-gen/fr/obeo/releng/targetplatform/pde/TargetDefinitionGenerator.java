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
package fr.obeo.releng.targetplatform.pde;

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
      _builder.append(_name);
      _builder.append("\" sequenceNumber=\"");
      _builder.append(sequenceNumber);
      _builder.append("\">");
      _builder.newLineIfNotEmpty();
      {
        if (((targetPlatform.getLocations() != null) && (!targetPlatform.getLocations().isEmpty()))) {
          _builder.append("  ");
          _builder.append("<locations>");
          _builder.newLine();
          {
            List<ResolvedLocation> _locations = targetPlatform.getLocations();
            for(final ResolvedLocation location : _locations) {
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
        if (((targetPlatform.getEnvironment() != null) && ((((!StringExtensions.isNullOrEmpty(targetPlatform.getEnvironment().getOs())) || 
          (!StringExtensions.isNullOrEmpty(targetPlatform.getEnvironment().getWs()))) || 
          (!StringExtensions.isNullOrEmpty(targetPlatform.getEnvironment().getArch()))) || 
          (!StringExtensions.isNullOrEmpty(targetPlatform.getEnvironment().getNl()))))) {
          _builder.append("  ");
          _builder.append("<environment>");
          _builder.newLine();
          {
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(targetPlatform.getEnvironment().getOs());
            boolean _not = (!_isNullOrEmpty);
            if (_not) {
              _builder.append("  ");
              _builder.append("  ");
              _builder.append("<os>");
              String _os = targetPlatform.getEnvironment().getOs();
              _builder.append(_os, "    ");
              _builder.append("</os>");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(targetPlatform.getEnvironment().getWs());
            boolean _not_1 = (!_isNullOrEmpty_1);
            if (_not_1) {
              _builder.append("  ");
              _builder.append("  ");
              _builder.append("<ws>");
              String _ws = targetPlatform.getEnvironment().getWs();
              _builder.append(_ws, "    ");
              _builder.append("</ws>");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(targetPlatform.getEnvironment().getArch());
            boolean _not_2 = (!_isNullOrEmpty_2);
            if (_not_2) {
              _builder.append("  ");
              _builder.append("  ");
              _builder.append("<arch>");
              String _arch = targetPlatform.getEnvironment().getArch();
              _builder.append(_arch, "    ");
              _builder.append("</arch>");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(targetPlatform.getEnvironment().getNl());
            boolean _not_3 = (!_isNullOrEmpty_3);
            if (_not_3) {
              _builder.append("  ");
              _builder.append("  ");
              _builder.append("<nl>");
              String _nl = targetPlatform.getEnvironment().getNl();
              _builder.append(_nl, "    ");
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
        if (((targetPlatform.getEnvironment() != null) && (!StringExtensions.isNullOrEmpty(targetPlatform.getEnvironment().getTargetJRE())))) {
          _builder.append("  ");
          _builder.append("<targetJRE path=\"");
          String _targetJRE = targetPlatform.getEnvironment().getTargetJRE();
          _builder.append(_targetJRE, "  ");
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
      boolean _isEmpty = targetPlatform.getOptions().isEmpty();
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
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(location.getID());
        boolean _not_1 = (!_isNullOrEmpty);
        if (_not_1) {
          _builder.append("id=\"");
          String _iD = location.getID();
          _builder.append(_iD);
          _builder.append("\" ");
        }
      }
      _builder.append("location=\"");
      URI _uRI = location.getURI();
      _builder.append(_uRI);
      _builder.append("\"");
      final String repositoryAttributes = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<location ");
      _builder_1.append(locationAttributes);
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
