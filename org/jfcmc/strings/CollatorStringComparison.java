package org.jfcmc.strings;

import java.text.Collator;
import java.util.Locale;

public class CollatorStringComparison {
    public static void main(String[] args) {
        Locale USLocale = new Locale("en", "US");

        Collator c = Collator.getInstance(USLocale);
        String str1 = "cat";
        String str2 = "Dog";

        System.out.print("Comparing using Collator class: ");
        int diff = c.compare(str1, str2);

        print(diff, str1, str2);

        System.out.print("Comparing using String class: ");
        diff = str1.compareTo(str2);

        print(diff, str1, str2);
    }

    public static void print(int diff, String str1, String str2) {
        if (diff > 0) {
            System.out.println(str1 + " comes after " + str2);
        }
        else if (diff < 0) {
            System.out.println(str1 + " comes before " + str2);
        }
        else {
            System.out.println(str1 + " and " + str2 + " are the same.");
        }
    }
}
