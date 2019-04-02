// na982님 코드 참고

package com.baekjoon.samsungtest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class ROBOT {
	int x;
	int y;
	int dir;

	ROBOT(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

public class RobotVacuum_14503 {
	static int N, M;
	static int result = 0;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map = new int[50][50];
	static ROBOT robot;
	static Queue<ROBOT> qu = new LinkedList<ROBOT>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();
		robot = new ROBOT(x, y, d);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		qu.add(robot);

		while (!qu.isEmpty()) {
			ROBOT cur = qu.poll();

			if (map[cur.x][cur.y] == 0) {
				map[cur.x][cur.y] = 2;
				result++;
			}

			for (int dir = 0; dir < 4; dir++) {
				ROBOT next = new ROBOT(0, 0, 0);

				next.dir = (cur.dir + 3 - dir) % 4;
				next.x = cur.x + dx[next.dir];
				next.y = cur.y + dy[next.dir];

				if (next.x < 0 || next.x >= N || next.y < 0 || next.y >= M || map[next.x][next.y] != 0) {
					continue;
				}
				qu.add(next);
				break;
			}

			if (qu.isEmpty()) {
				ROBOT next = new ROBOT(0, 0, 0);
				
				next.dir = cur.dir;
				next.x = cur.x + dx[(next.dir + 2) % 4];
				next.y = cur.y + dy[(next.dir + 2) % 4];

				if (next.x < 0 || next.x >= N || next.y < 0 || next.y >= M || map[next.x][next.y] == 1) {
					break;
				}
				qu.add(next);
			}
		}
		System.out.println(result);
	}
}