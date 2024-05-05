package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StringAnagramTest {

    @Test
    void isAnagram() {
        assertTrue(StringAnagram.isAnagram("anagram", "margana"));
    }
}
