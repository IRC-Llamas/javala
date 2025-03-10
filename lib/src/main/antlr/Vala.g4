grammar Vala;

classDeclaration : 'class' Identifier '{' (propertyDeclaration)* '}';

propertyDeclaration : type Identifier ';';

type : 'int' | 'string' | 'bool';

Identifier : [a-zA-Z_][a-zA-Z_0-9]*;

WS : [ \t\r\n]+ -> skip;
