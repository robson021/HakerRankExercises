package com.example.demo;

import java.util.Stack;

// https://www.hackerrank.com/challenges/java-stack/problem
public class StringParentheses {

    public static boolean isBalanced(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (isOpening(c)) {
                stack.push(c);
                continue;
            }

            if (stack.empty()) {
                return false;
            }

            char top = stack.pop();
            if (!checkClosure(top, c)) {
                return false;
            }
        }
        return stack.empty();
    }


    private static boolean checkClosure(char a, char b) {
        switch (a) {
            case '(': return b == ')';
            case '[': return b == ']';
            case '{': return b == '}';
        }
        return false;
    }

    private static boolean isOpening(char c) {
        return c == '(' || c == '[' || c == '{';
    }

}
