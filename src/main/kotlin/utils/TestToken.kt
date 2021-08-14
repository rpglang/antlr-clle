package utils

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.TokenSource

// class and constructor declarations
class TestToken (val _text: String, val tcod: Int) : Token {

    override fun getText(): String? {
        return _text
    }

    override fun getType(): Int {
        return tcod
    }

    override fun getLine(): Int = 0


    override fun getCharPositionInLine(): Int = 0

    override fun getChannel(): Int = 0

    override fun getTokenIndex(): Int = 0

    override fun getStartIndex(): Int = 0

    override fun getStopIndex(): Int = 0

    override fun getTokenSource(): TokenSource? {
        return null
    }

    override fun getInputStream(): CharStream? {
        return null
    }
}