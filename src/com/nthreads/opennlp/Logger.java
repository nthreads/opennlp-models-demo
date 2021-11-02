package com.nthreads.opennlp;

public class Logger {
    public static <T>  void log(T[] values) {
        for (T value : values)
            System.out.println(value);
    }

    public static <T>  void log(double[] values) {
        for (double value : values)
            System.out.println(value);
    }
}
