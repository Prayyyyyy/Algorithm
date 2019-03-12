package com.baekjoon.collegestudentbasic;

import java.util.Scanner;

public class RedGreenDrug_10026 {
	static char[][] grid;
	static boolean[][] check;
	static int N, countNormal = 0, countDrug = 0;
	static int dx[] = { 0, 0, -1, 1 }; // 좌, 우, 상, 하
	static int dy[] = { -1, 1, 0, 0 }; // 좌, 우, 상, 하

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		String[] input = new String[N];
		grid = new char[N][N];
		check = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.next();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = input[i].charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j] == false) {
					countNormal++;
					solve(i, j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 'G') {
					grid[i][j] = 'R';
				}
				check[i][j] = false;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j] == false) {
					countDrug++;
					solve(i, j);
				}
			}
		}
		System.out.println(countNormal + " " + countDrug);
	}

	static void solve(int x, int y) {
		check[x][y] = true;

		char ch = grid[x][y];

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !check[nx][ny]) {
				if (grid[nx][ny] == ch) {
					solve(nx, ny);
				}
			}
		}
	}
}