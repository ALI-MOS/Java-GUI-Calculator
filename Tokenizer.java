package com.mycompany.guicalculator;

import static com.mycompany.guicalculator.Utility.isOperator;
import static com.mycompany.guicalculator.Utility.isSeperator;
import static java.lang.Character.isDigit;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    /**
     * split the equation into numbers and operators
     * @param equ
     * @return tokens array list
     */
    public static List<String> tokenize(String equ) {
        String currentNumber = "";
        List<String> tokens = new ArrayList<>();
        /**
         * this loop check for:
         * ->if the variable current number is not empty 
         *      add it's value to the tokens array
         * ->if variable current number is operator 
         *      add it's value to the tokens array
         *      then make the variable equal to ""
         * ->if variable current number is Digit
         *      add it's value to the tokens array
         */
        for (int i = 0; i < equ.length(); i++){
            char c = equ.charAt(i);
 
            if (isSeperator(c)) {
                if (!currentNumber.isEmpty()){
                    tokens.add(currentNumber);
                    currentNumber = "";
                }
                if (isOperator(c))
                    tokens.add(Character.toString(c));
            }
            else if (isDigit(c)){          
                currentNumber += c;          
            }
        }
        /**
         * if variable current number is not Empty
         *      add it's value to the tokens array
         */ 
        if (!currentNumber.isEmpty()) {
            tokens.add(currentNumber);
        }
 
        return tokens;
    }
}
