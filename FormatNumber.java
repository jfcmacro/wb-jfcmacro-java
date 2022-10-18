// package com.example.java;

import java.text.NumberFormat;

public class FormatNumber {
    public static void main(String []args) {
        double doubleValue = 1_234_567.89;

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        System.out.println(numberFormat.format(doubleValue));
    }
}
