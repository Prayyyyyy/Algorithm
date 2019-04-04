package com.study.problem.baekjoon;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Iceberg_2573 {
	static int N, M; // 배열의 크기
	static int result; // 최초의 시간(년)
	static int count; // 덩어리 개수
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map = new int[300][300];
	static boolean[][] visit = new boolean[300][300];

	static boolean isCheck() { // 빙산이 다 녹았는지 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) { // 하나라도 안 녹았을 경우
					return true;
				}
			}
		}
		// 다 녹았을 경우
		return false;
	}

	static void bfs(int x, int y) { // 덩어리 개수 찾는 bfs
		Queue<Point> qu = new LinkedList<Point>();

		Point p = new Point(x, y);
		visit[x][y] = true;
		qu.add(p);

		while (!qu.isEmpty()) {
			Point p2 = qu.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p2.x + dx[i];
				int ny = p2.y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) { // 범위체크
					if (map[nx][ny] > 0 && !visit[nx][ny]) { // 높이가 0보다 크고 아직 방문안한 빙산
						visit[nx][ny] = true;
						qu.add(new Point(nx, ny));
					}
				}
			}
		}
	}

	static void dfs(int x, int y) { // 빙산을 녹이는 dfs
		int minus = 0; // 빙산 주변에 접한 바닷물의 크기
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < M) { // 범위체크
				if (map[nx][ny] <= 0 && !visit[nx][ny]) { // 높이가 0보다 작고 방문하지 않은 경우
					minus--; // 바닷물에 접한 부분 증가
				}
			}
		}
		map[x][y] += minus; // 해당되는 빙산에서 접한 바닷물의 크기만큼 녹임
		return;
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

		boolean isSeperate = true; // 분리되었는지 안되었는지 체크
		while (isSeperate) { // 두 덩어리 이상으로 분리될 떄까지 무한루프
			isSeperate = false;
			count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0) { // 빙산인 경우만 dfs
						dfs(i, j);
					}
				}
			}
			visit = new boolean[300][300];
			result++; // dfs 돌 때마다 시간(년) 증가
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0 && !visit[i][j]) {
						count++; // bfs돌 때마다 덩어리 개수 증가
						bfs(i, j);
					}
				}
			}

			if (count >= 2) { // 덩어리 개수가 2이상인 경우
				isSeperate = false;
			} else {
				if (isCheck()) { // 빙산이 다 녹았는지 안녹았는지 확인
					isSeperate = true; // 아직 안녹았을 경우 반복
				} else { // 다 녹았을 경우 0을 출력
					isSeperate = false;
					result = 0;
				}
			}

		}
		System.out.println(result);
	}
}