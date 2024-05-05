package com.example.demo;

// https://www.hackerrank.com/challenges/java-string-compare/problem
// In this task UI did not allow me to change imports. Fully qualified collections are must
class SubstringComparison {
    public static String getSmallestAndLargest(String s, int k) {
        java.util.List<Character> uniqueChars = s.codePoints()
                .distinct()
                .mapToObj(c -> (char) c)
                .sorted()
                .collect(java.util.stream.Collectors.toList());

        java.util.List<String> substrings = java.util.stream.IntStream.range(0, s.toCharArray().length - k + 1)
                .mapToObj(i -> s.substring(i, i + k))
                .collect(java.util.stream.Collectors.toList());

        String smallest = findSmallest(substrings, uniqueChars, 0);
        String largest = findLargest(substrings, uniqueChars, uniqueChars.size() - 1);

        return smallest + "\n" + largest;
    }

    private static String findSmallest(java.util.List<String> substrings, java.util.List<Character> uniqueChars, int index) {
        java.util.List<String> candidates = findCandidates(substrings, uniqueChars, index);
        return candidates.isEmpty()
                ? findSmallest(substrings, uniqueChars, index + 1)
                : candidates.get(0);
    }

    private static String findLargest(java.util.List<String> substrings, java.util.List<Character> uniqueChars, int index) {
        java.util.List<String> candidates = findCandidates(substrings, uniqueChars, index);
        return candidates.isEmpty()
                ? findLargest(substrings, uniqueChars, index - 1)
                : candidates.get(candidates.size() - 1);
    }

    private static java.util.List<String> findCandidates(java.util.List<String> substrings, java.util.List<Character> uniqueChars, int index) {
        char c = uniqueChars.get(index);
        return substrings.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .sorted()
                .collect(java.util.stream.Collectors.toList());
    }
}
