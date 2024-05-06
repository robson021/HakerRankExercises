package com.example.demo;

import java.util.*;

// https://www.hackerrank.com/challenges/java-dequeue/problem
public class ContiguousSubarray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> unique = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.addLast(num);
            unique.add(num);

            if (deque.size() == m) {
                max = Math.max(max, unique.size());
                unique.remove(deque.pollFirst());
            }

        }
        System.out.println(max);
    }

}
