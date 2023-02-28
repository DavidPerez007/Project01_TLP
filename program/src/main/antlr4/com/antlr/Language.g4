grammar Language;
prog: '(' expr ')';
expr: operador ' ' expr+ 
    | Num
    | '(' expr ')'
    ;
Num
    : INT
    | INT '.' INT
    ;
operador:'^'| '*' | '/' | '+' | '-' ;
INT:[0-9]+;
