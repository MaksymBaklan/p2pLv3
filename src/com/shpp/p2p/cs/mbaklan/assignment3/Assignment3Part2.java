package com.shpp.p2p.cs.mbaklan.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part2 extends TextProgram {
    public void run() {
        print("Enter a number: ");
        int n = readInt();
        showNumbersHailstones(n);
        println("The end.");
    }

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
