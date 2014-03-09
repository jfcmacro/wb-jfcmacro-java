class SimpleParser extends Parser;

entry : (d:DOB n:NAME a:AGE(SEMI)
      { 
        System.out.println(
          "Name: "    + 
          n.getText() +
          ", Age: "   +
          a.getText() + 
          ", DOB: "   +
          d.getText()
        );
      })*
      ;

class SimpleLexer extends Lexer;

NAME : ('a'..'z'|'A'..'Z')+;

DOB  : ('0'..'9' '0'..'9' '/')=> 
       (('0'..'9')('0'..'9')'/')(('0'..'9')('0'..'9')'/')('0'..'9')('0'..'9') //{ $setType(DOB); }
     | ('0'..'9')+  { $setType(AGE); } ;

WS     :
    (' ' 
    | '\t' 
    | '\r' '\n' { newline(); } 
    | '\n'      { newline(); }
    ) 
    { $setType(Token.SKIP); } 
  ;

SEMI : ';' ;
