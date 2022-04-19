package com.shpp.p2p.cs.mbaklan.assignment3;


import acm.graphics.GOval;
import acm.util.Animator;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.util.ArrayList;

import static java.lang.Math.*;

public class Assignment3Part6 extends WindowProgram {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;

    public static final double SCALE_FACTOR = 5; // NEED TO think
    public static final int ANIMATION_TIME = 3;
    private RandomGenerator rg = new RandomGenerator();
    private ArrayList<String> allAnimations = new ArrayList<>();
    private ArrayList<MyAnimator> animationsForPlay = new ArrayList<>();

    {
        allAnimations.add("Circle");
    }


    public void run() {

        int randInt = rg.nextInt(allAnimations.size());
        for (int i = 0; i < 4; i++) {
            animationsForPlay.add(new MyAnimator().init(allAnimations.get(randInt)));
        }

        setAnimationPosition();
        //start animations
        for (MyAnimator ma: animationsForPlay) {
            ma.start();
        }

        /*pause(ANIMATION_TIME * 1000);

        for (MyAnimator ma: animationsForPlay) {
            ma.interrupt();
        }*/

        System.out.println("the end");
    }

    private void setAnimationPosition() {
        System.out.println(String.format("Width: %s Height: %s", getWidth(), getHeight()));
        double dx = getWidth() / 4;
        double dy = getHeight() / 4;

        for (double i = dy, count = 0; i < getHeight(); i += 2 * dy) {
            for (double j = dx;  j < getWidth(); j += 2 * dx, count += 1) {
                animationsForPlay.get((int)count).setXY(j, i);
            }
        }
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

    private void playAnimation(double dx, double dy, double scale){
        for (double i = 0d; i < 2 * PI; i += 0.01) {
            double x = sin(i);
            double y = cos(i);
          /*double x = sin( 5 * i + PI / 2);
          double y = sin(6 * i);*/
            /*double x = -sin(i) * (pow(E, cos(i)) - 2 * cos( 4 * i) + pow(sin((1 / 12) * i), 5));
            double y = -cos(i) *(pow(E, cos(i)) - 2 * cos( 4 * i) + pow(sin((1 / 12) * i), 5));*/
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
        private String name;
        private double size;
        private double x;
        private double y;

        public  MyAnimator init(String name) {
            this.name = name;
            switch (name) {
                case "Circle":
                    size = 1;
                    break;
                default:
                    size = 1;
            }
            return this;
        }

        public void setXY(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void run() {
            double scale = WIDTH / 4 / size;
            while (!isInterrupted()) {
                playAnimation(x, y, scale);
            }
        }
    }
}
