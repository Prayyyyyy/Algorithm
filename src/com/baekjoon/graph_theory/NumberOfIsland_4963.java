package com.baekjoon.graph_theory;

import java.util.Scanner;

public class NumberOfIsland_4963 {
	static int w, h, result;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static void solve(int x, int y) {
		visit[x][y] = true;

		for (int dir = 0; dir < 8; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
				if (!visit[nx][ny] && map[nx][ny] == 1) {
					solve(nx, ny);
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			result = 0;
			map = new int[50][50];
			visit = new boolean[50][50];

			if (w == 0 && h == 0) {
				break;
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visit[i][j] && map[i][j] == 1) {
						result++;
						solve(i, j);
					}
				}
			}
			System.out.println(result);
		}
	}
}