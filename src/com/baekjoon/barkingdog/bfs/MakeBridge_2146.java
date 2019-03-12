package com.baekjoon.barkingdog.bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MakeBridge_2146 {
	static int N;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Point> qu;

	static void bfs_Island() {
		boolean[][] visit = new boolean[N][N];
		int IslandNumber = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					qu = new LinkedList<Point>();
					Point p = new Point(i, j);
					qu.add(p);
					visit[i][j] = true;

					while (!qu.isEmpty()) {
						Point p2 = qu.poll();
						map[p2.x][p2.y] = IslandNumber;

						for (int dir = 0; dir < 4; dir++) {
							int nx = p2.x + dx[dir];
							int ny = p2.y + dy[dir];

							if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1 && !visit[nx][ny]) {
								qu.add(new Point(nx, ny));
								visit[nx][ny] = true;
							}
						}
					}
					IslandNumber++;
				}
			}
		}
	}

	static int bfs_Bridge(int x, int y) {
		int dist[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j] = -1;
			}
		}

		qu = new LinkedList<Point>();
		Point p = new Point(x, y);
		qu.add(p);
		dist[x][y] = 0;

		while (!qu.isEmpty()) {
			Point p2 = qu.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p2.x + dx[i];
				int ny = p2.y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (map[nx][ny] == map[x][y]) {
						continue;
					}
					if (dist[nx][ny] >= 0) {
						continue;
					}
					if (map[nx][ny] != 0) {
						return dist[p2.x][p2.y];
					}
					dist[nx][ny] = dist[p2.x][p2.y] + 1;
					qu.add(new Point(nx, ny));
				}
			}
		}
		return 9999;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		bfs_Island();

		int result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					result = Math.min(result, bfs_Bridge(i, j));
				}
			}
		}

		System.out.println(result);
	}
}