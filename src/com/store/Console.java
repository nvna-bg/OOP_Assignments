package com.store;
import java.util.Scanner;

public class Console {
    public static String readLine() {
        Scanner s = new Scanner(System.in);
        String result = s.nextLine();
        return result;
    }

    public static String readLine(String prompt) {
        System.out.print(prompt);
        String result = readLine();
        return result;
    }

    public static int readInt() {
        String input = readLine();
        int inputInt = Integer.parseInt(input);
        return inputInt;
    }

    public static int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(readLine());
    }

    public static double readDouble() { return Double.parseDouble(readLine());}

    public static double readDouble(String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(readLine());}

    public static long readLong() { return Long.parseLong(readLine());}

    public static long readLong(String prompt) {
        System.out.print(prompt);
        return Long.parseLong(readLine());}

    public static void printPrompt(String prompt) {
        System.out.println(prompt);
    }
}
