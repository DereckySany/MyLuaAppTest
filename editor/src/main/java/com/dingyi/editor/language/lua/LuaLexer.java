package com.dingyi.editor.language.lua;


import static com.dingyi.editor.language.lua.LuaTokenTypes.AND;
import static com.dingyi.editor.language.lua.LuaTokenTypes.ASSIGN;
import static com.dingyi.editor.language.lua.LuaTokenTypes.AT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.BAD_CHARACTER;
import static com.dingyi.editor.language.lua.LuaTokenTypes.BIT_AND;
import static com.dingyi.editor.language.lua.LuaTokenTypes.BIT_LTLT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.BIT_OR;
import static com.dingyi.editor.language.lua.LuaTokenTypes.BIT_RTRT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.BIT_TILDE;
import static com.dingyi.editor.language.lua.LuaTokenTypes.BLOCK_COMMENT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.BREAK;
import static com.dingyi.editor.language.lua.LuaTokenTypes.CASE;
import static com.dingyi.editor.language.lua.LuaTokenTypes.COLON;
import static com.dingyi.editor.language.lua.LuaTokenTypes.COMMA;
import static com.dingyi.editor.language.lua.LuaTokenTypes.CONCAT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.CONTINUE;
import static com.dingyi.editor.language.lua.LuaTokenTypes.DEFAULT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.DEFER;
import static com.dingyi.editor.language.lua.LuaTokenTypes.DIV;
import static com.dingyi.editor.language.lua.LuaTokenTypes.DO;
import static com.dingyi.editor.language.lua.LuaTokenTypes.DOC_COMMENT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.DOT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.DOUBLE_COLON;
import static com.dingyi.editor.language.lua.LuaTokenTypes.DOUBLE_DIV;
import static com.dingyi.editor.language.lua.LuaTokenTypes.ELLIPSIS;
import static com.dingyi.editor.language.lua.LuaTokenTypes.ELSE;
import static com.dingyi.editor.language.lua.LuaTokenTypes.ELSEIF;
import static com.dingyi.editor.language.lua.LuaTokenTypes.END;
import static com.dingyi.editor.language.lua.LuaTokenTypes.ENDREGION;
import static com.dingyi.editor.language.lua.LuaTokenTypes.EQ;
import static com.dingyi.editor.language.lua.LuaTokenTypes.EXP;
import static com.dingyi.editor.language.lua.LuaTokenTypes.FALSE;
import static com.dingyi.editor.language.lua.LuaTokenTypes.FOR;
import static com.dingyi.editor.language.lua.LuaTokenTypes.FUNCTION;
import static com.dingyi.editor.language.lua.LuaTokenTypes.GE;
import static com.dingyi.editor.language.lua.LuaTokenTypes.GETN;
import static com.dingyi.editor.language.lua.LuaTokenTypes.GOTO;
import static com.dingyi.editor.language.lua.LuaTokenTypes.GT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.IF;
import static com.dingyi.editor.language.lua.LuaTokenTypes.IN;
import static com.dingyi.editor.language.lua.LuaTokenTypes.LAMBDA;
import static com.dingyi.editor.language.lua.LuaTokenTypes.LBRACK;
import static com.dingyi.editor.language.lua.LuaTokenTypes.LCURLY;
import static com.dingyi.editor.language.lua.LuaTokenTypes.LE;
import static com.dingyi.editor.language.lua.LuaTokenTypes.LEF;
import static com.dingyi.editor.language.lua.LuaTokenTypes.LOCAL;
import static com.dingyi.editor.language.lua.LuaTokenTypes.LONG_STRING;
import static com.dingyi.editor.language.lua.LuaTokenTypes.LPAREN;
import static com.dingyi.editor.language.lua.LuaTokenTypes.LT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.MEAN;
import static com.dingyi.editor.language.lua.LuaTokenTypes.MINUS;
import static com.dingyi.editor.language.lua.LuaTokenTypes.MOD;
import static com.dingyi.editor.language.lua.LuaTokenTypes.MULT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.NAME;
import static com.dingyi.editor.language.lua.LuaTokenTypes.NE;
import static com.dingyi.editor.language.lua.LuaTokenTypes.NEW_LINE;
import static com.dingyi.editor.language.lua.LuaTokenTypes.NIL;
import static com.dingyi.editor.language.lua.LuaTokenTypes.NOT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.NUMBER;
import static com.dingyi.editor.language.lua.LuaTokenTypes.OR;
import static com.dingyi.editor.language.lua.LuaTokenTypes.PLUS;
import static com.dingyi.editor.language.lua.LuaTokenTypes.RBRACK;
import static com.dingyi.editor.language.lua.LuaTokenTypes.RCURLY;
import static com.dingyi.editor.language.lua.LuaTokenTypes.REGION;
import static com.dingyi.editor.language.lua.LuaTokenTypes.REPEAT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.RETURN;
import static com.dingyi.editor.language.lua.LuaTokenTypes.RPAREN;
import static com.dingyi.editor.language.lua.LuaTokenTypes.SEMI;
import static com.dingyi.editor.language.lua.LuaTokenTypes.SHEBANG;
import static com.dingyi.editor.language.lua.LuaTokenTypes.SHEBANG_CONTENT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.SHORT_COMMENT;
import static com.dingyi.editor.language.lua.LuaTokenTypes.STRING;
import static com.dingyi.editor.language.lua.LuaTokenTypes.SWITCH;
import static com.dingyi.editor.language.lua.LuaTokenTypes.THEN;
import static com.dingyi.editor.language.lua.LuaTokenTypes.TRUE;
import static com.dingyi.editor.language.lua.LuaTokenTypes.UNTIL;
import static com.dingyi.editor.language.lua.LuaTokenTypes.WHEN;
import static com.dingyi.editor.language.lua.LuaTokenTypes.WHILE;
import static com.dingyi.editor.language.lua.LuaTokenTypes.WHITE_SPACE;

import java.io.IOException;
import java.io.Reader;

/**
 * This class is a scanner generated by
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>D:/JFLEX/bin/lua.flex</tt>
 */
public class LuaLexer {

    /**
     * This character denotes the end of file
     */
    public static final int YYEOF = -1;

    /**
     * initial size of the lookahead buffer
     */
    private static final int ZZ_BUFFERSIZE = 16384;

    /**
     * lexical states
     */
    public static final int YYINITIAL = 0;
    public static final int xSHEBANG = 2;
    public static final int xDOUBLE_QUOTED_STRING = 4;
    public static final int xSINGLE_QUOTED_STRING = 6;
    public static final int xBLOCK_STRING = 8;
    public static final int xCOMMENT = 10;
    public static final int xBLOCK_COMMENT = 12;

    /**
     * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
     * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
     * at the beginning of a line
     * l is of the form l = 2*k, k a non negative integer
     */
    private static final int ZZ_LEXSTATE[] = {
            0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6
    };

