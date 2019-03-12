package com.baekjoon.barkingdog.bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Drawing_1926 {
	static int N, M, count = 0, max = 0;
	static int[][] paper;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Point> qu = new LinkedList<Point>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		paper = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				paper[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && paper[i][j] == 1) {
					count++;
					solve(i, j);
				}
			}
		}
		System.out.println(count);
		System.out.println(max);
	}

	static void solve(int x, int y) {
		visit[x][y] = true;
		int area = 0;
		Point p = new Point(x, y);
		qu.add(p);

		while (!qu.isEmpty()) {
			area++;
			Point p2 = qu.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p2.x + dx[i];
				int ny = p2.y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (!visit[nx][ny] && paper[nx][ny] == 1) {
						visit[nx][ny] = true;
						qu.add(new Point(nx, ny));
					}
				}
			}
		}
		max = Math.max(max, area);
	}
}