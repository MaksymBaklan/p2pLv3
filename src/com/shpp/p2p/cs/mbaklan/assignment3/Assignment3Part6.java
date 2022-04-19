package com.shpp.p2p.cs.mbaklan.assignment3;


import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.util.Animator;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.*;

public class Assignment3Part6 extends WindowProgram {

    public static final
    public static final int ANIMATION_TIME = 5;
    private RandomGenerator rg = new RandomGenerator();
    private ArrayList<MyAnimator> animationList = new ArrayList<>();



    public void run() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; )
        }


        /*pause(ANIMATION_TIME * 5);
        animation.interrupt();*/

        System.out.println("the end");
    }

    /*private void playAnimation() {
        GOval oval = new GOval(50, 50, 50, 50);
        oval.setColor(Color.RED);
        for (double i = 50; i >0 ; i-=1) {
            GOval oval1 = new GOval(50 + i, 50 + i, i, i);
            oval.setColor(Color.RED);
            add(oval1);
            pause(1000/12);
        }

        for (double i = 100; i > 50 ; i-=1) {
            GOval oval2 = new GOval(50 + i, 50 + i, i, i);
            oval2.setColor(Color.RED);
            add(oval2);
            pause(1000/12);
        }
        for (double i = 150; i > 100 ; i-=1) {
            GOval oval2 = new GOval(50 + i, 50 + i, i, i);
            oval.setColor(Color.RED);
            add(oval2);
            pause(1000/12);
        }
        for (double i = 200; i > 150 ; i-=1) {
            GOval oval2 = new GOval(50 + i, 50 + i, i, i);
            oval2.setColor(Color.RED);
            add(oval2);
            pause(1000/24);
        }
    }*/

    private void playAnimation(double dx, double dy, int scale){
        for (double i = 0d; i < 12 * PI; i += 0.001) {
/*          double x = sin( 5 * i + PI / 2);
            double y = sin(6 * i);*/
            double x = -sin(i) * (pow(E, cos(i)) - 2 * cos( 4 * i) + pow(sin((1 / 12) * i), 5));
            double y = -cos(i) *(pow(E, cos(i)) - 2 * cos( 4 * i) + pow(sin((1 / 12) * i), 5));
            GOval oval = new GOval(dx + x * scale, dy + y * scale, 1, 1);
            add(oval);
            pause(1000/384);
        }

    }
    /*private class AnimationThread extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                playAnimation(100, 100, 60);
            }
        }
    }*/

    private class MyAnimator extends Animator {
        private double x;
        private double y;

        public void init(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void run() {
            playAnimation(x, y, 60);
        }
    }
}
