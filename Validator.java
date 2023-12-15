package com.mycompany.guicalculator;

import static com.mycompany.guicalculator.Utility.isNumber;
import static com.mycompany.guicalculator.Utility.isOperator;
import static java.lang.Character.isDigit;
import static java.lang.Character.isSpace;
import static com.mycompany.guicalculator.Utility.isDot;
import static com.mycompany.guicalculator.Utility.isDoubleNumber;
       
import java.util.List;

/**
 * Check if the input characters is valid numbers and operators only
 * @author Ali Mosa
 */
public class Validator {
    /**
     * checking if the string input is valid by 
     *      checking (isDigit, isOperator and isSpace)
     * @param equ: input string
     * @return 
     */
    public static boolean checkValidChars(String equ) {
        for (int i = 0; i < equ.length(); i++) {
            char c = equ.charAt(i);
            if (
                !isDigit(c)
                && !isOperator(c)
                && !isSpace(c)

               )
                return false;                
        }
        return true;
    }
    /**
     * it is validate if check parentheses and check structure are true
     * @param tokens
     * @return 
     */
    public static boolean validate(List<String> tokens) {
        return checkParentheses(tokens) && checkStructure(tokens);
    }
    /**
     * check the existing of parentheses in tokens array 
     * @param tokens array of strings
     * @return 
     */
    public static boolean checkParentheses(List<String> tokens) {
        int counter = 0;
        for (int i = 0; i < tokens.size(); i++) {
            String s = tokens.get(i);
            if (s.equals("(")) {
                counter += 1;
            }  
            else if (s.equals(")")) {
                counter -= 1;
                if (counter < 0)
                    return false;
            }              
        }
        return (counter == 0);
    }
    /**
     * check the structure of the tokens(is not empty)and 
     * (the start of tokens is ( "-" || "(" || "-" ) 
     * and there are no 2 operators or 2 numbers after each other
     * @param tokens
     * @return 
     */
    public static boolean checkStructure(List<String> tokens) {
        if (tokens.isEmpty())
            return false;
        
        String first = tokens.get(0);
        if (!isNumber(first) && !first.equals("(") 
                && !first.equals("-"))
            return false;
            
        for (int i = 1; i < tokens.size(); i++) {
            String t1 = tokens.get(i-1);
            String t2 = tokens.get(i);
            if (isNumber(t1) && isNumber(t2))
                return false;
            if (isOperator(t1) && isOperator(t2) 
                    && !t2.equals("(") && !t2.equals("-"))
                return false;
        }
        
        String last = tokens.get(tokens.size() - 1);
        if (!isNumber(last) && !last.equals(")"))
            return false;

        return true;
    }
}
