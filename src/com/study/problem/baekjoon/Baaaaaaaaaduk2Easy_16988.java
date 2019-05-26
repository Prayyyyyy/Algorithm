package com.study.problem.baekjoon;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baaaaaaaaaduk2Easy_16988 {
	static int N, M; // 바둑판의 행의 갯수, 열의 갯수
	static int result; // 죽일 수 있는 상대 돌의 최대 갯수
	static ArrayList<Point> moves; // 바둑을 둘 수 있는 좌표를 저장하는 ArrayList
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map = new int[20][20]; // 바둑판를 저장하는 배열

	static int bfs(Point p1, Point p2) {
		int candi = 0; // p1, p2에 돌을 뒀을 경우 죽일 수 잇는 상대 돌의 합
		map[p1.x][p1.y] = 1;
		map[p2.x][p2.y] = 1;
		boolean[][] visit = new boolean[20][20];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j] || map[i][j] != 2) { // 방문했거나 빈칸 또는 나의 돌인 경우 스킵
					continue;
				}

				boolean isDead = true; // 연결된 돌 중에 빈 칸과 인접하는게 하나라도 있다면 false로 변경
				Queue<Point> qu = new LinkedList<Point>();
				qu.add(new Point(i, j));
				visit[i][j] = true; // 방문 체크
				int area = 0; // 죽인 상대 돌의 갯수를 카운트

				while (!qu.isEmpty()) {
					area++;
					Point cur = qu.poll();

					for (int dir = 0; dir < 4; dir++) {
						int nx = cur.x + dx[dir];
						int ny = cur.y + dy[dir];

						if (nx < 0 || nx >= N || ny < 0 || ny >= M) { // 범위 체크
							continue;
						}
						if (map[nx][ny] == 0) { // 빈칸일 경우 false 변경(포함시키면 안됌)
							isDead = false;
						}
						if (visit[nx][ny] || map[nx][ny] != 2) { // 방문했거나 빈칸 또는 나의 돌인 경우 스킵
							continue;
						}
						qu.add(new Point(nx, ny));
						visit[nx][ny] = true;
					}
				}
				if (isDead) { // 인접한 돌 중에 빈칸이 하나도 없을 경우
					candi += area;
				}
			}
		}

		map[p1.x][p1.y] = 0;
		map[p2.x][p2.y] = 0;
		return candi;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		moves = new ArrayList<Point>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] == 0) { // 빈칸인 경우
					moves.add(new Point(i, j));
				}
			}
		}

		for (int i = 0; i < moves.size(); i++) {
			for (int j = i + 1; j < moves.size(); j++) {
				result = Math.max(result, (bfs(moves.get(i), moves.get(j))));
			}
		}

		System.out.println(result);
	}
}