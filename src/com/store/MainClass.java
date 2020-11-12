package com.store;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] abc) {
        Boolean[] x1 = new Boolean[10];
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
        Arrays.fill(x5, 7);
        Arrays.fill(x6, 1l);
        Arrays.fill(x7, 3.14f);
        Arrays.fill(x8, 3.14);
        Arrays.fill(x9, "hello world");

        // инициализация с различни стойности
        x1 = new Boolean[] {true, false, true, false, true, false, true, false, true, false};
        x2 = new byte[] { (byte)0, (byte)0, (byte)1 };
        x3 = new char[] { 'a', 'b', 'c' , 'B'};
        x4 = new short[] { (short)1, (short)2 };
        x5 = new int[] { 3, 1, 5 };
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

        // синтаксисът за lambda expression-а който сортира е:
        // "със" -> "двата параметъра a и b" (a, b) "провери дали а е по-голямо от b" return a - b;
        // т.е. ползваме същата логика за сортиране която ползвахме при писането на compareTo

        // в случая с booleans искаме да натрупаме всичките false в началото на масива,
        // всичките true в края -> ако (а) е true връщаме 1 ( 1 значи по-голямо , следователно ще отиде към края )
        Arrays.sort(x1, (a, b) -> {return (a != b) ? (a) ? 1 : -1 : 0;});
        // в случая със String ползваме базовата функция String.compareTo
        Arrays.sort(x9, (a, b) -> a.compareTo(b));

        // int compare(int a , int b) {
        //  return a.compareTo(b);
        // }

        Color[] x10 = new Color[] {
                new Color(1235123123),
                new Color(55123123),
                new Color(912813)
        };
        //Arrays.fill(x10, new Color(1213123123));
        Arrays.sort(x10);

        ColorRectangle[] x11 = new ColorRectangle[] {
                new ColorRectangle(0,0,10,10, 12321314),
                new ColorRectangle(1,1,4,4,13341),
                new ColorRectangle(0,0,2,2,555123)
        };
        //Arrays.fill(x11, new ColorRectangle(0,0,10,10, 12321314));
        Arrays.sort(x11, (rect1, rect2) -> rect1.compareTo(rect2));

        // int funcA(ColorRectangle rect1, ColorRectangle rect2) {
        //      return rect1.compareTo(rect2);
        // }

        System.out.println(Arrays.toString(x10));
        System.out.println(Arrays.toString(x11));

        RectangleArray rectArray = new RectangleArray("rectangle_test.txt");
        System.out.println("sled otvarqneto na fail");

        System.out.println("total area: " + rectArray.calcSumArea());
        System.out.println("total perimeter: " + rectArray.calcSumPerimeter());
    }
}
