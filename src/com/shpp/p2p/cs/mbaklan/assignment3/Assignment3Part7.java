package com.shpp.p2p.cs.mbaklan.assignment3;


import acm.graphics.GOval;
import acm.util.Animator;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.util.ArrayList;

import static java.lang.Math.*;

public class Assignment3Part7 extends WindowProgram {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;

    public static final int ANIMATION_TIME = 5000;
    private RandomGenerator rg = new RandomGenerator();
    private ArrayList<String> allAnimations = new ArrayList<>();
    private ArrayList<MyAnimator> animationsForPlay = new ArrayList<>();

    private boolean animationCanPlay = true;

    {
        allAnimations.add("Circle");
        allAnimations.add("Lissajou");
        allAnimations.add("Butterfly");
        allAnimations.add("Epicycloid");
        allAnimations.add("Hypocycloid");
    }


    public void run() {

        //int randInt = rg.nextInt(allAnimations.size());
        for (int i = 0; i < 4; i++) {
//            animationsForPlay.add(new MyAnimator().init(allAnimations.get(randInt)));
            animationsForPlay.add(new MyAnimator().init(allAnimations.get(4)));
        }

        setAnimationPosition();
        //start animations
        for (MyAnimator ma: animationsForPlay) {
            ma.start();
        }

        pause(ANIMATION_TIME );

        for (MyAnimator ma: animationsForPlay) {
            animationCanPlay = false;
            ma.interrupt();
        }

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

    private void playAnimation(String name, double scale, MyAnimator animator){

        switch(name) {
            case "Circle":
                drawCircles(scale, animator);
                break;
            case "Lissajou":
                drawLissajou(scale, animator);
                break;
            case "Epicycloid":
                drawEpicycloid(scale, animator);
                break;
            case "Butterfly":
                drawButterfly(scale, animator);
                break;
            case "Hypocycloid":
                drawHypocycloid(scale, animator);
                break;
        }
    }

    private void drawHypocycloid(double scale, MyAnimator animator) {
        for (double i = 0d; i < 20 * PI; i += 0.05) {
            if (!animationCanPlay) break;
            double x = 4.4 * (cos(i) + cos(1.1 * i) / 1.1);
            double y = 4.4 * (sin(i) - sin(1.1 * i) / 1.1);
            GOval oval = new GOval(animator.getX() + x * scale, animator.getY() + y * scale, 1, 1);
            add(oval);
            pause(1);
        }
    }

    private void drawEpicycloid(double scale, MyAnimator animator) {
        for (double i = 0d; i < 20 * PI; i += 0.05) {
            if (!animationCanPlay) break;
            double x = 6.2 * (cos(i) - cos(3.1 * i) / 3.1);
            double y = 6.2 * (sin(i) - sin(3.1 * i) / 3.1);
            GOval oval = new GOval(animator.getX() + x * scale, animator.getY() + y * scale, 1, 1);
            add(oval);
            pause(1);
        }
    }

    private void drawButterfly(double scale, MyAnimator animator) {
        for (double i = 0d; i < 12 * PI; i += 0.01) {
            if (!animationCanPlay) break;
            double x = -sin(i) * (pow(E, cos(i)) - 2 * cos( 4 * i) + pow(sin((1 / 12) * i), 5));
            double y = -cos(i) *(pow(E, cos(i)) - 2 * cos( 4 * i) + pow(sin((1 / 12) * i), 5));
            GOval oval = new GOval(animator.getX() + x * scale, animator.getY() + y * scale, 1, 1);
            add(oval);
            pause(1000/180);
        }
    }

    private void drawLissajou(double scale, MyAnimator animator) {
        for (double i = 0d; i < 2 * PI; i += 0.0048) {
            if (!animationCanPlay) break;
            double x = sin( 5 * i + PI / 2);
            double y = sin(6 * i);
            GOval oval = new GOval(animator.getX() + x * scale, animator.getY() + y * scale, 1, 1);
            add(oval);
            pause(1);
        }
    }

    private void drawCircles(double scale, MyAnimator animator) {
        for (double i = 0d; i < 2 * PI; i += 0.01) {
            if (!animationCanPlay) break;
            double x = sin(i);
            double y = cos(i);
            GOval oval = new GOval(animator.getX() + x * scale, animator.getY() + y * scale, 1, 1);
            add(oval);
            pause(1000/384);
        }
    }

    private class MyAnimator extends Animator {
        private String name;
        private double size;
        private double x;
        private double y;

        public  MyAnimator init(String name) {
            this.name = name;
            switch (name) {
                case "Butterfly":
                    size = 3;
                    break;
                case "Epicycloid":
                case "Hypocycloid":
                    size = 7;
                    break;
                case "Circle":
                case "Lissajou":
                default:
                    size = 1;
            }
            return this;
        }

        public void setXY(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        @Override
        public void run() {
            double scale = WIDTH / 4 / size;
            playAnimation(name, scale, this);
        }
    }
}
