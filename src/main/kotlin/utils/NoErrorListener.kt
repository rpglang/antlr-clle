package utils

import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.dfa.DFA
import java.util.BitSet

/**
 * github.com/ssricardo
 */
class NoErrorListener: ANTLRErrorListener {

    override fun syntaxError(recognizer: Recognizer<*, *>, offendingSymbol: Any, line: Int, charPositionInLine: Int, msg: String, e: RecognitionException) {
        System.err.format("Syntax Error (at line %d): %s : %s %n", line, msg, offendingSymbol)
    }

    override fun reportAmbiguity(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int, exact: Boolean, ambigAlts: BitSet, configs: ATNConfigSet) {
        System.err.format("Ambiguity: %s - %s %n", dfa.toLexerString(), recognizer.currentToken.text)
    }

    override fun reportAttemptingFullContext(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int, conflictingAlts: BitSet, configs: ATNConfigSet) {}

    override fun reportContextSensitivity(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int, prediction: Int, configs: ATNConfigSet) {}
}