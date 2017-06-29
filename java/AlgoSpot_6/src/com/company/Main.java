package com.company;

import java.util.Scanner;

public class Main {

    static char[][] board = new char[5][5];
    static String[] words;
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int count = Integer.parseInt(sc.nextLine());

	    for (int i=0; i<count; i++) {
	        board[0] = sc.nextLine().toCharArray();
	        board[1] = sc.nextLine().toCharArray();
	        board[2] = sc.nextLine().toCharArray();
	        board[3] = sc.nextLine().toCharArray();
	        board[4] = sc.nextLine().toCharArray();

	        int wordCase = Integer.parseInt(sc.nextLine());
	        words = new String[wordCase];
	        for (int j=0; j<wordCase; j++) {
	            words[j] = sc.nextLine();
            }

            for (int j=0; j < wordCase; j++) {
                System.out.println(hasWords(0, 0, words[j]) ? "YES" : "NO");
            }
        }
    }

    static int[] dx = { -1, -1, -1, 1, 1, 1, 0, 0};
    static int[] dy = { -1, 0, 1, -1, 0, 1, -1, 1};
    private static boolean hasWords(int y, int x, String word) {
        if (!inRange(y, x)) return false;

        if (board[y][x] != word.charAt(0))  return false;

        if (word.length() == 1) return true;

        for (int direction = 0; direction < 8; direction++) {
            int nextX = x + dx[direction];
            int nextY = y + dy[direction];
            if (hasWords(nextY, nextX, word.substring(1))) {
                return true;
            }
        }

        return false;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && x >= 0;
    }
}
