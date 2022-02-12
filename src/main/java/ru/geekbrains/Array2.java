package ru.geekbrains;

import java.util.Arrays;

public class Array2 implements ArrayMethods {

    static final int size = 10000000;
    static final int h = size / 2;

    public void create() {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.out.println("Break array into parts: " + (System.currentTimeMillis() - a));
        new Thread(new Runnable() {
            @Override
            public void run() {
                long b = System.currentTimeMillis();
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("First part process: " + (System.currentTimeMillis() - b));
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long b = System.currentTimeMillis();
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Second part process: " + (System.currentTimeMillis() - b));
            }
        }).start();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Create array 2: " + (System.currentTimeMillis() - a));
    }

}
