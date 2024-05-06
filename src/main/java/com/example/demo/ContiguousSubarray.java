package com.example.demo;

import java.util.*;

// https://www.hackerrank.com/challenges/java-dequeue/problem
public class ContiguousSubarray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int currentMax = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> unique = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.addLast(num);
            unique.add(num);

            if (deque.size() == m) {
                if (unique.size() > currentMax) {
                    currentMax = unique.size();
                }
                Integer first = deque.pollFirst();
                if (!deque.contains(first)) {
                    unique.remove(first);
                }
            }
        }
        System.out.println(currentMax);
    }

}
