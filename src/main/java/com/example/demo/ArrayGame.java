package com.example.demo;

// https://www.hackerrank.com/challenges/java-1d-array/problem
public class ArrayGame {
    public static boolean canWin(int leap, int[] game) {
        return tryWin(0, leap, game);
    }

    private static boolean tryWin(int currentPosition, int leap, int[] game) {
        int boundary = game.length - 1;

        int smallMove = currentPosition + 1;
        int bigMove = currentPosition + leap;

        if (currentPosition < 0 || game[currentPosition] != 0) {
            return false;
        }

        if (smallMove > boundary || bigMove > boundary) {
            return true;
        }

        if (game[bigMove] > 0 || game[smallMove] > 0 || game[currentPosition - 1] > 0) {
            return false;
        }

        game[currentPosition] = 1;

        return tryWin(currentPosition + 1, leap, game)
                || tryWin(currentPosition - 1, leap, game)
                || tryWin(currentPosition + leap, leap, game);
    }
}
