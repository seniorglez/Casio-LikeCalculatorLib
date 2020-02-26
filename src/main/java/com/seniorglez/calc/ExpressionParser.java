package com.seniorglez.calc;
// Grammar:
// expression = term | expression `+` term | expression `-` term
// term = factor | term `*` factor | term `/` factor
// factor = `+` factor | `-` factor | `(` expression `)`
//        | number | functionName factor | factor `^` factor
public class ExpressionParser {//needed to add support for Euler's number, Euler-Mascheroni constant, pi constant,etc...

    public ExpressionParser(String expression){
        this.str=expression;
    }

    /**
     * The position of a character.
     */
    private int pos;
    /**
     * The numeric value of a character.
     */
    private int ch;

    /**
     * The math expression we want to parse
     */
    private String str;

    /**
     * A Method that upgrades de value of the variable pos and...
     */
    private void nextChar() {
        ch = (++pos < str.length()) ? str.charAt(pos) : -1;
    }

    /**
     * A method that updates pos until he reach a position that is not blank and compares it with the given char value.
     * If returns true it will also updates pos one more time.
     * @param charToEat the number code of the char we are looking for
     * @return true if the character value equals to the given one or false if it not.
     */
    private boolean eat(int charToEat) {
        while (ch == ' ') nextChar();
        if (ch == charToEat) {
            nextChar();
            return true;
        }
        return false;
    }

    /**
     *  A method that calculates the result of the math expression.
     * @return the result of the math expression if is valid.
     */
    public double parse() {
        pos = -1;
        nextChar();
        double x = parseExpression();
        if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
        return x;
    }


    private double parseExpression() {
        double x = parseTerm();
        for (;;) {
            if      (eat('+')) x += parseTerm(); // addition
            else if (eat('-')) x -= parseTerm(); // subtraction
            else return x;
        }
    }


    private double parseTerm() {
        double x = parseFactor();
        for (;;) {
            if      (eat('*')) x *= parseFactor(); // multiplication
            else if (eat('/')) x /= parseFactor(); // division
            else return x;
        }
    }

    private double parseFactor() {
        if (eat('+')) return parseFactor(); // unary plus
        if (eat('-')) return -parseFactor(); // unary minus

        double x;
        int startPos = this.pos;
        if (eat('(')) { // parentheses
            x = parseExpression();
            eat(')');
        } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
            while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
            x = Double.parseDouble(str.substring(startPos, this.pos));
        } else if (ch >= 'a' && ch <= 'z') { // functions
            while (ch >= 'a' && ch <= 'z') nextChar();
            String func = str.substring(startPos, this.pos);
            x = parseFactor();
            if (func.equals("sqrt")) x = Math.sqrt(x);// square root
            else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));//sine
            else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));//cosine
            else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));//tangent
            else if (func.equals("asin")) x = Math.asin(Math.toRadians(x));//arcsin
            else if (func.equals("acos")) x = Math.acos(Math.toRadians(x));//arcsine
            else if (func.equals("atan")) x = Math.atan(Math.toRadians(x));//arctangent
            else if (func.equals("sinh")) x = Math.sinh(Math.toRadians(x));//hyperbolic sin
            else if (func.equals("cosh")) x = Math.tanh(Math.toRadians(x));//hyperbolic cosine
            else if (func.equals("tanh")) x = Math.tanh(Math.toRadians(x));//hyperbolic tangent

            else throw new RuntimeException("Unknown function: " + func);
        } else {
            throw new RuntimeException("Unexpected: " + (char)ch);
        }

        if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation
        
        return x;
    }
}
