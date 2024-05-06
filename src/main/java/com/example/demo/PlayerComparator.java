package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;

// https://www.hackerrank.com/challenges/java-comparator/problem
class Player {
    final String name;
    final int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class PlayerComparator {
    void doCompare(Player[] players) {
        Arrays.sort(players, new Checker());
        for (Player player : players) {
            System.out.printf("%s %s\n", player.name, player.score);
        }
    }

    private static class Checker implements Comparator<Player> {
        @Override
        public int compare(Player p1, Player p2) {
            if (p1.score == p2.score) {
                return p1.name.compareTo(p2.name);
            }
            if (p1.score > p2.score) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
