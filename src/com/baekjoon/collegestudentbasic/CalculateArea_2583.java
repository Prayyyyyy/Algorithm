package com.baekjoon.collegestudentbasic;

import java.util.Arrays;
import java.util.Scanner;

public class CalculateArea_2583 {
	static int M, N, K, count = 0;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] area;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();

		map = new int[M][N];
		visit = new boolean[M][N];
		area = new int[M * N];

		for (int i = 0; i < K; i++) {
			int left_x = sc.nextInt();
			int left_y = sc.nextInt();
			int right_x = sc.nextInt();
			int right_y = sc.nextInt();

			for (int j = left_y; j < right_y; j++) {
				for (int k = left_x; k < right_x; k++) {
					map[j][k] = 1;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 && !visit[i][j]) {
					count++;
					area[count]++;
					solve(i, j);
				}
			}
		}
		
		Arrays.sort(area);
		System.out.println(count);
		for (int i = 0; i < area.length; i++) {
			if (area[i] != 0) {
				System.out.print(area[i] + " ");
			}
		}
	}

	static void solve(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visit[nx][ny] && map[nx][ny] == 0) {
				area[count]++;
				solve(nx, ny);
			}
		}
	}
}