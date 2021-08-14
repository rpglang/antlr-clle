import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import utils.TestUtils

/**
 *  Tests strings againt lexer rules, to check matching the expected tokens
 */
class LexerUnitTest {

    private val testUtils = TestUtils()

    @Test
    fun testCLCommandSyntax() {
//      [//] [?] [label-name:][library-name/]command-name [parameter-set]
        val tokens = testUtils.getTokensFromText("// ? lblnme : libnme / cmdnme") // parms");
        val tokenSize = 8

        tokens.asSequence().forEach { token -> println(token.type.toString() + " -> "+token.text) }

        assertEquals(tokenSize, tokens.size) // includes EOF
        assertEquals(CLLELexer.SLASHES, tokens[0].type)
        assertEquals(CLLELexer.QUESTION_MARK, tokens[1].type)
        assertEquals(CLLELexer.SPLAT_SNAME, tokens[2].type)
        assertEquals(CLLELexer.COLON, tokens[3].type)
        assertEquals(CLLELexer.SPLAT_SNAME, tokens[4].type)
        assertEquals(CLLELexer.SLASH, tokens[5].type)
        assertEquals(CLLELexer.SPLAT_SNAME, tokens[6].type)
//        assertEquals(CLLEParser.RULE_parameters, tokens[7].type)
    }
}