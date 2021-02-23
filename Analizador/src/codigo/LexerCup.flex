package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);

    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);

    }
%}
%%
ent {return new Symbol(sym.ent, yychar, yyline, yytext());}
car {return new Symbol(sym.car, yychar, yyline, yytext());}
flot {return new Symbol(sym.flot, yychar, yyline, yytext());}
consta {return new Symbol(sym.consta, yychar, yyline, yytext());}
AND {return new Symbol(sym.AND, yychar, yyline, yytext());}
OR {return new Symbol(sym.OR, yychar, yyline, yytext());}
NOT {return new Symbol(sym.NOT, yychar, yyline, yytext());}
CONCA {return new Symbol(sym.CONCA, yychar, yyline, yytext());}
Para {return new Symbol(sym.Para, yychar, yyline, yytext());}
Si {return new Symbol(sym.Si, yychar, yyline, yytext());}
Funcion {return new Symbol(sym.Funcion, yychar, yyline, yytext());}
Imprimir {return new Symbol(sym.Imprimir, yychar, yyline, yytext());}
Escribir {return new Symbol(sym.Escribir, yychar, yyline, yytext());}
Camb {return new Symbol(sym.Cambiar, yychar, yyline, yytext());}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {return new Symbol(sym.Igual, yychar, yyline, yytext());}
"+" {return new Symbol(sym.Mas, yychar, yyline, yytext());}
"-" {return new Symbol(sym.Menos, yychar, yyline, yytext());}
">" {return new Symbol(sym.MayorQ, yychar, yyline, yytext());}
"<" {return new Symbol(sym.MenorQ, yychar, yyline, yytext());}
"(" {return new Symbol(sym.Parentesis_ap, yychar, yyline, yytext());}
")" {return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}
"{" {return new Symbol(sym.Llave_ap, yychar, yyline, yytext());}
"}" {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}
"main" {return new Symbol(sym.Main, yychar, yyline, yytext());}
";" {return new Symbol(sym.Punto_c, yychar, yyline, yytext());}
"." {return new Symbol(sym.Punto, yychar, yyline, yytext());}
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}
("(-"{D}+"."{D}+")")|({D}+"."{D}+) {return new Symbol(sym.NumeroD, yychar, yyline, yytext());}
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
