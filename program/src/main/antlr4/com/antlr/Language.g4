grammar Language;
prog
    : '(' expr ')'
    ;
expr
    : operador expr ' ' expr
    | Num
    | '(' expr ')'
    ;
Num
    : INT
    | INT '.' INT
    ;
operador:'^'| '*' | '/' | '+' | '-' ;
NEWLINE : [\r\n]+ -> skip;
INT:[0-9]+;