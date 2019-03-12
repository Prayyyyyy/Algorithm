package com.baekjoon.collegestudentbasic;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreasureIsland_2589 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, land = 0, result = 0;
	static char[][] map;
	static int[][] map2;
	static boolean[][] visit;
	static Queue<Point> qu;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String st = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = st.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					map2 = new int[N][M];
					visit = new boolean[N][M];
					land = solve(i, j);
					result = Math.max(result, land);
				}
			}
		}
		System.out.println(result);
	}

	static int solve(int x, int y) {

		qu = new LinkedList<Point>();
		visit[x][y] = true;
		Point p = new Point(x, y);
		qu.add(p);
		int count = 0;

		while (!qu.isEmpty()) {
			Point p2 = qu.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p2.x + dx[i];
				int ny = p2.y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 'L' && !visit[nx][ny]) {
					visit[nx][ny] = true;
					map2[nx][ny] = map2[p2.x][p2.y] + 1;
					qu.add(new Point(nx, ny));
					count = Math.max(map2[nx][ny], count);
				}
			}
		}
		return count;
	}
}