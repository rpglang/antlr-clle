import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import utils.TestToken
import utils.TestUtils
import java.util.*

class ParserUnitTest {

    private val testUtils = TestUtils();

    @Test
    fun testCLCommandSyntax() {

        val tokens = listOf(
            /*new */ TestToken("//", CLLELexer.SLASHES),
            /*new */ TestToken("?", CLLELexer.QUESTION_MARK),
            /*new */ TestToken("lblNme", CLLEParser.RULE_label),
            /*new */ TestToken(":", CLLELexer.COLON),
            /*new */ TestToken("libNme", CLLEParser.RULE_library),
            /*new */ TestToken("/", CLLELexer.SLASH),
            /*new */ TestToken("cmdNme", CLLEParser.RULE_command),
//            /*new */ TestToken("parms", CLLEParser.RULE_parameters)
        )

        val parser = testUtils.createParserNoError(tokens)
        val text = parser.cl_command().text

        tokens.forEach {
            Assertions.assertTrue(it.text.toString() in text)
        }
    }
}