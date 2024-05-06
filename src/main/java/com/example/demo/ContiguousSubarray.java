package com.example.demo;

import java.util.*;

// https://www.hackerrank.com/challenges/java-dequeue/problem

class TestIterator {
    private final Iterator<Integer> i;

    TestIterator(Iterator<Integer> i) {
        this.i = i;
    }

    int nextInt() {
        return this.i.next();
    }
}

public class ContiguousSubarray {
    private static final List<Integer> INPUT = Arrays.asList(
            1091273, 1136162, 2824530, 2734729, 2323177, 3137151, 8629406, 6883839, 7885320, 2044883, 4341515, 586875, 8264254, 1665363, 1341588, 7133211, 4279436, 6467828, 3039965, 4913413, 8109197, 7446288, 933620, 1805313, 1714701, 7657821, 5377047, 4016784, 4026002, 4249989, 4906039, 5186008, 8422951, 4582608, 955808, 5694815, 3404880, 4015801, 5742285, 7341183, 2820457, 9011890, 7683817, 7844258, 9748563, 3093105, 3562574, 3749679, 5188118, 2141802, 769140, 5228806, 17974, 2784429, 1876068, 8789679, 8975251, 3177120, 5085263, 2229733, 9294901, 8985096, 9255638, 1159554, 670064, 2954968, 2965436, 9230520, 3698479, 8245908, 9366888, 3320158, 7199936, 3420401, 2136981, 261436, 9298127, 2590299, 4415993, 4359652, 853882, 9373379, 915520, 7476938, 3048377, 6706061, 8771123, 1377384, 1210133, 4440721, 7401339, 3051752, 6750680, 528148, 2284879, 9291371, 9455156, 5318000, 5120825, 584357
    );

    public static void main(String[] args) {
        TestIterator in = new TestIterator(INPUT.iterator());
//        Scanner in = new Scanner(System.in);


        int n = 100;
        int m = 45;

        int maxUnique = 0;
        int[] counter = new int[10_000_000];

        Deque<Integer> deque = new ArrayDeque<>(m);

        boolean firstCheck = true;

        for (int i = 0, j = 0; i < n; i++) {
            if (j < m) {
                int num = in.nextInt();
                j++;
                deque.addLast(num);
                continue;
            }

            if (firstCheck) {
                for (int number : deque) {
                    counter[number]++;
                }
                firstCheck = false;
                i--;
            } else {
                int num = in.nextInt();
                deque.addLast(num);
                counter[num]++;
            }
            maxUnique = Math.max(maxUnique, checkCounter(counter));
            int first = deque.removeFirst();
            counter[first]--;
        }

        System.out.println(maxUnique);

    }

    private static int checkCounter(int[] counter) {
        int c = 0;
        for (int i : counter) {
            if (i == 1) {
                c++;
            }
        }
        return c;
    }
}
