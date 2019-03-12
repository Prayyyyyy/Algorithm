package com.baekjoon.collegestudentbasic;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeSearch_2178 {
	static int N, M;
	static int[][] maze;
	static Queue<Point> qu;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		maze = new int[N][M];
		qu = new LinkedList<Point>();

		for (int i = 0; i < N; i++) {
			String st = sc.next();
			for (int j = 0; j < st.length(); j++) {
				maze[i][j] = st.charAt(j) - '0';
			}
		}
		solve(0, 0);

		System.out.println(maze[N - 1][M - 1]);
	}

	static void solve(int x, int y) {
		Point p = new Point(x, y);
		qu.add(p);

		while (!qu.isEmpty()) {
			Point p2 = qu.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p2.x + dx[i];
				int ny = p2.y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && maze[nx][ny] == 1) {
					maze[nx][ny] = maze[p2.x][p2.y] + 1;
					qu.add(new Point(nx, ny));
				}
			}
		}
	}
}