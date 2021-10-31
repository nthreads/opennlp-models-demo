package com.nthreads.opennlp;

public class Print {
    public static <T>  void print(T[] values) {
        for (T value : values)
            System.out.println(value);
    }

    public static <T>  void print(double[] values) {
        for (double value : values)
            System.out.println(value);
    }
}
