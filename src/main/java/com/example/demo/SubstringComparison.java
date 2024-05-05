package com.example.demo;

import java.util.List;
import java.util.stream.IntStream;

// https://www.hackerrank.com/challenges/java-string-compare/problem
class SubstringComparison {
    public static String getSmallestAndLargest(String s, int k) {
        List<Character> uniqueChars = s.codePoints().distinct()
                .mapToObj(c -> (char) c)
                .sorted()
                .toList();

        var substrings = IntStream.range(0, s.toCharArray().length - k + 1)
                .mapToObj(i -> s.substring(i, i + k))
                .toList();

        String smallest = findSmallest(substrings, uniqueChars, 0);
        String largest = findLargest(substrings, uniqueChars, uniqueChars.size() - 1);

        return smallest + "\n" + largest;
    }

    private static String findSmallest(List<String> substrings, List<Character> uniqueChars, int index) {
        var candidates = findCandidates(substrings, uniqueChars, index);
        return candidates.isEmpty()
                ? findSmallest(substrings, uniqueChars, index + 1)
                : candidates.getFirst();
    }

    private static String findLargest(List<String> substrings, List<Character> uniqueChars, int index) {
        var candidates = findCandidates(substrings, uniqueChars, index);
        return candidates.isEmpty()
                ? findLargest(substrings, uniqueChars, index - 1)
                : candidates.getLast();
    }

    private static List<String> findCandidates(List<String> substrings, List<Character> uniqueChars, int index) {
        char c = uniqueChars.get(index);
        return substrings.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .sorted()
                .toList();
    }
}
