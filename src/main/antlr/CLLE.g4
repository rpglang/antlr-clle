grammar CLLE;

@header {
//package io.github.rpglang.parser;
}

/**
 * CL command syntax:
 * [//] [?] [label-name:][library-name/]command-name [parameter-set]
*/
cl_command: SLASHES? QUESTION_MARK? label? library? command; // parameters*;

label: SPLAT_SNAME COLON;
library: SPLAT_SNAME SLASH;
command:  SPLAT_SNAME;
//parameters: 'parms';
cl_variable_name: AMPERSAND SPLAT_SNAME;

//SPLAT_NAME: [$#@a-zA-Z] [._$#@a-zA-Z0-9]* ; // Basic Name
//SPLAT_NAME_QUOTED: DOUBLE_QUOTE? ~[*?'"]+ DOUBLE_QUOTE? ; // Basic Name Quoted form
SPLAT_SNAME: [$#@a-zA-Z] [_$#@a-zA-Z0-9]*; // Simple Name
//SPLAT_PNAME: // Path Name

COLON: ':';
COMMA: ',';
OPEN_PAREN : '(';
CLOSE_PAREN : ')';
SLASH: '/';
SLASHES: '//';
PERIOD: '.';
DOUBLE_QUOTE: '"';
QUESTION_MARK: '?';
//TILDE: '~';
AMPERSAND: '&';
// Case insensitive alphabet fragments
fragment A: [aA];
fragment B: [bB];
fragment C: [cC];
fragment D: [dD];
fragment E: [eE];
fragment F: [fF];
fragment G: [gG];
fragment H: [hH];
fragment I: [iI];
fragment J: [jJ];
fragment K: [kK];
fragment L: [lL];
fragment M: [mM];
fragment N: [nN];
fragment O: [oO];
fragment P: [pP];
fragment Q: [qQ];
fragment R: [rR];
fragment S: [sS];
fragment T: [tT];
fragment U: [uU];
fragment V: [vV];
fragment W: [wW];
fragment X: [xX];
fragment Y: [yY];
fragment Z: [zZ];

ID  :   ('_'|'a'..'z'|'A'..'Z')('_'|'a'..'z'|'A'..'Z'|'0'..'9')* ;
NEWLINE:'\r'? '\n' -> skip;
WS  :   (' '|'\t')+ -> skip;
