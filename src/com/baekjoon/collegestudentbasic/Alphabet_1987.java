package com.baekjoon.collegestudentbasic;

import java.util.Scanner;

public class Alphabet_1987 {
	static int R, C, count = 1, sol = 1;
	static char[][] board;
	static boolean[] check = new boolean[26];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();

		board = new char[R][C];

		for (int i = 0; i < R; i++) {
			String st = sc.next();
			for (int j = 0; j < C; j++) {
				board[i][j] = st.charAt(j);
			}
		}

		solve(0, 0);
		System.out.println(sol);
	}

	static void solve(int x, int y) {
		check[((int) board[x][y] - 65)] = true;

		char ch = board[x][y];

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if (!check[((int) board[nx][ny] - 65)]) {
					count++;
					sol = Math.max(count, sol);
					solve(nx, ny);
				}
			}
		}
		count--;
		check[((int) board[x][y] - 65)] = false;
	}
}