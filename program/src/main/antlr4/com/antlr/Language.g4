grammar Language;
prog
    : '(' expr ')'
    ;
expr
    : suma_resta expr ' ' expr
    | term
    ;
term
    : mult_div expr ' ' expr
    | factor
    ;
factor
    : pot expr ' ' expr
    | Num
    | '(' expr ')'
    ;
Num
    : INT
    | INT '.' INT
    ;
suma_resta: '+' | '-' ;
mult_div: '*' | '/';
pot: '^';
NEWLINE : [\r\n]+ -> skip;
INT:[0-9]+;