package fr.obeo.releng.targetplatform.ui.editor.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.CompoundMultiLineTerminalsEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

@SuppressWarnings("all")
public class TargetPlatformAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {
  protected void configureCompoundBracesBlocks(final AbstractEditStrategyProvider.IEditStrategyAcceptor acceptor) {
    CompoundMultiLineTerminalsEditStrategy _newInstanceFor = this.compoundMultiLineTerminals.newInstanceFor("{", "}");
    acceptor.accept(_newInstanceFor, IDocument.DEFAULT_CONTENT_TYPE);
  }
  
  protected void configureSquareBrackets(final AbstractEditStrategyProvider.IEditStrategyAcceptor acceptor) {
  }
  
  protected void configureParenthesis(final AbstractEditStrategyProvider.IEditStrategyAcceptor acceptor) {
  }
}