    /**
     * Translates characters to character classes
     */
    private static final String ZZ_CMAP_PACKED =
            "\11\34\1\3\1\2\1\0\1\3\1\1\16\34\4\33\1\3\1\53" +
                    "\1\31\1\52\1\4\1\60\1\72\1\35\1\62\1\63\1\57\1\11" +
                    "\1\66\1\16\1\15\1\61\1\13\11\6\1\70\1\67\1\55\1\27" +
                    "\1\54\1\33\1\75\4\7\1\10\1\7\11\4\1\12\7\4\1\14" +
                    "\2\4\1\26\1\32\1\30\1\71\1\4\1\33\1\36\1\37\1\45" +
                    "\1\25\1\20\1\43\1\21\1\50\1\22\1\4\1\40\1\41\1\74" +
                    "\1\24\1\23\1\47\1\4\1\17\1\42\1\46\1\44\1\4\1\51" +
                    "\1\14\2\4\1\64\1\73\1\65\1\56\6\34\1\5\32\34\1\0" +
                    "\1\33\4\4\4\33\1\4\2\33\1\34\7\33\1\4\4\33\1\4" +
                    "\5\33\27\4\1\33\37\4\1\33\u01ca\4\4\33\14\4\16\33\5\4" +
                    "\7\33\1\4\1\33\1\4\21\33\160\34\5\4\1\33\2\4\2\33" +
                    "\4\4\10\33\1\4\1\33\3\4\1\33\1\4\1\33\24\4\1\33" +
                    "\123\4\1\33\213\4\1\33\5\34\2\33\236\4\11\33\46\4\2\33" +
                    "\1\4\7\33\47\4\7\33\1\4\1\33\55\34\1\33\1\34\1\33" +
                    "\2\34\1\33\2\34\1\33\1\34\10\33\33\4\5\33\3\4\15\33" +
                    "\5\34\6\33\1\4\4\33\13\34\5\33\53\4\37\34\4\33\2\4" +
                    "\1\34\143\4\1\33\1\4\10\34\1\33\6\34\2\4\2\34\1\33" +
                    "\4\34\2\4\12\34\3\4\2\33\1\4\17\33\1\34\1\4\1\34" +
                    "\36\4\33\34\2\33\131\4\13\34\1\4\16\33\12\34\41\4\11\34" +
                    "\2\4\4\33\1\4\5\33\26\4\4\34\1\4\11\34\1\4\3\34" +
                    "\1\4\5\34\22\33\31\4\3\34\104\33\1\4\1\33\13\4\67\33" +
                    "\33\34\1\33\4\34\66\4\3\34\1\4\22\34\1\4\7\34\12\4" +
                    "\2\34\2\33\12\34\1\33\7\4\1\33\7\4\1\33\3\34\1\33" +
                    "\10\4\2\33\2\4\2\33\26\4\1\33\7\4\1\33\1\4\3\33" +
                    "\4\4\2\33\1\34\1\4\7\34\2\33\2\34\2\33\3\34\1\4" +
                    "\10\33\1\34\4\33\2\4\1\33\3\4\2\34\2\33\12\34\4\4" +
                    "\7\33\1\4\5\33\3\34\1\33\6\4\4\33\2\4\2\33\26\4" +
                    "\1\33\7\4\1\33\2\4\1\33\2\4\1\33\2\4\2\33\1\34" +
                    "\1\33\5\34\4\33\2\34\2\33\3\34\3\33\1\34\7\33\4\4" +
                    "\1\33\1\4\7\33\14\34\3\4\1\34\13\33\3\34\1\33\11\4" +
                    "\1\33\3\4\1\33\26\4\1\33\7\4\1\33\2\4\1\33\5\4" +
                    "\2\33\1\34\1\4\10\34\1\33\3\34\1\33\3\34\2\33\1\4" +
                    "\17\33\2\4\2\34\2\33\12\34\1\33\1\4\17\33\3\34\1\33" +
                    "\10\4\2\33\2\4\2\33\26\4\1\33\7\4\1\33\2\4\1\33" +
                    "\5\4\2\33\1\34\1\4\7\34\2\33\2\34\2\33\3\34\10\33" +
                    "\2\34\4\33\2\4\1\33\3\4\2\34\2\33\12\34\1\33\1\4" +
                    "\20\33\1\34\1\4\1\33\6\4\3\33\3\4\1\33\4\4\3\33" +
                    "\2\4\1\33\1\4\1\33\2\4\3\33\2\4\3\33\3\4\3\33" +
                    "\14\4\4\33\5\34\3\33\3\34\1\33\4\34\2\33\1\4\6\33" +
                    "\1\34\16\33\12\34\11\33\1\4\7\33\3\34\1\33\10\4\1\33" +
                    "\3\4\1\33\27\4\1\33\12\4\1\33\5\4\3\33\1\4\7\34" +
                    "\1\33\3\34\1\33\4\34\7\33\2\34\1\33\2\4\6\33\2\4" +
                    "\2\34\2\33\12\34\22\33\2\34\1\33\10\4\1\33\3\4\1\33" +
                    "\27\4\1\33\12\4\1\33\5\4\2\33\1\34\1\4\7\34\1\33" +
                    "\3\34\1\33\4\34\7\33\2\34\7\33\1\4\1\33\2\4\2\34" +
                    "\2\33\12\34\1\33\2\4\17\33\2\34\1\33\10\4\1\33\3\4" +
                    "\1\33\51\4\2\33\1\4\7\34\1\33\3\34\1\33\4\34\1\4" +
                    "\10\33\1\34\10\33\2\4\2\34\2\33\12\34\12\33\6\4\2\33" +
                    "\2\34\1\33\22\4\3\33\30\4\1\33\11\4\1\33\1\4\2\33" +
                    "\7\4\3\33\1\34\4\33\6\34\1\33\1\34\1\33\10\34\22\33" +
                    "\2\34\15\33\60\4\1\34\2\4\7\34\4\33\10\4\10\34\1\33" +
                    "\12\34\47\33\2\4\1\33\1\4\2\33\2\4\1\33\1\4\2\33" +
                    "\1\4\6\33\4\4\1\33\7\4\1\33\3\4\1\33\1\4\1\33" +
                    "\1\4\2\33\2\4\1\33\4\4\1\34\2\4\6\34\1\33\2\34" +
                    "\1\4\2\33\5\4\1\33\1\4\1\33\6\34\2\33\12\34\2\33" +
                    "\4\4\40\33\1\4\27\33\2\34\6\33\12\34\13\33\1\34\1\33" +
                    "\1\34\1\33\1\34\4\33\2\34\10\4\1\33\44\4\4\33\24\34" +
                    "\1\33\2\34\5\4\13\34\1\33\44\34\11\33\1\34\71\33\53\4" +
                    "\24\34\1\4\12\34\6\33\6\4\4\34\4\4\3\34\1\4\3\34" +
                    "\2\4\7\34\3\4\4\34\15\4\14\34\1\4\17\34\2\33\46\4" +
                    "\1\33\1\4\5\33\1\4\2\33\53\4\1\33\u014d\4\1\33\4\4" +
                    "\2\33\7\4\1\33\1\4\1\33\4\4\2\33\51\4\1\33\4\4" +
                    "\2\33\41\4\1\33\4\4\2\33\7\4\1\33\1\4\1\33\4\4" +
                    "\2\33\17\4\1\33\71\4\1\33\4\4\2\33\103\4\2\33\3\34" +
                    "\40\33\20\4\20\33\125\4\14\33\u026c\4\2\33\21\4\1\0\32\4" +
                    "\5\33\113\4\3\33\3\4\17\33\15\4\1\33\4\4\3\34\13\33" +
                    "\22\4\3\34\13\33\22\4\2\34\14\33\15\4\1\33\3\4\1\33" +
                    "\2\34\14\33\64\4\40\34\3\33\1\4\3\33\2\4\1\34\2\33" +
                    "\12\34\41\33\3\34\2\33\12\34\6\33\130\4\10\33\51\4\1\34" +
                    "\1\4\5\33\106\4\12\33\35\4\3\33\14\34\4\33\14\34\12\33" +
                    "\12\34\36\4\2\33\5\4\13\33\54\4\4\33\21\34\7\4\2\34" +
                    "\6\33\12\34\46\33\27\4\5\34\4\33\65\4\12\34\1\33\35\34" +
                    "\2\33\13\34\6\33\12\34\15\33\1\4\130\33\5\34\57\4\21\34" +
                    "\7\4\4\33\12\34\21\33\11\34\14\33\3\34\36\4\15\34\2\4" +
                    "\12\34\54\4\16\34\14\33\44\4\24\34\10\33\12\34\3\33\3\4" +
                    "\12\34\44\4\122\33\3\34\1\33\25\34\4\4\1\34\4\4\3\34" +
                    "\2\4\11\33\300\4\47\34\25\33\4\34\u0116\4\2\33\6\4\2\33" +
                    "\46\4\2\33\6\4\2\33\10\4\1\33\1\4\1\33\1\4\1\33" +
                    "\1\4\1\33\37\4\2\33\65\4\1\33\7\4\1\33\1\4\3\33" +
                    "\3\4\1\33\7\4\3\33\4\4\2\33\6\4\4\33\15\4\5\33" +
                    "\3\4\1\33\7\4\3\33\13\0\5\34\30\33\2\0\5\34\1\0" +
                    "\17\33\2\4\23\33\1\4\12\33\1\0\5\34\5\33\6\34\1\33" +
                    "\1\4\15\33\1\4\20\33\15\4\3\33\33\4\25\33\15\34\4\33" +
                    "\1\34\3\33\14\34\21\33\1\4\4\33\1\4\2\33\12\4\1\33" +
                    "\1\4\3\33\5\4\6\33\1\4\1\33\1\4\1\33\1\4\1\33" +
                    "\4\4\1\33\13\4\2\33\4\4\5\33\5\4\4\33\1\4\21\33" +
                    "\51\4\u0a77\33\57\4\1\33\57\4\1\33\205\4\6\33\4\4\3\34" +
                    "\2\4\14\33\46\4\1\33\1\4\5\33\1\4\2\33\70\4\7\33" +
                    "\1\4\17\33\1\34\27\4\11\33\7\4\1\33\7\4\1\33\7\4" +
                    "\1\33\7\4\1\33\7\4\1\33\7\4\1\33\7\4\1\33\7\4" +
                    "\1\33\40\34\57\33\1\4\u01d0\33\1\0\4\33\3\4\31\33\11\4" +
                    "\6\34\1\33\5\4\2\33\5\4\4\33\126\4\2\33\2\34\2\33" +
                    "\3\4\1\33\132\4\1\33\4\4\5\33\51\4\3\33\136\4\21\33" +
                    "\33\4\65\33\20\4\u0200\33\u19b6\4\112\33\u51cd\4\63\33\u048d\4\103\33" +
                    "\56\4\2\33\u010d\4\3\33\20\4\12\34\2\4\24\33\57\4\1\34" +
                    "\4\33\12\34\1\33\31\4\7\33\1\34\120\4\2\34\45\33\11\4" +
                    "\2\33\147\4\2\33\4\4\1\33\4\4\14\33\13\4\115\33\12\4" +
                    "\1\34\3\4\1\34\4\4\1\34\27\4\5\34\20\33\1\4\7\33" +
                    "\64\4\14\33\2\34\62\4\21\34\13\33\12\34\6\33\22\34\6\4" +
                    "\3\33\1\4\4\33\12\34\34\4\10\34\2\33\27\4\15\34\14\33" +
                    "\35\4\3\33\4\34\57\4\16\34\16\33\1\4\12\34\46\33\51\4" +
                    "\16\34\11\33\3\4\1\34\10\4\2\34\2\33\12\34\6\33\27\4" +
                    "\3\33\1\4\1\34\4\33\60\4\1\34\1\4\3\34\2\4\2\34" +
                    "\5\4\2\34\1\4\1\34\1\4\30\33\3\4\2\33\13\4\5\34" +
                    "\2\33\3\4\2\34\12\33\6\4\2\33\6\4\2\33\6\4\11\33" +
                    "\7\4\1\33\7\4\221\33\43\4\10\34\1\33\2\34\2\33\12\34" +
                    "\6\33\u2ba4\4\14\33\27\4\4\33\61\4\u2104\33\u016e\4\2\33\152\4" +
                    "\46\33\7\4\14\33\5\4\5\33\1\4\1\34\12\4\1\33\15\4" +
                    "\1\33\5\4\1\33\1\4\1\33\2\4\1\33\2\4\1\33\154\4" +
                    "\41\33\u016b\4\22\33\100\4\2\33\66\4\50\33\15\4\3\33\20\34" +
                    "\20\33\7\34\14\33\2\4\30\33\3\4\31\33\1\4\6\33\5\4" +
                    "\1\33\207\4\2\33\1\34\4\33\1\4\13\33\12\34\7\33\32\4" +
                    "\4\33\1\4\1\33\32\4\13\33\131\4\3\33\6\4\2\33\6\4" +
                    "\2\33\6\4\2\33\3\4\3\33\2\4\3\33\2\4\22\33\3\34" +
                    "\4\33\14\4\1\33\32\4\1\33\23\4\1\33\2\4\1\33\17\4" +
                    "\2\33\16\4\42\33\173\4\105\33\65\4\210\33\1\34\202\33\35\4" +
                    "\3\33\61\4\57\33\37\4\21\33\33\4\65\33\36\4\2\33\44\4" +
                    "\4\33\10\4\1\33\5\4\52\33\236\4\2\33\12\34\u0356\33\6\4" +
                    "\2\33\1\4\1\33\54\4\1\33\2\4\3\33\1\4\2\33\27\4" +
                    "\252\33\26\4\12\33\32\4\106\33\70\4\6\33\2\4\100\33\1\4" +
                    "\3\34\1\33\2\34\5\33\4\34\4\4\1\33\3\4\1\33\33\4" +
                    "\4\33\3\34\4\33\1\34\40\33\35\4\203\33\66\4\12\33\26\4" +
                    "\12\33\23\4\215\33\111\4\u03b7\33\3\34\65\4\17\34\37\33\12\34" +
                    "\20\33\3\34\55\4\13\34\2\33\1\34\22\33\31\4\7\33\12\34" +
                    "\6\33\3\34\44\4\16\34\1\33\12\34\100\33\3\34\60\4\16\34" +
                    "\4\4\13\33\12\34\u04a6\33\53\4\15\34\10\33\12\34\u0936\33\u036f\4" +
                    "\221\33\143\4\u0b9d\33\u042f\4\u33d1\33\u0239\4\u04c7\33\105\4\13\33\1\4" +
                    "\56\34\20\33\4\34\15\4\u4060\33\2\4\u2163\33\5\34\3\33\26\34" +
                    "\2\33\7\34\36\33\4\34\224\33\3\34\u01bb\33\125\4\1\33\107\4" +
                    "\1\33\2\4\2\33\1\4\2\33\2\4\2\33\4\4\1\33\14\4" +
                    "\1\33\1\4\1\33\7\4\1\33\101\4\1\33\4\4\2\33\10\4" +
                    "\1\33\7\4\1\33\34\4\1\33\4\4\1\33\5\4\1\33\1\4" +
                    "\3\33\7\4\1\33\u0154\4\2\33\31\4\1\33\31\4\1\33\37\4" +
                    "\1\33\31\4\1\33\37\4\1\33\31\4\1\33\37\4\1\33\31\4" +
                    "\1\33\37\4\1\33\31\4\1\33\10\4\2\33\62\34\u1600\33\4\4" +
                    "\1\33\33\4\1\33\2\4\1\33\1\4\2\33\1\4\1\33\12\4" +
                    "\1\33\4\4\1\33\1\4\1\33\1\4\6\33\1\4\4\33\1\4" +
                    "\1\33\1\4\1\33\1\4\1\33\3\4\1\33\2\4\1\33\1\4" +
                    "\2\33\1\4\1\33\1\4\1\33\1\4\1\33\1\4\1\33\1\4" +
                    "\1\33\2\4\1\33\1\4\2\33\4\4\1\33\7\4\1\33\4\4" +
                    "\1\33\4\4\1\33\1\4\1\33\12\4\1\33\21\4\5\33\3\4" +
                    "\1\33\5\4\1\33\21\4\u1144\33\ua6d7\4\51\33\u1035\4\13\33\336\4" +
                    "\u3fe2\33\u021e\4\uffff\33\uffff\33\uffff\33\uffff\33\uffff\33\uffff\33\uffff\33\uffff\33\uffff\33\uffff\33\uffff\33\u05ee\33" +
                    "\1\34\36\33\140\34\200\33\360\34\uffff\33\uffff\33\ufe12\33";

