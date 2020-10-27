package com.store;

import java.util.Arrays;
import java.util.Comparator;

public class MainClass {
    public static void main(String[] abc) {
        boolean[] x1 = new boolean[10];
        byte[] x2 = new byte[10];
        char[] x3 = new char[10];
        short[] x4 = new short[10];
        int[] x5 = new int[10];
        long[] x6 = new long[10];
        float[] x7 = new float[10];
        double[] x8 = new double[10];
        String[] x9 = new String[10];

        // запълване на стойности с Arrays.fill
        Arrays.fill(x1, true);
        Arrays.fill(x2, (byte)0);
        Arrays.fill(x3, 'a');
        Arrays.fill(x4, (short)1);
        Arrays.fill(x5, 10);
        Arrays.fill(x6, 1l);
        Arrays.fill(x7, 3.14f);
        Arrays.fill(x8, 3.14);
        Arrays.fill(x9, "hello world");

        // инициализация с различни стойности
        x1 = new boolean[] {true, false, true, false, true, false, true, false, true, false};
        x2 = new byte[] { (byte)0, (byte)0, (byte)1 };
        x3 = new char[] { 'a', 'b', 'c'};
        x4 = new short[] { (short)1, (short)2 };
        x5 = new int[] { 1, 2, 3 };
        x6 = new long[] { 1l, 2l, 3l };
        x7 = new float[] { 1f, 2f, 3f};
        x8 = new double[] { 1.0, 2.0, 3.0 };
        x9 = new String[] {"xyz", "bc", "ab", "cd" };

        Arrays.sort(x2);
        Arrays.sort(x3);
        Arrays.sort(x4);
        Arrays.sort(x5);
        Arrays.sort(x6);
        Arrays.sort(x7);
        Arrays.sort(x8);
        //Arrays.sort(x1, (Comparator<Boolean>)(a, b) -> Boolean.compare(a, b));
        Arrays.sort(x9, (Comparator<String>)(a, b) -> a.compareTo(b));

    }
}
