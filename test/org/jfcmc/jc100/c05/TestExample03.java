package org.jfcmc.jc100.c05;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

import static org.jfcmc.jc100.c05.Example03.removeDuplicates;

class TestExample03 {

    @Test
    void test001() {
        int[] arrays = { 1, 1, 2, 2, 2, 3, 4, 4, 4 };
        int[] expected = { 1, 2, 3, 4 };
        removeDuplicates(arrays);
        assertArrayEquals(expected, arrays, "Both arrays aren't equals");
    }

    @Test
    void test002() {
        int[] arrays = { 1, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4 };
        removeDuplicates(arrays);
        assertArrayEquals(expected, arrays, "Both arrrays aren't equals");
    }

    @Test
    void test003() {
        int[] arrays = { };
        int[] expected = { };
        removeDuplicates(arrays);
        assertArrayEquals(expected, arrays, "Both arrrays aren't equals");
    }
}
