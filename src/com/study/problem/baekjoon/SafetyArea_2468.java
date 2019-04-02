package com.study.problem.baekjoon;

import java.util.Scanner;

public class SafetyArea_2468 {
	static int N;
	static int result = 1; // 비가 오지 않은 경우를 대비해 최솟값을 1로 설정
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visit = new boolean[100][100];
	static int[][] map = new int[100][100];

	static void dfs(int x, int y, int h) {
		if (visit[x][y]) {
			return;
		}

		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (map[nx][ny] > h && !visit[nx][ny]) {
					dfs(nx, ny, h);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int h = 1; h < 101; h++) { // 높이가 1부터 100까지이므로 차례대로 비교
			int cnt = 0; // 영역의 크기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > h && !visit[i][j]) {
						cnt++;
						dfs(i, j, h);
					}
				}
			}
			visit = new boolean[100][100];
			result = Math.max(result, cnt);
		}

		System.out.println(result);
	}
}