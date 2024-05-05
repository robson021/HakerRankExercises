package com.example.demo;

// https://www.hackerrank.com/challenges/java-anagrams/problem
public class StringAnagram {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        String str1 = a.toLowerCase();
        String str2 = b.toLowerCase();

        java.util.function.Function<Character, String> toString = java.util.Objects::toString;
        java.util.stream.Collector<CharSequence, ?, String> joining = java.util.stream.Collectors.joining();

        String sorted1 = str1.codePoints()
                .mapToObj(c -> (char) c)
                .sorted()
                .map(toString)
                .collect(joining);

        String sorted2 = str2.codePoints()
                .mapToObj(c -> (char) c)
                .sorted()
                .map(toString)
                .collect(joining);

        return sorted1.equals(sorted2);
    }

}
