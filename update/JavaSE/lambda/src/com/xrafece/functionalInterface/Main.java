package com.xrafece.functionalInterface;

import java.util.function.Supplier;

/**
 * @author Xrafece
 */
public class Main {
    public static String getString(Supplier<String> stringSupplier) {
        return stringSupplier.get();
    }
    public static void main(String[] args) {
        System.out.println(getString(() -> "one to more"));
    }
}
