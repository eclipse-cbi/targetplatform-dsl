package fr.obeo.releng.targetplatform.conversion;

import com.google.common.base.Objects;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ExecutionEnvironmentConverter extends AbstractNullSafeConverter<IExecutionEnvironment> {
  protected IExecutionEnvironment internalToValue(final String string, final INode node) throws ValueConverterException {
    IExecutionEnvironment _xblockexpression = null;
    {
      boolean _equals = Objects.equal(string, null);
      if (_equals) {
        return null;
      }
      IExecutionEnvironment _xtrycatchfinallyexpression = null;
      try {
        final IExecutionEnvironmentsManager eeManager = JavaRuntime.getExecutionEnvironmentsManager();
        boolean _equals_1 = Objects.equal(eeManager, null);
        if (_equals_1) {
          throw new ValueConverterException("No ExecutionEnvironmentManager found.", node, null);
        } else {
          final IExecutionEnvironment env = eeManager.getEnvironment(string);
          boolean _equals_2 = Objects.equal(env, null);
          if (_equals_2) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("\'");
            _builder.append(string, "");
            _builder.append("\' is not a valid Java Execution Environment");
            throw new ValueConverterException(_builder.toString(), node, null);
          } else {
            return env;
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
  
  protected String internalToString(final IExecutionEnvironment value) {
    return value.getId();
  }
}
