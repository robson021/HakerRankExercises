package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringParenthesesTest {

    @Test
    void isBalanced() {
        assertTrue(StringParentheses.isBalanced("({()})"));
        assertTrue(StringParentheses.isBalanced("{}()"));
        assertTrue(StringParentheses.isBalanced("[]"));

        assertFalse(StringParentheses.isBalanced("{}("));
        assertFalse(StringParentheses.isBalanced("{]}"));
    }
}
