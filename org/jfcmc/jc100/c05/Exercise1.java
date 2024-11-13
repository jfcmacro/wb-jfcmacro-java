package org.jfcmc.jc100.c05;

public class Exercise1 {

    public static void orderEvenBeforeOdd(int[] elems) {

        for (int i = 0; i < elems.length; i++) {
            if (elems[i] % 2 == 0) {
                continue;
            }
            int nextOdd = -1;
            for (int j = i + 1; nextOdd < 0 && j < elems.length; j++) {
                if (elems[j] % 2 == 0) {
                    nextOdd = j;
                    break;
                }
            }
            if (nextOdd > 0) {
                int tmp = elems[i];
                elems[i] = elems[nextOdd];
                elems[nextOdd] = tmp;
            }
            else {
                break;
            }
        }
    }
}
