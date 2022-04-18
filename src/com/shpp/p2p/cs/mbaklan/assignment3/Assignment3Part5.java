package com.shpp.p2p.cs.mbaklan.assignment3;

import acm.util.RandomGenerator;
import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part5 extends TextProgram {
    private static final RandomGenerator RG = RandomGenerator.getInstance();
    /*Game parameters*/
    public static final int SUM_FOR_FINISH = 20;
    public static final int STARTING_SUM = 1;
    /*Counter of the games*/
    private static int gameCounter = 0;

    /**
     * The start game*/
    public void run() {
        playGame(STARTING_SUM);
    }

    /**
     * This is a game.
     * @param startingSum it is the amount from which the game begins
     * First player put "startingSum" on the table. Second player starts tossing a coin.
     * If eagle first player adds to the amount on the table exactly the same amount.
     * If tails that on the table, goes to the second player
     * If second player has less than "SUM_FOR_FINISH" the game will be repeat.
     * @return the amount of winnings.*/
    private int playGame(int startingSum) {
        if (startingSum >= SUM_FOR_FINISH) {
            println("It took " + gameCounter + " games to earn $20");
            return startingSum;
        }
        println("This game, you earned $" + startingSum);
        int sumOnTable = startingSum;

        while (isEagle()) {
            sumOnTable *= 2;
        }

        println("Your total is $" + sumOnTable);
        gameCounter++;
        return playGame(sumOnTable);
    }

    /**
     * This method return eagle or tails
     * @return true if eagle and false if tails*/
    private boolean isEagle() {
        int i = RG.nextInt(2);
        return i == 0;
    }
}
