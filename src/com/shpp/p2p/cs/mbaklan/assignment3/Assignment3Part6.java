package com.shpp.p2p.cs.mbaklan.assignment3;

import acm.graphics.GCompound;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;


import java.awt.*;
import java.util.Arrays;


public class Assignment3Part6 extends WindowProgram {
    public static final Color RECT_COLOR = Color.RED;
    public static final double RECT_WIDTH = 10;
    public static final double DISTANCE_BETWEEN_RECT = 5;

    private GRect[] mainArr;
    private RandomGenerator rg = RandomGenerator.getInstance();


    {
        //initMainArr();
    }

    public void run() {
        GRect first = new GRect(10, 200 - 100, 20, 100);
        GRect second = new GRect(40, 200 - 140, 20, 140);
        GRect second2 = new GRect(70, 200 - 160, 20, 160);
        GRect second3 = new GRect(100, 200 - 50, 20, 50);
        add(first);
        add(second);
        add(second2);
        add(second3);
        System.out.println("build and pause");
        pause(5000);
        System.out.println("pause ends");
        qSort(new GRect[]{first, second3, second2, second});
        System.out.println("finish");
    }

    private GRect[] qSort(GRect[] arr){
        if (arr.length < 2) return arr;

        if (arr.length == 2 && arr[0].getHeight() >= arr[1].getHeight()) return arr;
        if (arr.length == 2 && arr[0].getHeight() < arr[1].getHeight()){
            //return chaingColumnHeight(arr);
            GRect[] test = chaingColumnHeight(arr);
            //paintUnder(test);
            return test;


            /*int tmp = (int)arr[0].getHeight();
            arr[0] = arr[1];
            arr[1] = tmp;
            chaingColumnPosition(arr[0], arr[1]);
            return arr;*/
        }

        int pivot = arr.length / 2;

        int lessArrLength = 0;
        int greaterArrLength = 0;
        for (int i = 0, n = arr.length; i < n; i++){
            if (pivot == i) continue;
            if (arr[pivot].getHeight() < arr[i].getHeight()) {
                greaterArrLength++;
            }
            if (arr[pivot].getHeight() >= arr[i].getHeight()){
                lessArrLength++;
            }
        }

        GRect[] less = new GRect[lessArrLength];
        GRect[] greater = new GRect[greaterArrLength];

        int lessCount = 0;
        int greaterCount = 0;
        for (int i = 0, n = arr.length; i < n; i++){
            if (pivot == i) {
                continue;
            }
            if (arr[i].getHeight() <= arr[pivot].getHeight()) {
                less[lessCount] = arr[i];
                lessCount++;
            }
            else {
                greater[greaterCount] = arr[i];
                greaterCount ++;
            }
        }

        GRect[] resultArr = new GRect[arr.length];

        if (greater.length > 1) greater = qSort(greater);

        for (int i = 0, n = greater.length; i < n; i++ ){
            resultArr[i] = greater[i];
        }
        resultArr[greater.length] = arr[pivot];
        if (less.length > 1 ) less =qSort(less);
        for (int i = 0, n = less.length; i < n; i++){
            resultArr[i + greater.length + 1] = less[i];
        }

        return resultArr;
    }

    /**
     * Set the border color and fill it with some color. Ccolor we set in constants.
     * @param c the rectangle that we will paint
     */
    private void paintRect(GRect c) {
        c.setFilled(true);
        c.setColor(RECT_COLOR);
    }

    private void initMainArr() {
        int size = rg.nextInt(1, 100);
        mainArr = new GRect[size];

        for (int i = 0; i < size; i++) {
            int height = rg.nextInt(200);
            mainArr[i] = new GRect(i * (RECT_WIDTH + DISTANCE_BETWEEN_RECT), 200 - height, RECT_WIDTH, height);
            paintRect(mainArr[i]);
            add(mainArr[i]);
        }
    }

    private GRect[] chaingColumnHeight(GRect[] arr) {
        System.out.println("cnhange");

        GRect firstColumn = arr[0];
        GRect secondColumn = arr[1];
        int firstColumnY = (int)firstColumn.getY();
        int firstColumnHeight = (int)firstColumn.getHeight();

        firstColumn = new GRect(firstColumn.getX(), secondColumn.getY(), firstColumn.getWidth(), secondColumn.getHeight());
        secondColumn = new GRect(secondColumn.getX(), firstColumnY, secondColumn.getWidth(), firstColumnHeight);
        return new GRect[]{secondColumn, firstColumn};
    }
}


