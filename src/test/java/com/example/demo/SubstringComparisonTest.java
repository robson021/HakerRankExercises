package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubstringComparisonTest {


    @Test
    public void test() {
        String result = SubstringComparison.getSmallestAndLargest("welcometojava", 3);
        assertThat(result).isEqualTo("ava\nwel");
    }

}
