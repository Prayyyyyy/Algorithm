package com.baekjoon.collegestudentbasic;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MovementOfKnight_7562 {
	static int T, len, start_x, start_y, move_x, move_y;
	static int[][] chessboard;
	static int[] dx = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static Queue<Point> qu;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			len = sc.nextInt();
			start_x = sc.nextInt();
			start_y = sc.nextInt();
			move_x = sc.nextInt();
			move_y = sc.nextInt();

			chessboard = new int[len][len];
			qu = new LinkedList<Point>();

			solve(start_x, start_y);

			if (start_x == move_x && start_y == move_y) {
				System.out.println("0");
			} else {
				System.out.println(chessboard[move_x][move_y]);
			}
		}
	}

	static void solve(int x, int y) {
		Point p = new Point(x, y);
		qu.add(p);

		while (!qu.isEmpty()) {

			Point p2 = qu.poll();
			for (int i = 0; i < 8; i++) {
				int nx = p2.x + dx[i];
				int ny = p2.y + dy[i];

				if (nx >= 0 && nx < len && ny >= 0 && ny < len && chessboard[nx][ny] == 0) {
					chessboard[nx][ny] = chessboard[p2.x][p2.y] + 1;
					qu.add(new Point(nx, ny));
				}
			}
		}
	}
}