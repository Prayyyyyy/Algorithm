package com.baekjoon.collegestudentbasic;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato_7576 {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int[][] store;
	static int M, N, count = 0;
	static Queue<Point> qu = new LinkedList<Point>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		store = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				store[i][j] = sc.nextInt();
				if (store[i][j] == 1) {
					qu.add(new Point(i, j));
				}
			}
		}

		while (!qu.isEmpty()) {
			Point p2 = qu.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p2.x + dx[i];
				int ny = p2.y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && store[nx][ny] == 0) {
					store[nx][ny] = store[p2.x][p2.y] + 1;
					count = store[p2.x][p2.y];
					qu.add(new Point(nx, ny));
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (store[i][j] == 0) {
					count = -1;
				}
			}
		}
		System.out.println(count);
	}
}