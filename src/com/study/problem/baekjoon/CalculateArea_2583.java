package com.study.problem.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class CalculateArea_2583 {
	static int N, M, K, cnt;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[] result;
	static int[][] map = new int[100][100];
	static boolean[][] visit = new boolean[100][100];

	static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if (!visit[nx][ny] && map[nx][ny] == 0) {
					result[cnt]++;
					dfs(nx, ny);
				}
			}
		}
	}

	static void check(int sy, int sx, int ey, int ex) {
		for (int i = sx; i < ex; i++) {
			for (int j = sy; j < ey; j++) {
				map[i][j] = 1;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		result = new int[N * M / 2];
		for (int i = 0; i < K; i++) {
			int start_y = sc.nextInt();
			int start_x = sc.nextInt();
			int end_y = sc.nextInt();
			int end_x = sc.nextInt();
			check(start_y, start_x, end_y, end_x);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visit[i][j]) {
					result[cnt]++;
					dfs(i, j);
					cnt++;
				}
			}
		}
		
		Arrays.sort(result);
		System.out.println(cnt);
		for (int i = 0; i < result.length; i++) {
			if (result[i] != 0) {
				System.out.print(result[i] + " ");
			}
		}
	}
}