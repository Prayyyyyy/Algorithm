package com.study.problem.baekjoon;

import java.util.Scanner;

public class CandyGame_3085 {
	static int N;
	static int result = 0;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map = new char[51][51];

	static void check(int x, int y, int nx, int ny) {
		int count = 1;

		char temp = map[x][y];
		map[x][y] = map[nx][ny];
		map[nx][ny] = temp;

		for (int i = 0; i < N; i++) {
			count = 1;
			for (int j = 0; j < N; j++) {
				if (map[i][j] == map[i][j + 1]) {
					count++;
				} else {
					result = Math.max(count, result);
					count = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			count = 1;
			for (int j = 0; j < N; j++) {
				if (map[j][i] == map[j + 1][i]) {
					count++;
				} else {
					result = Math.max(count, result);
					count = 1;
				}
			}
		}
		map[nx][ny] = map[x][y];
		map[x][y] = temp;
	}

	static void solve(int x, int y) {
		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (map[nx][ny] != map[x][y]) {
					check(x, y, nx, ny);
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
				map[i][j] = st.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solve(i, j);
			}
		}
		System.out.println(result);
	}
}