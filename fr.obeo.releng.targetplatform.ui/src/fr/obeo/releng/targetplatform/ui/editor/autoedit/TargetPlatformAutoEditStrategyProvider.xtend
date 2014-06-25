package fr.obeo.releng.targetplatform.ui.editor.autoedit

import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider.IEditStrategyAcceptor
import org.eclipse.jface.text.IDocument

class TargetPlatformAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {
	
	override protected configureCompoundBracesBlocks(IEditStrategyAcceptor acceptor) {
		acceptor.accept(compoundMultiLineTerminals.newInstanceFor("{", "}"), IDocument.DEFAULT_CONTENT_TYPE);
	}
	
	override protected configureSquareBrackets(IEditStrategyAcceptor acceptor) {
	}
	
	override protected configureParenthesis(IEditStrategyAcceptor acceptor) {
	}
	
}