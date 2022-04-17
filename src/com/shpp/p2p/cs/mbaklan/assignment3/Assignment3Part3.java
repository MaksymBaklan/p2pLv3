package com.shpp.p2p.cs.mbaklan.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part3 extends TextProgram {
    /**
     * The start of the program*/
    public void run() {
        println(raiseToPower(12, 6));
    }

    /**
     * This takes two parameters and calculates the value of the first parameter
     * raised to the power of parameter 2
     * @param base This number must be increased to the power
     * @param exponent This is a power*/
    private double raiseToPower(double base, int exponent) {
        if (exponent > 0) {
            double result = 1;
            for (int i = 1; i <= exponent; i++) {
                result *= base;
            }
            return result;
        } else if (exponent < 0) {
            return 1 / raiseToPower(base, -exponent);
        } else return 1;
    }
}
