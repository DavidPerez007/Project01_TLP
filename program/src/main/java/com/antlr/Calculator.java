package com.antlr;

import java.util.Stack;

public class Calculator {
  public void evaluateExpression(String expression) {
    try {
      Stack<String> expPrefija = new Stack<String>();

      String expr = depurar(expression);
      String[] arrayInfix = expr.split(" ");

      //Pasa la expresion a la pila
      for (int i = 0; i < arrayInfix.length; i++) {
        if(" ".contains(arrayInfix[i]));
        else expPrefija.push(arrayInfix[i]);
      }

      System.out.println("Resultado: " + sacarResultado(expPrefija));

    }catch(Exception ex){ 
      System.out.println("Error en la expresion algebraica.");
      System.err.println(ex);
    }
  }

  //Depura la expresion algebraica
  private static String depurar(String linea) {
    String simbols = "+-*/^()";
    String str = "";
 
    for (int i = 0; i < linea.length(); i++) {
      if (simbols.contains("" + linea.charAt(i)))
        str += " " + linea.charAt(i) + " ";
      else str += linea.charAt(i);
    }
    return str.replaceAll("\\s+", " ").trim();
  }

  //Calcula el resultado de la expresion
  private static String sacarResultado(Stack<String> prefija){
    Stack<String> resolver = new Stack<String>();
    String operadores = "+-*/^";

    while (!prefija.isEmpty()) {
      if("()".contains(prefija.peek())) prefija.pop();
      else if (operadores.contains("" + prefija.peek()))
        resolver.push(evaluar(prefija.pop(), resolver.pop(), resolver.pop()) + "");
      else resolver.push(prefija.pop());
    }

    return resolver.peek();
  }

  //Hace la operacion
  private static double evaluar(String op, String n1, String n2) {
    double num1 = Double.parseDouble(n1);
    double num2 = Double.parseDouble(n2);

    if (op.equals("^")) return ((int)Math.pow(num1, num2));
    if (op.equals("+")) return (num1 + num2);
    if (op.equals("-")) return (num1 - num2);
    if (op.equals("*")) return (num1 * num2);
    if (op.equals("/")) return (num1 / num2);
    else return 0;
  }
}

