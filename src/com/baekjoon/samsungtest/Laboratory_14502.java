// na982님 코드 참고

package com.baekjoon.samsungtest;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Laboratory_14502 {
	static int N;
	static int M;
	static int result = Integer.MIN_VALUE;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map = new int[8][8];

	static void bfs() {
		Queue<Point> qu = new LinkedList<Point>();
		int[][] copyMap = new int[8][8]; // 원본을 복사할 배열
		boolean[][] visit = new boolean[8][8]; // 방문을 체크하는 배열

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j]; // 복사
				if (copyMap[i][j] == 2) { // 바이러스일 경우 큐에 추가, 방문 체크
					qu.add(new Point(i, j));
					visit[i][j] = true;
				}
			}
		}

		while (!qu.isEmpty()) {
			Point p = qu.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) { // 범위 체크
					if (copyMap[nx][ny] == 0 && !visit[nx][ny]) { // 빈칸이고 방문을 안했을 경우
						copyMap[nx][ny] = 2; // 바이러스로 변경
						visit[nx][ny] = true; // 방문 체크
						qu.add(new Point(nx, ny));
					}
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) { // 안전 영역의 크기 구하기
					cnt++;
				}
			}
		}
		result = Math.max(result, cnt);
	}

	static void dfs(int count, int x, int y) { // count : 벽을 세운 횟수, x, y : 벽을 세운 좌표
		if (count == 3) { // 벽을 다 세웠을 경우
			bfs(); // 바이러스를 퍼뜨림
			return;
		}

		for (int nx = x; nx < N; nx++) {
			for (int ny = y; ny < M; ny++) {
				if (map[nx][ny] == 0) { // 빈칸일 경우
					map[nx][ny] = 1; // 벽으로 변경
					dfs(count + 1, nx, ny); // 횟수를 하나 증가시키고 dfs
					map[nx][ny] = 0; // 다시 빈칸으로 변경
				}
			}
			y = 0; // 열을 한바퀴 다 돈 경우 0으로 초기화
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0, 0); // 3개의 벽 세우기

		System.out.println(result);
	}
}