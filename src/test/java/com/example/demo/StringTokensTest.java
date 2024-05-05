package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTokensTest {

    @Test
    void getTokens() {
        String tokens = StringTokens.getTokens("He is a very very good boy, isn't he?");

        StringBuilder sb = new StringBuilder();
        sb.append("10\n");
        sb.append("He\n");
        sb.append("is\n");
        sb.append("a\n");
        sb.append("very\n");
        sb.append("very\n");
        sb.append("good\n");
        sb.append("boy\n");
        sb.append("isn\n");
        sb.append("t\n");
        sb.append("he");

        assertThat(tokens).isEqualTo(sb.toString());

        System.out.println(tokens);

        assertThat(StringTokens.getTokens("             ")).isEqualTo("0");
    }
}
