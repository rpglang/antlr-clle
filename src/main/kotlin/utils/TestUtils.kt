package utils

import CLLELexer
import CLLEParser
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import org.junit.jupiter.api.fail
import java.io.ByteArrayInputStream
import java.util.BitSet

/**
 * References:
 *  https://ssricardo.github.io/2018/junit-antlr-lexer/
 *  https://github.com/ssricardo
 */
class TestUtils {

    private val errorListener = NoErrorListener();

    /** Boilerplate to process a string and generate the Tokens for it */
    fun getTokensFromText(txt: String): List<Token> {
        val iStream = /*new */ByteArrayInputStream(txt.toByteArray())
        val cStream = /*new */CharStreams.fromStream(iStream)
        val lex = /*new */CLLELexer(cStream)
        lex.addErrorListener(errorListener)
        val tokenStream =  CommonTokenStream(lex)
        tokenStream.fill()
        return tokenStream.tokens
    }

    fun createParserNoError(tokens: List<TestToken>): CLLEParser {
        val ts = ListTokenSource(tokens)
        val c = CommonTokenStream(ts)
        val p = CLLEParser(c)
        p.addErrorListener(errorListener)
        return p
    }
}
