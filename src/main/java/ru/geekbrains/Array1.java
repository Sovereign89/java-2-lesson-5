package ru.geekbrains;

import java.util.Arrays;

public class Array1 implements ArrayMethods {

    static final int size = 10000000;

    public void create() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Create array 1: " + (System.currentTimeMillis() - a));
    }

}
