package org.example;

import org.apache.commons.text.similarity.JaroWinklerSimilarity;

public class Utils {
    public static String normalize(String input) {
        if (input == null) return "";
        return input.trim().toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    public static double similarity(String s1, String s2) {
        return new JaroWinklerSimilarity().apply(normalize(s1), normalize(s2));
    }

    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty() || s.trim().equalsIgnoreCase("\\N");
    }

}
