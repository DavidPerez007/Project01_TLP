package com.antlr;

import java.io.IOException;
import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) throws Exception {
        opArt opart = new opArt();
        opart.analizar();
    }

    public static class opArt {
        public void analizar() {
            String input = "";
            System.out.println("Introduce una expresión fija:");
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            do {
                input = scanner.nextLine();
                if (input.equals("exit")) {
                    continue;
                }
                LanguageLexer lexer = new LanguageLexer(CharStreams.fromString(input + "\n"));
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                LanguageParser parser = new LanguageParser(tokens);
                ParseTree tree = parser.prog();
                System.out.println("El resultado es: " + tree.toStringTree(parser));

            } while (!input.equals("exit"));

        }
    }
}
