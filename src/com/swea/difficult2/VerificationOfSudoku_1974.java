package com.swea.difficult2;

import java.util.Scanner;

public class VerificationOfSudoku_1974 {
	static int[][] map = new int[9][9];
	static int[] check;

	static int solve_row(int k) {
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (map[i][k] == map[j][k]) {
					return 0;
				}
			}
		}
		return 1;
	}

	static int solve_col(int k) {
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (map[k][i] == map[k][j]) {
					return 0;
				}
			}
		}
		return 1;
	}

	static int solve_mix(int k) {
		if (k < 3) {
			for (int i = 0; i < 3; i++) {
				for (int j = k * 3; j < (k + 1) * 3; j++) {
					check[map[i][j]]++;
				}
			}
		} else if (k >= 3 && k < 6) {
			k %= 3;
			for (int i = 3; i < 6; i++) {
				for (int j = k * 3; j < (k + 1) * 3; j++) {
					check[map[i][j]]++;
				}
			}
		} else {
			k %= 3;
			for (int i = 6; i < 9; i++) {
				for (int j = k * 3; j < (k + 1) * 3; j++) {
					check[map[i][j]]++;
				}
			}
		}

		for (int i = 0; i < 9; i++) {

		}
		for (int i = 0; i < 9; i++) {
			if (check[i] != 1) {
				return 0;
			}
		}

		return 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int result = 1;

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < 9; i++) {
				check = new int[10];
				check[0] = 1;
				result = solve_row(i);
				if (result == 0) {
					break;
				}
				result = solve_col(i);
				if (result == 0) {
					break;
				}
				result = solve_mix(i);
				if (result == 0) {
					break;
				}
			}

			System.out.format("#%d %d\n", t, result);
		}
	}
}