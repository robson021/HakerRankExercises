package com.example.demo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/java-string-tokens/problem
public class StringTokens {
    public static String getTokens(String input) {
        String cleaned = input.trim()
                .replace("!", " ")
                .replace(",", " ")
                .replace("?", " ")
                .replace(".", " ")
                .replace("_", " ")
                .replace("'", " ")
                .replace("@", " ")
                .replaceAll("\\s+", " ");

        if (cleaned.trim().isEmpty()) {
            return "0";
        }

        String[] split = cleaned.split(" ");

        return Stream.concat(Stream.of("" + split.length), Stream.of(split))
                .collect(Collectors.joining("\n"));
    }
}
