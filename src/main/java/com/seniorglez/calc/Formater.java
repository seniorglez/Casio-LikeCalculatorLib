package com.seniorglez.calc;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Formater {

    /**Method that express a number on scientific notation.
     * @param number the number to format.
     * @return String with the number expressed on scientific notation.
     */
    public static String formatScientificNotation(double number){
        NumberFormat formatter = new DecimalFormat("0.######E0");
        return formatter.format(number);
    }
}
