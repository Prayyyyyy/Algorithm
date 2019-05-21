package com.swea.difficult2;

import java.util.Scanner;

public class SnailNumber_1954 {
	static int[][] map;
	static String dir;
	static int num, row, col;

	static void turn() {
		switch (dir) {
		case "right":
			dir = "down";
			return;
		case "down":
			dir = "left";
			return;
		case "left":
			dir = "up";
			return;
		case "up":
			dir = "right";
			return;
		}
	}

	static void move(int n) {
		for (int i = 0; i < n; i++) {
			num++;
			switch (dir) {
			case "right":
				col++;
				break;
			case "down":
				row++;
				break;
			case "left":
				col--;
				break;
			case "up":
				row--;
				break;
			}
			map[row][col] = num;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			map = new int[10][10];
			int N = sc.nextInt();
			dir = "right";
			row = col = 0;
			num = map[0][0] = 1;
			move(N - 1);

			for (int i = N - 1; i > 0; i--) {
				turn();
				move(i);
				turn();
				move(i);
			}

			System.out.format("#%d\n", t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.format("%d ", map[i][j]);
				}
				System.out.println();
			}
		}
	}
}