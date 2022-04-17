package com.shpp.p2p.cs.mbaklan.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * Take some positive integer and name it n
 * If n is even, then divide it by 2
 * If n is odd, multiply by 3 and add 1
 * Continue this process until n is 1
 * */
public class Assignment3Part2 extends TextProgram {
    public void run() {
        print("Enter a number: ");
        int n = readInt();
        showNumbersHailstones(n);
        println("The end.");
    }

    /**
     * The method show in console all process
     * @param n n is a positive integer you entered*/
    private int showNumbersHailstones(int n) {
        if (n == 1) return 1;

        if (n % 2 == 0) {
            println(n + " is even so I take half: " + (n /= 2));
            return showNumbersHailstones(n);
        } else {
            println(n + " is odd so I make 3n + 1: " + (n = n * 3 + 1));
            return showNumbersHailstones(n);
        }
    }
}
