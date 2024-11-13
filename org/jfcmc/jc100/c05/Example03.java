package org.jfcmc.jc100.c05;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Example03 {

    public static void removeDuplicates(int[] arrays) {
        int j = 0;

        for (int i = 1; i < arrays.length; i++) {
            if (arrays[j] != arrays[i]) {
                arrays[++j] = arrays[i];
            }
        }

        j++;
        for (; j < arrays.length; j++) {
            arrays[j] = -1;
        }
    }

    public static int[] removeDuplicates2(int[] arrays) {
        int j = 0;

        for (int i = 1; i < arrays.length; i++) {
            if (arrays[j] != arrays[i]) {
                arrays[++j] = arrays[i];
            }
        }

        j++;

        int[] result = new int[j];
        return Arrays.copyOfRange(arrays, 0, j);
    }

    public static int[] removeDuplicates3(int[] arrays) {
        Set<Integer> elems = new TreeSet<>();

        for (int i : arrays) {
            elems.add(i);
        }

        int[] result = new int[elems.size()];

        int j = 0;
        for (Integer i : elems) {
            result[j++] = i;
        }

        return result;
    }
}