    /**
     * Translates characters to character classes
     */
    private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

    /**
     * Translates DFA states to action switch labels.
     */
    private static final int[] ZZ_ACTION = zzUnpackAction();

    private static final String ZZ_ACTION_PACKED_0 =
            "\1\0\1\1\5\0\1\2\2\3\1\4\1\5\1\6" +
                    "\1\7\1\6\1\10\1\11\7\5\1\12\1\13\1\14" +
                    "\1\15\1\2\1\16\11\5\1\17\1\20\1\21\1\22" +
                    "\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32" +
                    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\2\42" +
                    "\1\2\1\0\2\43\2\6\1\0\1\6\1\44\1\45" +
                    "\4\5\1\46\1\47\1\50\3\5\1\51\1\52\1\0" +
                    "\1\53\2\0\16\5\1\54\1\55\1\56\1\57\1\60" +
                    "\1\61\1\62\1\63\1\64\1\50\1\42\4\0\1\65" +
                    "\2\0\2\6\1\66\2\0\2\5\1\67\2\5\1\70" +
                    "\1\20\1\5\1\71\1\72\1\64\4\5\1\73\11\5" +
                    "\1\0\1\65\1\74\1\0\1\6\4\0\2\5\1\75" +
                    "\1\76\12\5\1\77\1\100\1\101\1\102\1\5\1\103" +
                    "\2\0\1\104\1\6\2\0\3\5\1\105\1\5\1\106" +
                    "\1\107\2\5\1\110\1\5\1\111\1\5\1\112\1\0" +
                    "\1\6\2\0\1\113\1\114\1\115\1\5\1\116\1\117" +
                    "\2\5\3\0\1\120\2\5\1\121\1\0\1\122\1\123" +
                    "\1\121\2\0\2\124";

