package com.shpp.p2p.cs.mbaklan.assignment3;

import com.shpp.cs.a.console.TextProgram;


public class Assignment3Part1 extends TextProgram {

    public static final int TIME_OF_CARDIO_AEROBICS_PER_DAY = 30;
    public static final int TIME_FOR_EXERCISE_TO_MAINTAIN_LOW_BLOOD_PRESSURE = 40;
    public static final int NUMBER_OF_DAYS_FOR_CARDIO_EXERCISE = 5;
    public static final int NUMBER_OF_DAYS_FOR_MAINTAINING_LOW_BLOOD_PRESSURE = 3;

    public void run() {
        int cardioDayCount = 0,
            pressureDayCount = 0;

        for (int i = 1; i <= 7; i++) {
            print("How many minutes did you do on day " + i + "? ");
            int time = readInt();

            if (time >= TIME_OF_CARDIO_AEROBICS_PER_DAY) cardioDayCount++;
            if (time >= TIME_FOR_EXERCISE_TO_MAINTAIN_LOW_BLOOD_PRESSURE) pressureDayCount++;
        }

        showResult(cardioDayCount, pressureDayCount);
    }

    private void showResult(int cardioDayCount, int pressureDayCount) {
        println("Cardiovacular health:");
        if (cardioDayCount >= NUMBER_OF_DAYS_FOR_CARDIO_EXERCISE) {
            println("  Great job! You've done enough exercise for cardiovacular health.");
        }
        else {
            println("  You needed to train hard for at least " + (NUMBER_OF_DAYS_FOR_CARDIO_EXERCISE - cardioDayCount) + " more day(s) a week!");
        }

        println("Blood pressure:");
        if (pressureDayCount >= NUMBER_OF_DAYS_FOR_MAINTAINING_LOW_BLOOD_PRESSURE) {
            println("  Great job! You've done enough exercise to keep a low blood pressure.");
        } else {
            println("  You needed to train hard for at least " + (NUMBER_OF_DAYS_FOR_MAINTAINING_LOW_BLOOD_PRESSURE - pressureDayCount) + " more day(s) a week!");
        }
    }
}