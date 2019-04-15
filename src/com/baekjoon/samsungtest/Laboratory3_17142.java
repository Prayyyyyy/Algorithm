package com.baekjoon.samsungtest;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Laboratory3_17142 {
	static int N, M; // 연구소의 크기, 활성 상태로 바꿀 바이러스의 개수
	static int result = Integer.MAX_VALUE; // 최소 시간
	static boolean novirus = false; // 바이러스를 모든 칸에 퍼뜨리는지 아닌지 체크
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[] visit = new boolean[10];
	static ArrayList<Point> virus = new ArrayList<Point>(); // 모든 바이러스를 저장하는 ArrayList
	static ArrayList<Point> pick = new ArrayList<Point>(); // 활성 상태인 바이러스를 저장하는 ArrayList
	static int[][] map = new int[50][50];

	static void bfs() {
		int[][] copyMap = new int[50][50];
		boolean[][] check = new boolean[50][50];
		Queue<Point> qu = new LinkedList<Point>();
		int candi = 0;

		for (int i = 0; i < N; i++) { // 맵을 카피
			for (int j = 0; j < N; j++) {
				copyMap[i][j] = map[i][j];
				if (copyMap[i][j] == 1) {
					copyMap[i][j] = -1; // 벽
				} else if (copyMap[i][j] == 2) {
					copyMap[i][j] = 0; // 비활성화된 바이러스
				}
			}
		}
		for (int i = 0; i < pick.size(); i++) { // 활성 상태인 바이러스의 좌표를 0으로 바꿔주고 큐에 넣는다
			copyMap[pick.get(i).x][pick.get(i).y] = 0;
			check[pick.get(i).x][pick.get(i).y] = true;
			qu.add(pick.get(i));
		}

		while (!qu.isEmpty()) {
			Point cur = qu.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (!check[nx][ny] && copyMap[nx][ny] >= 0) {
						check[nx][ny] = true;
						copyMap[nx][ny] = copyMap[cur.x][cur.y] + 1;
						qu.add(new Point(nx, ny));
					}
				}
			}
		}

		for (int i = 0; i < virus.size(); i++) { // 비 활성 상태인 바이러스를 다시 바꿔준다.
			if (!visit[i]) {
				copyMap[virus.get(i).x][virus.get(i).y] = -3;
			}
		}

		boolean isZero = true; // 빈칸이 있는지 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copyMap[i][j] == 0 && !check[i][j]) { // 빈칸이 남아있는 경우 체크
					isZero = false;
				}
			}
		}

		if (isZero) { // 모든 바이러스가 다 퍼진 경우
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) { // 바이러스가 다 퍼진 경우
					candi = Math.max(candi, copyMap[i][j]); // 최댓값 구하기
					novirus = false;
				}
			}
		} else { // 빈칸이 남아 있는 경우
			candi = Integer.MAX_VALUE; // 최댓값으로 치환해야 result에 들어가지 않는다.
			novirus = true;
		}

		result = Math.min(result, candi);
	}

	static void dfs(int start, int count) {
		if (count == M) { // 바이러스가 다 활성되어있을 경우 최소 시간 구하기
			bfs();
			return;
		}

		for (int i = start; i < virus.size(); i++) {
			if (!visit[i]) { // 백트래킹
				visit[i] = true;
				pick.add(virus.get(i));
				dfs(i + 1, count + 1);
				visit[i] = false;
				pick.remove(pick.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] == 2) {
					virus.add(new Point(i, j));
				}
			}
		}
		dfs(0, 0);

		boolean isZero = true; // 빈칸이 있는지 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) { // 빈칸이 하나라도 있을 경우
					isZero = false;
				}
			}
		}

		if (isZero) { // 애초에 빈칸이 없을 경우 0를 출력
			result = 0;
		}

		if (novirus && result == Integer.MAX_VALUE) { // 바이러스가 다 못 퍼진 경우
			result = -1;
		}
		System.out.println(result);
	}
}