    private static int[] zzUnpackAction() {
        int[] result = new int[224];
        int offset = 0;
        offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAction(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }


    /**
     * Translates a state to a row index in the transition table
     */
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();

    private static final String ZZ_ROWMAP_PACKED_0 =
            "\0\0\0\76\0\174\0\272\0\370\0\u0136\0\u0174\0\u01b2" +
                    "\0\u01f0\0\u01b2\0\u022e\0\u026c\0\u02aa\0\u01b2\0\u02e8\0\u0326" +
                    "\0\u0364\0\u03a2\0\u03e0\0\u041e\0\u045c\0\u049a\0\u04d8\0\u0516" +
                    "\0\u0554\0\u0592\0\u01b2\0\u01b2\0\u05d0\0\u01b2\0\u060e\0\u064c" +
                    "\0\u068a\0\u06c8\0\u0706\0\u0744\0\u0782\0\u07c0\0\u07fe\0\u083c" +
                    "\0\u087a\0\u08b8\0\u08f6\0\u087a\0\u01b2\0\u01b2\0\u0934\0\u01b2" +
                    "\0\u01b2\0\u01b2\0\u01b2\0\u01b2\0\u01b2\0\u0972\0\u01b2\0\u09b0" +
                    "\0\u09ee\0\u01b2\0\u0a2c\0\u0a6a\0\u0aa8\0\u0ae6\0\u01b2\0\u0b24" +
                    "\0\u0b62\0\u0ba0\0\u0bde\0\u0c1c\0\u0c5a\0\u0c98\0\u0cd6\0\u0d14" +
                    "\0\u0d52\0\u0d90\0\u026c\0\u026c\0\u026c\0\u0dce\0\u0e0c\0\u0e4a" +
                    "\0\u026c\0\u01b2\0\u0554\0\u01b2\0\u0e88\0\u0ec6\0\u0f04\0\u0f42" +
                    "\0\u0f80\0\u0fbe\0\u0ffc\0\u103a\0\u1078\0\u10b6\0\u10f4\0\u1132" +
                    "\0\u1170\0\u11ae\0\u11ec\0\u122a\0\u01b2\0\u01b2\0\u01b2\0\u01b2" +
                    "\0\u01b2\0\u01b2\0\u01b2\0\u01b2\0\u01b2\0\u01b2\0\u01b2\0\u1268" +
                    "\0\u12a6\0\u12e4\0\u0aa8\0\u1322\0\u1360\0\u0c1c\0\u139e\0\u13dc" +
                    "\0\u01b2\0\u141a\0\u1458\0\u1496\0\u14d4\0\u026c\0\u1512\0\u1550" +
                    "\0\u026c\0\u026c\0\u158e\0\u01b2\0\u01b2\0\u026c\0\u15cc\0\u160a" +
                    "\0\u1648\0\u1686\0\u026c\0\u16c4\0\u1702\0\u1740\0\u177e\0\u17bc" +
                    "\0\u17fa\0\u1838\0\u1876\0\u18b4\0\u18f2\0\u1930\0\u196e\0\u19ac" +
                    "\0\u19ea\0\u0b62\0\u1a28\0\u1a66\0\u1aa4\0\u1ae2\0\u1b20\0\u1b5e" +
                    "\0\u026c\0\u1b9c\0\u1bda\0\u1c18\0\u1c56\0\u1c94\0\u1cd2\0\u1d10" +
                    "\0\u1d4e\0\u1d8c\0\u1dca\0\u026c\0\u026c\0\u026c\0\u026c\0\u1e08" +
                    "\0\u18f2\0\u1e46\0\u1e84\0\u1ec2\0\u1f00\0\u1f3e\0\u1f7c\0\u1fba" +
                    "\0\u1ff8\0\u2036\0\u026c\0\u2074\0\u026c\0\u026c\0\u20b2\0\u20f0" +
                    "\0\u026c\0\u212e\0\u026c\0\u216c\0\u026c\0\u21aa\0\u21e8\0\u2226" +
                    "\0\u2264\0\u026c\0\u026c\0\u026c\0\u22a2\0\u026c\0\u026c\0\u22e0" +
                    "\0\u231e\0\u235c\0\u239a\0\u23d8\0\u026c\0\u2416\0\u2454\0\u2492" +
                    "\0\u24d0\0\u026c\0\u026c\0\u250e\0\u254c\0\u258a\0\u25c8\0\u2606";

    private static int[] zzUnpackRowMap() {
        int[] result = new int[224];
        int offset = 0;
        offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackRowMap(String packed, int offset, int[] result) {
        int i = 0;  /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int high = packed.charAt(i++) << 16;
            result[j++] = high | packed.charAt(i++);
        }
        return j;
    }

    /**
     * The transition table of the DFA
     */
    private static final int[] ZZ_TRANS = zzUnpackTrans();

    private static final String ZZ_TRANS_PACKED_0 =
            "\1\10\1\11\1\12\1\13\1\14\1\10\1\15\2\14" +
                    "\1\16\1\14\1\17\1\14\1\20\1\21\1\22\1\23" +
                    "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33" +
                    "\1\34\1\35\2\10\1\36\1\37\1\40\1\14\1\41" +
                    "\1\42\1\43\1\44\1\45\1\46\2\14\1\47\1\50" +
                    "\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60" +
                    "\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70" +
                    "\1\71\1\14\1\72\1\2\2\0\73\2\31\0\1\73" +
                    "\101\0\1\74\40\0\26\10\1\75\47\10\16\0\1\76" +
                    "\57\0\16\77\1\100\57\77\100\0\1\12\76\0\1\13" +
                    "\76\0\5\14\1\0\3\14\2\0\7\14\6\0\1\14" +
                    "\1\0\14\14\22\0\1\14\7\0\1\15\1\0\1\101" +
                    "\2\0\1\15\1\0\1\102\2\0\1\101\63\0\1\15" +
                    "\1\0\1\101\2\0\1\15\1\103\1\102\2\0\1\101" +
                    "\63\0\1\104\4\0\1\104\1\0\1\105\76\0\1\106" +
                    "\63\0\5\14\1\0\3\14\2\0\1\14\1\107\5\14" +
                    "\6\0\1\14\1\0\14\14\22\0\1\14\5\0\5\14" +
                    "\1\0\3\14\2\0\5\14\1\110\1\14\6\0\1\14" +
                    "\1\0\3\14\1\111\10\14\22\0\1\14\5\0\5\14" +
                    "\1\0\3\14\2\0\4\14\1\112\2\14\6\0\1\14" +
                    "\1\0\14\14\22\0\1\14\5\0\5\14\1\0\3\14" +
                    "\2\0\5\14\1\113\1\14\6\0\1\14\1\0\5\14" +
                    "\1\114\6\14\22\0\1\14\5\0\5\14\1\0\3\14" +
                    "\2\0\1\115\6\14\6\0\1\14\1\0\14\14\22\0" +
                    "\1\14\5\0\5\14\1\0\3\14\2\0\3\14\1\116" +
                    "\1\117\2\14\6\0\1\14\1\0\14\14\22\0\1\14" +
                    "\5\0\5\14\1\0\3\14\2\0\1\14\1\120\2\14" +
                    "\1\121\2\14\6\0\1\14\1\0\14\14\22\0\1\14" +
                    "\27\0\1\122\1\123\75\0\1\124\64\0\1\125\10\0" +
                    "\1\126\52\0\5\14\1\0\3\14\2\0\5\14\1\127" +
                    "\1\14\6\0\1\14\1\0\14\14\22\0\1\14\5\0" +
                    "\5\14\1\0\3\14\2\0\1\130\6\14\6\0\1\14" +
                    "\1\0\14\14\22\0\1\14\5\0\5\14\1\0\3\14" +
                    "\2\0\4\14\1\131\2\14\6\0\1\14\1\0\1\132" +
                    "\13\14\22\0\1\14\5\0\5\14\1\0\3\14\2\0" +
                    "\7\14\6\0\1\14\1\0\13\14\1\133\22\0\1\14" +
                    "\5\0\5\14\1\0\3\14\2\0\4\14\1\134\2\14" +
                    "\6\0\1\14\1\0\1\135\5\14\1\136\5\14\22\0" +
                    "\1\14\5\0\5\14\1\0\3\14\2\0\5\14\1\137" +
                    "\1\14\6\0\1\14\1\0\14\14\22\0\1\14\5\0" +
                    "\5\14\1\0\3\14\2\0\4\14\1\140\2\14\6\0" +
                    "\1\14\1\0\1\141\13\14\22\0\1\14\5\0\5\14" +
                    "\1\0\3\14\2\0\1\142\6\14\6\0\1\14\1\0" +
                    "\12\14\1\143\1\14\22\0\1\14\5\0\5\14\1\0" +
                    "\3\14\2\0\7\14\6\0\1\14\1\0\12\14\1\144" +
                    "\1\14\22\0\1\14\54\0\1\145\51\0\1\146\75\0" +
                    "\1\147\24\0\1\150\50\0\1\151\25\0\1\152\101\0" +
                    "\1\153\104\0\1\154\77\0\1\155\76\0\1\156\2\0" +
                    "\31\73\1\157\1\160\43\73\32\74\1\161\2\74\1\157" +
                    "\40\74\26\0\1\162\1\163\64\0\1\164\75\0\1\165" +
                    "\65\0\1\104\2\0\1\166\1\0\1\104\2\0\1\166" +
                    "\65\0\1\167\4\0\1\167\70\0\3\170\2\0\1\170" +
                    "\4\0\1\170\4\0\1\170\10\0\2\170\3\0\1\170" +
                    "\1\0\1\170\36\0\1\104\4\0\1\104\77\0\1\171" +
                    "\77\0\1\172\1\173\61\0\5\14\1\0\3\14\2\0" +
                    "\7\14\6\0\1\14\1\0\10\14\1\174\1\175\2\14" +
                    "\22\0\1\14\5\0\5\14\1\0\3\14\2\0\6\14" +
                    "\1\176\6\0\1\14\1\0\14\14\22\0\1\14\5\0" +
                    "\5\14\1\0\3\14\2\0\7\14\6\0\1\14\1\0" +
                    "\4\14\1\177\7\14\22\0\1\14\5\0\5\14\1\0" +
                    "\3\14\2\0\7\14\6\0\1\14\1\0\10\14\1\200" +
                    "\3\14\22\0\1\14\5\0\5\14\1\0\3\14\2\0" +
                    "\7\14\6\0\1\14\1\0\3\14\1\201\10\14\22\0" +
                    "\1\14\5\0\5\14\1\0\3\14\2\0\7\14\6\0" +
                    "\1\14\1\0\10\14\1\202\3\14\22\0\1\14\5\0" +
                    "\5\14\1\0\3\14\2\0\7\14\6\0\1\14\1\0" +
                    "\5\14\1\203\6\14\22\0\1\14\55\0\1\204\75\0" +
                    "\1\205\25\0\5\14\1\0\3\14\2\0\6\14\1\206" +
                    "\6\0\1\14\1\0\14\14\22\0\1\14\5\0\5\14" +
                    "\1\0\3\14\2\0\1\14\1\207\5\14\6\0\1\14" +
                    "\1\0\14\14\22\0\1\14\5\0\5\14\1\0\3\14" +
                    "\2\0\7\14\6\0\1\14\1\0\7\14\1\210\4\14" +
                    "\22\0\1\14\5\0\5\14\1\0\3\14\2\0\7\14" +
                    "\6\0\1\14\1\0\14\14\22\0\1\211\5\0\5\14" +
                    "\1\0\3\14\2\0\3\14\1\212\3\14\6\0\1\14" +
                    "\1\0\14\14\22\0\1\14\5\0\5\14\1\0\3\14" +
                    "\2\0\1\213\6\14\6\0\1\14\1\0\14\14\22\0" +
                    "\1\14\5\0\5\14\1\0\3\14\2\0\7\14\6\0" +
                    "\1\14\1\0\3\14\1\214\10\14\22\0\1\14\5\0" +
                    "\5\14\1\0\3\14\2\0\5\14\1\215\1\14\6\0" +
                    "\1\14\1\0\14\14\22\0\1\14\5\0\5\14\1\0" +
                    "\3\14\2\0\7\14\6\0\1\14\1\0\10\14\1\216" +
                    "\3\14\22\0\1\14\5\0\5\14\1\0\3\14\2\0" +
                    "\5\14\1\217\1\14\6\0\1\14\1\0\14\14\22\0" +
                    "\1\14\5\0\5\14\1\0\3\14\2\0\7\14\6\0" +
                    "\1\14\1\0\4\14\1\220\7\14\22\0\1\14\5\0" +
                    "\5\14\1\0\3\14\2\0\7\14\6\0\1\14\1\0" +
                    "\6\14\1\221\5\14\22\0\1\14\5\0\5\14\1\0" +
                    "\3\14\2\0\1\14\1\222\5\14\6\0\1\14\1\0" +
                    "\14\14\22\0\1\14\5\0\5\14\1\0\3\14\2\0" +
                    "\1\14\1\223\1\14\1\224\3\14\6\0\1\14\1\0" +
                    "\14\14\22\0\1\14\2\0\2\73\1\0\1\73\1\0" +
                    "\70\73\1\0\2\74\1\0\1\74\1\0\70\74\30\162" +
                    "\1\225\45\162\1\226\2\0\13\226\1\227\57\226\26\0" +
                    "\1\230\55\0\1\167\1\0\1\101\2\0\1\167\4\0" +
                    "\1\101\63\0\2\170\1\231\1\0\1\232\1\170\1\0" +
                    "\1\233\2\0\1\231\4\0\1\170\10\0\2\170\3\0" +
                    "\1\170\1\0\1\170\1\0\1\232\46\0\1\234\101\0" +
                    "\1\235\55\0\5\14\1\0\3\14\2\0\7\14\6\0" +
                    "\1\14\1\0\6\14\1\236\5\14\22\0\1\14\5\0" +
                    "\5\14\1\0\3\14\2\0\1\14\1\237\5\14\6\0" +
                    "\1\14\1\0\14\14\22\0\1\14\5\0\5\14\1\0" +
                    "\3\14\2\0\1\14\1\240\5\14\6\0\1\14\1\0" +
                    "\14\14\22\0\1\14\5\0\5\14\1\0\3\14\2\0" +
                    "\4\14\1\241\2\14\6\0\1\14\1\0\14\14\22\0" +
                    "\1\14\5\0\5\14\1\0\3\14\2\0\1\14\1\242" +
                    "\5\14\6\0\1\14\1\0\1\243\13\14\22\0\1\14" +
                    "\5\0\5\14\1\0\3\14\2\0\7\14\6\0\1\14" +
                    "\1\0\1\244\13\14\22\0\1\14\5\0\5\14\1\0" +
                    "\3\14\2\0\7\14\6\0\1\14\1\0\1\245\13\14" +
                    "\22\0\1\14\5\0\5\14\1\0\3\14\2\0\7\14" +
                    "\6\0\1\14\1\0\1\14\1\246\12\14\22\0\1\14" +
                    "\5\0\5\14\1\0\3\14\2\0\7\14\6\0\1\14" +
                    "\1\0\10\14\1\247\3\14\22\0\1\14\5\0\5\14" +
                    "\1\0\3\14\2\0\7\14\6\0\1\14\1\0\4\14" +
                    "\1\250\7\14\22\0\1\14\5\0\5\14\1\0\3\14" +
                    "\2\0\7\14\6\0\1\14\1\0\7\14\1\251\4\14" +
                    "\22\0\1\14\5\0\5\14\1\0\3\14\2\0\3\14" +
                    "\1\252\3\14\6\0\1\14\1\0\14\14\22\0\1\14" +
                    "\5\0\5\14\1\0\3\14\2\0\7\14\6\0\1\14" +
                    "\1\0\10\14\1\253\3\14\22\0\1\14\5\0\5\14" +
                    "\1\0\3\14\2\0\1\14\1\254\5\14\6\0\1\14" +
                    "\1\0\14\14\22\0\1\14\5\0\5\14\1\0\3\14" +
                    "\2\0\1\14\1\255\5\14\6\0\1\14\1\0\14\14" +
                    "\22\0\1\14\5\0\5\14\1\0\3\14\2\0\5\14" +
                    "\1\256\1\14\6\0\1\14\1\0\14\14\22\0\1\14" +
                    "\5\0\5\14\1\0\3\14\2\0\5\14\1\257\1\14" +
                    "\6\0\1\14\1\0\14\14\22\0\1\14\5\0\5\14" +
                    "\1\0\3\14\2\0\7\14\6\0\1\14\1\0\3\14" +
                    "\1\260\10\14\22\0\1\14\1\0\27\162\1\225\1\261" +
                    "\45\162\1\226\2\0\73\226\1\227\1\262\1\263\73\227" +
                    "\26\0\1\264\1\230\54\0\2\170\1\231\1\166\1\232" +
                    "\1\170\1\0\1\233\1\166\1\0\1\231\4\0\1\170" +
                    "\10\0\2\170\3\0\1\170\1\0\1\170\1\0\1\232" +
                    "\34\0\3\265\2\0\1\265\4\0\1\265\4\0\1\265" +
                    "\10\0\2\265\3\0\1\265\1\0\1\265\51\0\1\266" +
                    "\101\0\1\267\54\0\5\14\1\0\3\14\2\0\1\270" +
                    "\6\14\6\0\1\14\1\0\14\14\22\0\1\14\5\0" +
                    "\5\14\1\0\3\14\2\0\7\14\6\0\1\14\1\0" +
                    "\1\271\13\14\22\0\1\14\5\0\5\14\1\0\3\14" +
                    "\2\0\3\14\1\272\3\14\6\0\1\14\1\0\14\14" +
                    "\22\0\1\14\5\0\5\14\1\0\3\14\2\0\1\273" +
                    "\6\14\6\0\1\14\1\0\14\14\22\0\1\14\5\0" +
                    "\5\14\1\0\3\14\2\0\7\14\6\0\1\14\1\0" +
                    "\6\14\1\274\5\14\22\0\1\14\5\0\5\14\1\0" +
                    "\3\14\2\0\7\14\6\0\1\14\1\0\2\14\1\275" +
                    "\11\14\22\0\1\14\5\0\5\14\1\0\3\14\2\0" +
                    "\7\14\6\0\1\14\1\0\3\14\1\276\10\14\22\0" +
                    "\1\14\5\0\5\14\1\0\3\14\2\0\6\14\1\277" +
                    "\6\0\1\14\1\0\14\14\22\0\1\14\5\0\5\14" +
                    "\1\0\3\14\2\0\7\14\6\0\1\14\1\0\7\14" +
                    "\1\300\4\14\22\0\1\14\5\0\5\14\1\0\3\14" +
                    "\2\0\1\14\1\301\5\14\6\0\1\14\1\0\14\14" +
                    "\22\0\1\14\5\0\5\14\1\0\3\14\2\0\7\14" +
                    "\6\0\1\14\1\0\10\14\1\302\3\14\22\0\1\14" +
                    "\5\0\5\14\1\0\3\14\2\0\7\14\6\0\1\14" +
                    "\1\0\3\14\1\303\10\14\22\0\1\14\5\0\5\14" +
                    "\1\0\3\14\2\0\3\14\1\304\3\14\6\0\1\14" +
                    "\1\0\14\14\22\0\1\14\5\0\5\14\1\0\3\14" +
                    "\2\0\1\14\1\305\5\14\6\0\1\14\1\0\14\14" +
                    "\22\0\1\14\3\0\1\263\76\0\1\263\12\0\1\306" +
                    "\57\0\76\264\6\0\2\265\1\307\1\0\1\232\1\265" +
                    "\4\0\1\307\4\0\1\265\10\0\2\265\3\0\1\265" +
                    "\1\0\1\265\1\0\1\232\50\0\1\310\72\0\1\311" +
                    "\62\0\5\14\1\0\3\14\2\0\5\14\1\312\1\14" +
                    "\6\0\1\14\1\0\14\14\22\0\1\14\5\0\5\14" +
                    "\1\0\3\14\2\0\7\14\6\0\1\14\1\0\10\14" +
                    "\1\313\3\14\22\0\1\14\5\0\5\14\1\0\3\14" +
                    "\2\0\7\14\6\0\1\14\1\0\5\14\1\314\6\14" +
                    "\22\0\1\14\5\0\5\14\1\0\3\14\2\0\7\14" +
                    "\6\0\1\14\1\0\3\14\1\315\10\14\22\0\1\14" +
                    "\5\0\5\14\1\0\3\14\2\0\7\14\6\0\1\14" +
                    "\1\0\1\316\13\14\22\0\1\14\5\0\5\14\1\0" +
                    "\3\14\2\0\7\14\6\0\1\14\1\0\12\14\1\317" +
                    "\1\14\22\0\1\14\5\0\5\14\1\0\3\14\2\0" +
                    "\3\14\1\320\3\14\6\0\1\14\1\0\14\14\22\0" +
                    "\1\14\5\0\5\14\1\0\3\14\2\0\5\14\1\321" +
                    "\1\14\6\0\1\14\1\0\14\14\22\0\1\14\17\0" +
                    "\1\322\65\0\2\265\1\307\1\166\1\232\1\265\2\0" +
                    "\1\166\1\0\1\307\4\0\1\265\10\0\2\265\3\0" +
                    "\1\265\1\0\1\265\1\0\1\232\51\0\1\323\72\0" +
                    "\1\324\61\0\5\14\1\0\3\14\2\0\7\14\6\0" +
                    "\1\14\1\0\10\14\1\325\3\14\22\0\1\14\5\0" +
                    "\5\14\1\0\3\14\2\0\4\14\1\326\2\14\6\0" +
                    "\1\14\1\0\14\14\22\0\1\14\5\0\5\14\1\0" +
                    "\3\14\2\0\7\14\6\0\1\14\1\0\6\14\1\327" +
                    "\5\14\22\0\1\14\17\0\1\227\103\0\1\330\72\0" +
                    "\1\331\60\0\5\14\1\0\3\14\2\0\5\14\1\332" +
                    "\1\14\6\0\1\14\1\0\14\14\22\0\1\14\5\0" +
                    "\5\14\1\0\3\14\2\0\1\14\1\333\5\14\6\0" +
                    "\1\14\1\0\14\14\22\0\1\14\4\0\1\334\114\0" +
                    "\1\335\53\0\1\334\2\0\73\334\23\0\1\336\76\0" +
                    "\1\337\54\0\1\340\72\0\1\340\2\0\73\340";

    private static int[] zzUnpackTrans() {
        int[] result = new int[9796];
        int offset = 0;
        offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackTrans(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            value--;
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }


    /* error codes */
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;

    /* error messages for the codes above */
    private static final String ZZ_ERROR_MSG[] = {
            "Unknown internal scanner error",
            "Error: could not match input",
            "Error: pushback value was too large"
    };

    /**
     * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
     */
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();

    private static final String ZZ_ATTRIBUTE_PACKED_0 =
            "\1\0\1\1\5\0\1\11\1\1\1\11\3\1\1\11" +
                    "\14\1\2\11\1\1\1\11\16\1\2\11\1\1\6\11" +
                    "\1\1\1\11\2\1\1\11\3\1\1\0\1\11\3\1" +
                    "\1\0\16\1\1\11\1\0\1\11\2\0\16\1\13\11" +
                    "\4\0\1\1\2\0\2\1\1\11\2\0\10\1\2\11" +
                    "\17\1\1\0\2\1\1\0\1\1\4\0\24\1\2\0" +
                    "\2\1\2\0\16\1\1\0\1\1\2\0\10\1\3\0" +
                    "\4\1\1\0\3\1\2\0\2\1";

    private static int[] zzUnpackAttribute() {
        int[] result = new int[224];
        int offset = 0;
        offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAttribute(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    /**
     * the input device
     */
    private java.io.Reader zzReader;

    /**
     * the current state of the DFA
     */
    private int zzState;

    /**
     * the current lexical state
     */
    private int zzLexicalState = YYINITIAL;

    /**
     * this buffer contains the current text to be matched and is
     * the source of the yytext() string
     */
    private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

    /**
     * the textposition at the last accepting state
     */
    private int zzMarkedPos;

    /**
     * the current text position in the buffer
     */
    private int zzCurrentPos;

    /**
     * startRead marks the beginning of the yytext() string in the buffer
     */
    private int zzStartRead;

    /**
     * endRead marks the last character in the buffer, that has been read
     * from input
     */
    private int zzEndRead;

    /**
     * number of newlines encountered up to the start of the matched text
     */
    private int yyline;

    /**
     * the number of characters up to the start of the matched text
     */
    private int yychar;

    /**
     * the number of characters from the last newline up to the start of the
     * matched text
     */
    private int yycolumn;

    /**
     * zzAtBOL == true <=> the scanner is currently at the beginning of a line
     */
    private boolean zzAtBOL = true;

    /**
     * zzAtEOF == true <=> the scanner is at the EOF
     */
    private boolean zzAtEOF;

    /**
     * denotes if the user-EOF-code has already been executed
     */
    private boolean zzEOFDone;

    /**
     * The number of occupied positions in zzBuffer beyond zzEndRead.
     * When a lead/high surrogate has been read from the input stream
     * into the final zzBuffer position, this will have a value of 1;
     * otherwise, it will have a value of 0.
     */
    private int zzFinalHighSurrogate = 0;

    /* user code: */


    static class CharSeqReader extends Reader {
        int offset = 0;
        CharSequence src;

        CharSeqReader(CharSequence src) {
            this.src = src;
        }

        @Override
        public void close() throws IOException {
            src = null;
            offset = 0;
        }

        @Override
        public int read(char[] chars, int i, int i1) throws IOException {
            int len = Math.min(src.length() - offset, i1);
            for (int n = 0; n < len; n++) {
                try {
                    char c = src.charAt(offset++);
                    chars[i++] = c;
                } catch (Exception e) {

                }
            }
            if (len <= 0)
                return -1;
            return len;
        }
    }

    public LuaLexer(CharSequence src) {
        this(new CharSeqReader(src));
    }

    public int yyline() {
        return yyline;
    }

    public int yycolumn() {
        return yycolumn;
    }

    public int yychar() {
        return yychar;
    }

    private int nBrackets = 0;

    private boolean checkAhead(char c, int offset) {
        return this.zzMarkedPos + offset >= this.zzBuffer.length ? false : this.zzBuffer[this.zzMarkedPos + offset] == c;
    }

    private boolean checkBlock() {
        nBrackets = 0;
        if (checkAhead('[', 0)) {
            int n = 0;
            while (checkAhead('=', n + 1)) n++;
            if (checkAhead('[', n + 1)) {
                nBrackets = n;
                return true;
            }
        }
        return false;
    }

    private int checkBlockRedundant() {
        int redundant = -1;
        String cs = yytext().toString();
        StringBuilder s = new StringBuilder("]");
        for (int i = 0; i < nBrackets; i++) s.append('=');
        s.append(']');
        int index = cs.indexOf(s.toString());
        if (index > 0)
            redundant = yylength() - index - nBrackets - 2;
        return redundant;
    }


    /**
     * Creates a new scanner
     *
     * @param in the java.io.Reader to read input from.
     */
    public LuaLexer(java.io.Reader in) {
        this.zzReader = in;
    }


    /**
     * Unpacks the compressed character translation table.
     *
     * @param packed the packed character translation table
     * @return the unpacked character translation table
     */
    private static char[] zzUnpackCMap(String packed) {
        char[] map = new char[0x110000];
        int i = 0;  /* index in packed string  */
        int j = 0;  /* index in unpacked array */
        while (i < 2884) {
            int count = packed.charAt(i++);
            char value = packed.charAt(i++);
            do map[j++] = value; while (--count > 0);
        }
        return map;
    }


    /**
     * Refills the input buffer.
     *
     * @return <code>false</code>, iff there was new input.
     * @throws java.io.IOException if any I/O-Error occurs
     */
    private boolean zzRefill() throws java.io.IOException {

        /* first: make room (if you can) */
        if (zzStartRead > 0) {
            zzEndRead += zzFinalHighSurrogate;
            zzFinalHighSurrogate = 0;
            System.arraycopy(zzBuffer, zzStartRead,
                    zzBuffer, 0,
                    zzEndRead - zzStartRead);

            /* translate stored positions */
            zzEndRead -= zzStartRead;
            zzCurrentPos -= zzStartRead;
            zzMarkedPos -= zzStartRead;
            zzStartRead = 0;
        }

        /* is the buffer big enough? */
        if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
            /* if not: blow it up */
            char newBuffer[] = new char[zzBuffer.length * 2];
            System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
            zzBuffer = newBuffer;
            zzEndRead += zzFinalHighSurrogate;
            zzFinalHighSurrogate = 0;
        }

        /* fill the buffer with new input */
        int requested = zzBuffer.length - zzEndRead;
        int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

        /* not supposed to occur according to specification of java.io.Reader */
        if (numRead == 0) {
            throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
        }
        if (numRead > 0) {
            zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
            if (numRead == requested) {
                if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
                    --zzEndRead;
                    zzFinalHighSurrogate = 1;
                }
            }
            /* potentially more input available */
            return false;
        }

        /* numRead < 0 ==> end of stream */
        return true;
    }


    /**
     * Closes the input stream.
     */
    public final void yyclose() throws java.io.IOException {
        zzAtEOF = true;            /* indicate end of file */
        zzEndRead = zzStartRead;  /* invalidate buffer    */

        if (zzReader != null)
            zzReader.close();
    }


    /**
     * Resets the scanner to read from a new input stream.
     * Does not close the old reader.
     * <p>
     * All internal variables are reset, the old input stream
     * <b>cannot</b> be reused (internal buffer is discarded and lost).
     * Lexical state is set to <tt>ZZ_INITIAL</tt>.
     * <p>
     * Internal scan buffer is resized down to its initial length, if it has grown.
     *
     * @param reader the new input stream
     */
    public final void yyreset(java.io.Reader reader) {
        zzReader = reader;
        zzAtBOL = true;
        zzAtEOF = false;
        zzEOFDone = false;
        zzEndRead = zzStartRead = 0;
        zzCurrentPos = zzMarkedPos = 0;
        zzFinalHighSurrogate = 0;
        yyline = yychar = yycolumn = 0;
        zzLexicalState = YYINITIAL;
        if (zzBuffer.length > ZZ_BUFFERSIZE)
            zzBuffer = new char[ZZ_BUFFERSIZE];
    }


    /**
     * Returns the current lexical state.
     */
    public final int yystate() {
        return zzLexicalState;
    }


    /**
     * Enters a new lexical state
     *
     * @param newState the new lexical state
     */
    public final void yybegin(int newState) {
        zzLexicalState = newState;
    }


    /**
     * Returns the text matched by the current regular expression.
     */
    public final String yytext() {
        return new String(zzBuffer, zzStartRead, zzMarkedPos - zzStartRead);
    }


    /**
     * Returns the character at position <tt>pos</tt> from the
     * matched text.
     * <p>
     * It is equivalent to yytext().charAt(pos), but faster
     *
     * @param pos the position of the character to fetch.
     *            A value from 0 to yylength()-1.
     * @return the character at position pos
     */
    public final char yycharat(int pos) {
        return zzBuffer[zzStartRead + pos];
    }


    /**
     * Returns the length of the matched text region.
     */
    public final int yylength() {
        return zzMarkedPos - zzStartRead;
    }


    /**
     * Reports an error that occured while scanning.
     * <p>
     * In a wellformed scanner (no or only correct usage of
     * yypushback(int) and a match-all fallback rule) this method
     * will only be called with things that "Can't Possibly Happen".
     * If this method is called, something is seriously wrong
     * (e.g. a JFlex bug producing a faulty scanner etc.).
     * <p>
     * Usual syntax/scanner level error handling should be done
     * in error fallback rules.
     *
     * @param errorCode the code of the errormessage to display
     */
    private void zzScanError(int errorCode) {
        String message;
        try {
            message = ZZ_ERROR_MSG[errorCode];
        } catch (ArrayIndexOutOfBoundsException e) {
            message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
        }

        throw new Error(message);
    }


    /**
     * Pushes the specified amount of characters back into the input stream.
     * <p>
     * They will be read again by then next call of the scanning method
     *
     * @param number the number of characters to be read again.
     *               This number must not be greater than yylength()!
     */
    public void yypushback(int number) {

        if (number > yylength())
            zzScanError(ZZ_PUSHBACK_2BIG);

        zzMarkedPos -= number;
    }


    /**
     * Resumes scanning until the next regular expression is matched,
     * the end of input is encountered or an I/O-Error occurs.
     *
     * @return the next token
     * @throws java.io.IOException if any I/O-Error occurs
     */
    public LuaTokenTypes advance() throws java.io.IOException {
        int zzInput;
        int zzAction;

        // cached fields:
        int zzCurrentPosL;
        int zzMarkedPosL;
        int zzEndReadL = zzEndRead;
        char[] zzBufferL = zzBuffer;
        char[] zzCMapL = ZZ_CMAP;

        int[] zzTransL = ZZ_TRANS;
        int[] zzRowMapL = ZZ_ROWMAP;
        int[] zzAttrL = ZZ_ATTRIBUTE;

        while (true) {
            zzMarkedPosL = zzMarkedPos;

            yychar += zzMarkedPosL - zzStartRead;

            boolean zzR = false;
            int zzCh;
            int zzCharCount;
            for (zzCurrentPosL = zzStartRead;
                 zzCurrentPosL < zzMarkedPosL;
                 zzCurrentPosL += zzCharCount) {
                zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
                zzCharCount = Character.charCount(zzCh);
                switch (zzCh) {
                    case '\u000B':
                    case '\u000C':
                    case '\u0085':
                    case '\u2028':
                    case '\u2029':
                        yyline++;
                        yycolumn = 0;
                        zzR = false;
                        break;
                    case '\r':
                        yyline++;
                        yycolumn = 0;
                        zzR = true;
                        break;
                    case '\n':
                        if (zzR)
                            zzR = false;
                        else {
                            yyline++;
                            yycolumn = 0;
                        }
                        break;
                    default:
                        zzR = false;
                        yycolumn += zzCharCount;
                }
            }

            if (zzR) {
                // peek one character ahead if it is \n (if we have counted one line too much)
                boolean zzPeek;
                if (zzMarkedPosL < zzEndReadL)
                    zzPeek = zzBufferL[zzMarkedPosL] == '\n';
                else if (zzAtEOF)
                    zzPeek = false;
                else {
                    boolean eof = zzRefill();
                    zzEndReadL = zzEndRead;
                    zzMarkedPosL = zzMarkedPos;
                    zzBufferL = zzBuffer;
                    if (eof)
                        zzPeek = false;
                    else
                        zzPeek = zzBufferL[zzMarkedPosL] == '\n';
                }
                if (zzPeek) yyline--;
            }
            zzAction = -1;

            zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

            zzState = ZZ_LEXSTATE[zzLexicalState];

            // set up zzAction for empty match case:
            int zzAttributes = zzAttrL[zzState];
            if ((zzAttributes & 1) == 1) {
                zzAction = zzState;
            }


            zzForAction:
            {
                while (true) {

                    if (zzCurrentPosL < zzEndReadL) {
                        zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
                        zzCurrentPosL += Character.charCount(zzInput);
                    } else if (zzAtEOF) {
                        zzInput = YYEOF;
                        break zzForAction;
                    } else {
                        // store back cached positions
                        zzCurrentPos = zzCurrentPosL;
                        zzMarkedPos = zzMarkedPosL;
                        boolean eof = zzRefill();
                        // get translated positions and possibly new buffer
                        zzCurrentPosL = zzCurrentPos;
                        zzMarkedPosL = zzMarkedPos;
                        zzBufferL = zzBuffer;
                        zzEndReadL = zzEndRead;
                        if (eof) {
                            zzInput = YYEOF;
                            break zzForAction;
                        } else {
                            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
                            zzCurrentPosL += Character.charCount(zzInput);
                        }
                    }
                    int zzNext = zzTransL[zzRowMapL[zzState] + zzCMapL[zzInput]];
                    if (zzNext == -1) break zzForAction;
                    zzState = zzNext;

                    zzAttributes = zzAttrL[zzState];
                    if ((zzAttributes & 1) == 1) {
                        zzAction = zzState;
                        zzMarkedPosL = zzCurrentPosL;
                        if ((zzAttributes & 8) == 8) break zzForAction;
                    }

                }
            }

            // store back cached position
            zzMarkedPos = zzMarkedPosL;


            if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
                zzAtEOF = true;
                return null;
            } else {
                switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
                    case 1: {
                        yybegin(YYINITIAL);
                        return SHEBANG_CONTENT;
                    }
                    case 85:
                        break;
                    case 2: {
                        return BAD_CHARACTER;
                    }
                    case 86:
                        break;
                    case 3: {
                        return NEW_LINE;
                    }
                    case 87:
                        break;
                    case 4: {
                        return WHITE_SPACE;
                    }
                    case 88:
                        break;
                    case 5: {
                        return NAME;
                    }
                    case 89:
                        break;
                    case 6: {
                        return NUMBER;
                    }
                    case 90:
                        break;
                    case 7: {
                        return PLUS;
                    }
                    case 91:
                        break;
                    case 8: {
                        return DOT;
                    }
                    case 92:
                        break;
                    case 9: {
                        return MINUS;
                    }
                    case 93:
                        break;
                    case 10: {
                        return LBRACK;
                    }
                    case 94:
                        break;
                    case 11: {
                        return ASSIGN;
                    }
                    case 95:
                        break;
                    case 12: {
                        return RBRACK;
                    }
                    case 96:
                        break;
                    case 13: {
                        yybegin(xDOUBLE_QUOTED_STRING);
                        yypushback(yylength());
                    }
                    case 97:
                        break;
                    case 14: {
                        yybegin(xSINGLE_QUOTED_STRING);
                        yypushback(yylength());
                    }
                    case 98:
                        break;
                    case 15: {
                        return GETN;
                    }
                    case 99:
                        break;
                    case 16: {
                        return NOT;
                    }
                    case 100:
                        break;
                    case 17: {
                        return GT;
                    }
                    case 101:
                        break;
                    case 18: {
                        return LT;
                    }
                    case 102:
                        break;
                    case 19: {
                        return BIT_TILDE;
                    }
                    case 103:
                        break;
                    case 20: {
                        return MULT;
                    }
                    case 104:
                        break;
                    case 21: {
                        return MOD;
                    }
                    case 105:
                        break;
                    case 22: {
                        return DIV;
                    }
                    case 106:
                        break;
                    case 23: {
                        return LPAREN;
                    }
                    case 107:
                        break;
                    case 24: {
                        return RPAREN;
                    }
                    case 108:
                        break;
                    case 25: {
                        return LCURLY;
                    }
                    case 109:
                        break;
                    case 26: {
                        return RCURLY;
                    }
                    case 110:
                        break;
                    case 27: {
                        return COMMA;
                    }
                    case 111:
                        break;
                    case 28: {
                        return SEMI;
                    }
                    case 112:
                        break;
                    case 29: {
                        return COLON;
                    }
                    case 113:
                        break;
                    case 30: {
                        return EXP;
                    }
                    case 114:
                        break;
                    case 31: {
                        return BIT_AND;
                    }
                    case 115:
                        break;
                    case 32: {
                        return BIT_OR;
                    }
                    case 116:
                        break;
                    case 33: {
                        return AT;
                    }
                    case 117:
                        break;
                    case 34: {
                        yybegin(YYINITIAL);
                        return STRING;
                    }
                    case 118:
                        break;
                    case 35: {
                        yypushback(yylength());
                        yybegin(xCOMMENT);
                    }
                    case 119:
                        break;
                    case 36: {
                        return CONCAT;
                    }
                    case 120:
                        break;
                    case 37: {
                        boolean block = checkBlock();
                        if (block) {
                            yypushback(yylength());
                            yybegin(xBLOCK_COMMENT);
                        } else {
                            yypushback(yylength());
                            yybegin(xCOMMENT);
                        }
                    }
                    case 121:
                        break;
                    case 38: {
                        return IN;
                    }
                    case 122:
                        break;
                    case 39: {
                        return IF;
                    }
                    case 123:
                        break;
                    case 40: {
                        return OR;
                    }
                    case 124:
                        break;
                    case 41: {
                        return DO;
                    }
                    case 125:
                        break;
                    case 42: {
                        yybegin(xBLOCK_STRING);
                        yypushback(yylength());
                        checkBlock();
                    }
                    case 126:
                        break;
                    case 43: {
                        return EQ;
                    }
                    case 127:
                        break;
                    case 44: {
                        yybegin(xSHEBANG);
                        return SHEBANG;
                    }
                    case 128:
                        break;
                    case 45: {
                        return NE;
                    }
                    case 129:
                        break;
                    case 46: {
                        return GE;
                    }
                    case 130:
                        break;
                    case 47: {
                        return BIT_RTRT;
                    }
                    case 131:
                        break;
                    case 48: {
                        return LE;
                    }
                    case 132:
                        break;
                    case 49: {
                        return BIT_LTLT;
                    }
                    case 133:
                        break;
                    case 50: {
                        return DOUBLE_DIV;
                    }
                    case 134:
                        break;
                    case 51: {
                        return DOUBLE_COLON;
                    }
                    case 135:
                        break;
                    case 52: {
                        return AND;
                    }
                    case 136:
                        break;
                    case 53: {
                        yybegin(YYINITIAL);
                        return SHORT_COMMENT;
                    }
                    case 137:
                        break;
                    case 54: {
                        return ELLIPSIS;
                    }
                    case 138:
                        break;
                    case 55: {
                        return END;
                    }
                    case 139:
                        break;
                    case 56: {
                        return NIL;
                    }
                    case 140:
                        break;
                    case 57: {
                        return LEF;
                    }
                    case 141:
                        break;
                    case 58: {
                        return MEAN;
                    }
                    case 142:
                        break;
                    case 59: {
                        return FOR;
                    }
                    case 143:
                        break;
                    case 60: {
                        yybegin(YYINITIAL);
                        return DOC_COMMENT;
                    }
                    case 144:
                        break;
                    case 61: {
                        return ELSE;
                    }
                    case 145:
                        break;
                    case 62: {
                        return GOTO;
                    }
                    case 146:
                        break;
                    case 63: {
                        return CASE;
                    }
                    case 147:
                        break;
                    case 64: {
                        return TRUE;
                    }
                    case 148:
                        break;
                    case 65: {
                        return THEN;
                    }
                    case 149:
                        break;
                    case 66: {
                        return WHEN;
                    }
                    case 150:
                        break;
                    case 67: {
                        int redundant = checkBlockRedundant();
                        if (redundant != -1) {
                            yypushback(redundant);
                            yybegin(YYINITIAL);
                            return LONG_STRING;
                        } else {
                            yybegin(YYINITIAL);
                            return BAD_CHARACTER;
                        }
                    }
                    case 151:
                        break;
                    case 68: {
                        int redundant = checkBlockRedundant();
                        if (redundant != -1) {
                            yypushback(redundant);
                            yybegin(YYINITIAL);
                            return BLOCK_COMMENT;
                        } else {
                            yybegin(YYINITIAL);
                            return BLOCK_COMMENT;
                        }
                    }
                    case 152:
                        break;
                    case 69: {
                        return DEFER;
                    }
                    case 153:
                        break;
                    case 70: {
                        return BREAK;
                    }
                    case 154:
                        break;
                    case 71: {
                        return LOCAL;
                    }
                    case 155:
                        break;
                    case 72: {
                        return FALSE;
                    }
                    case 156:
                        break;
                    case 73: {
                        return UNTIL;
                    }
                    case 157:
                        break;
                    case 74: {
                        return WHILE;
                    }
                    case 158:
                        break;
                    case 75: {
                        return RETURN;
                    }
                    case 159:
                        break;
                    case 76: {
                        return REPEAT;
                    }
                    case 160:
                        break;
                    case 77: {
                        return ELSEIF;
                    }
                    case 161:
                        break;
                    case 78: {
                        return LAMBDA;
                    }
                    case 162:
                        break;
                    case 79: {
                        return SWITCH;
                    }
                    case 163:
                        break;
                    case 80: {
                        return DEFAULT;
                    }
                    case 164:
                        break;
                    case 81: {
                        return REGION;
                    }
                    case 165:
                        break;
                    case 82: {
                        return FUNCTION;
                    }
                    case 166:
                        break;
                    case 83: {
                        return CONTINUE;
                    }
                    case 167:
                        break;
                    case 84: {
                        return ENDREGION;
                    }
                    case 168:
                        break;
                    default:
                        zzScanError(ZZ_NO_MATCH);
                }
            }
        }
    }


}