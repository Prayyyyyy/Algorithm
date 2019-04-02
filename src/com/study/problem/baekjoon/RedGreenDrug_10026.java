package com.study.problem.baekjoon;

import java.util.Scanner;

public class RedGreenDrug_10026 {
	static int N;
	static int result;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] grid = new char[100][100];
	static boolean[][] visit = new boolean[100][100];

	static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (!visit[nx][ny] && grid[x][y] == grid[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String st = sc.next();
			for (int j = 0; j < N; j++) {
				grid[i][j] = st.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					result++;
					dfs(i, j);
				}
			}
		}
		System.out.println(result);

		result = 0;
		visit = new boolean[100][100];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 'G') {
					grid[i][j] = 'R';
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					result++;
					dfs(i, j);
				}
			}
		}
		System.out.println(result);
	}
}