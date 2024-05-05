package com.example.demo;

// https://www.hackerrank.com/challenges/java-string-reverse/problem
// check if string is palindrome
public class StringReverse {

    public static void isPalindrome(String input) {
        StringBuilder sb = new StringBuilder();
        String reversed = sb.append(input).reverse().toString();

        if (input.equals(reversed)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
