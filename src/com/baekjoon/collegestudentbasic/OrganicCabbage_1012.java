package com.baekjoon.collegestudentbasic;

import java.util.Scanner;

public class OrganicCabbage_1012 {
	static int[][] field;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int M, N, count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();

			field = new int[M][N];
			visit = new boolean[M][N];
			count = 0;

			for (int j = 0; j < K; j++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();

				field[X][Y] = 1;
			}

			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (field[j][k] == 1 && !visit[j][k]) {
						count++;
						solve(j, k);
					}
				}
			}
			System.out.println(count);
		}
	}

	static void solve(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < M && ny >= 0 && ny < N && field[nx][ny] == 1) {
				if (!visit[nx][ny]) {
					solve(nx, ny);
				}
			}
		}
	}
}