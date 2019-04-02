package com.study.problem.baekjoon;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MovementOfKnight_7562 {
	static int N, result, start_x, start_y, end_x, end_y;
	static int[][] board;
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static Queue<Point> qu;

	static void bfs() {
		qu = new LinkedList<Point>();
		Point p = new Point(start_x, start_y);
		qu.add(p);

		while (!qu.isEmpty()) {
			Point p2 = qu.poll();

			for (int i = 0; i < 8; i++) {
				int nx = p2.x + dx[i];
				int ny = p2.y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (board[nx][ny] == 0) {
						board[nx][ny] = board[p2.x][p2.y] + 1;
						qu.add(new Point(nx, ny));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			result = 0;
			N = sc.nextInt();
			board = new int[N][N];

			start_x = sc.nextInt();
			start_y = sc.nextInt();
			end_x = sc.nextInt();
			end_y = sc.nextInt();

			bfs();

			if (start_x == end_x && start_y == end_y) {
				result = 0;
			} else {
				result = board[end_x][end_y];
			}

			System.out.println(result);
		}
	}
}