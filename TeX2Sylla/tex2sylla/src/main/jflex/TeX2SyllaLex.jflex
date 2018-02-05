package co.edu.eafit.dis.tex2sylla;

import java.util.Stack;

%%

%class TeX2SyllaLex
%unicode
%line
%column
%integer
%eofval{
  return 0;
%eofval}      

%{
   private Stack<Object> stackFile = new Stack();
   private StringBuffer data = new StringBuffer();
   private int innerCommand = 0;
   private String sectionName;
%}
DocumentClass = "\\documentclass"

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\n]

EndOfLineComment = "%" {InputCharacter}* {LineTerminator}?

Identifier = [:jletter:] [:jletterdigit:]*

DecIntegerLiteral = 0 | [1-9][0-9]*

CommandSignal = "\\"
StartOptions = "["
EndOptions = "]"

Options = {Identifier}(","{Identifier})*

StartCommand = "{"
EndCommand   = "}"

DocumentClass  = {CommandSignal}"documentclass"
UsePackage     = {CommandSignal}"usepackage"
NewCommand     = {CommandSignal}"newcommand"
NewCommandName = {CommandSignal}{Identifier}
Begin          = {CommandSignal}"begin"
End            = {CommandSignal}"end"

%state   START_PACKAGE, PACKAGE_OPTIONS, PACKAGE_NAME, START_NEW_COMMAND, BEGIN_NEW_COMMAND_NAME, BEGIN_NEW_COMMAND_PAR, BEGIN_NEW_COMMAND_BODY, START_BEGIN_SEC, SEC_NAME, BODY_BEGIN_SEC
%%

<YYINITIAL> {
   {DocumentClass}    { /* Ignore */ }

   {Begin}            { yybegin(START_BEGIN_SEC); }

   {UsePackage}       {
                         yybegin(START_PACKAGE);     
                      }

   {NewCommand}       {
                         yybegin(START_NEW_COMMAND);
                      } 
                
   {LineTerminator}   { /* Ignore */ }

   {EndOfLineComment} { /* Ignore */ }

   .                  { /* Ignore */ }
}

<START_PACKAGE> {
  {StartOptions} { yybegin(PACKAGE_OPTIONS); }
  {StartCommand} { yybegin(PACKAGE_NAME); }
}

<PACKAGE_OPTIONS> {
  {Identifier}    { System.out.println("Option: " + yytext()); }
  ","             { /* Ignore */ }
  {EndOptions}    { yybegin(START_PACKAGE); }
}

<PACKAGE_NAME>    {
  {Identifier}    { System.out.println("Package name: " + yytext()); }
  ","             { /* Ignore */ }
  {EndCommand}    { yybegin(YYINITIAL);   }
}

<START_NEW_COMMAND> {
  {StartCommand}  {
                    if (innerCommand == 0) {
                       innerCommand++;
                       yybegin(BEGIN_NEW_COMMAND_NAME);
                    }
                    else {
                       innerCommand = 0;
                       stackFile.push(new Object());
                       yybegin(BEGIN_NEW_COMMAND_BODY);
                    }
                  }
  {StartOptions}  { yybegin(BEGIN_NEW_COMMAND_PAR); }
}

<BEGIN_NEW_COMMAND_NAME> {
  {NewCommandName} { System.out.println("New command name: " + yytext()); }
  {EndCommand}     { yybegin(START_NEW_COMMAND); }
}

<BEGIN_NEW_COMMAND_PAR> {
  {DecIntegerLiteral} { System.out.println("Number of parameters: " + yytext());}
  {EndOptions}        {
                         yybegin(BEGIN_NEW_COMMAND_BODY);
                      }
}                

<BEGIN_NEW_COMMAND_BODY> {
  {StartCommand}   {
                      data.append(yytext());
                      stackFile.push(new Object());
                   }
  {EndCommand}     {
                      data.append(yytext());
                      stackFile.pop();
                      if (stackFile.empty()) {
                         // System.out.println(data.toString());
                         data = new StringBuffer();
                         yybegin(YYINITIAL);
                      }
                   }
  .                {
                      data.append(yytext());
                   }
  {LineTerminator} {
                      data.append(yytext());
                   }
}

<START_BEGIN_SEC> {
  {StartCommand}  { yybegin(SEC_NAME); }
}

<SEC_NAME> {
  {Identifier}    {
                    sectionName = yytext();
                    System.out.println("SEC NAME: " +
                                       sectionName);
                  }
  {EndCommand}    { yybegin(BODY_BEGIN_SEC); }
}

<BODY_BEGIN_SEC> {
  {End}            {
                     System.out.println(data.toString());
                     data = new StringBuffer();
                     yybegin(YYINITIAL);
                   }
  .                { data.append(yytext()); }
  {LineTerminator} {
                     data.append(yytext());
                   }
}