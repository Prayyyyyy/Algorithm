// na982님 코드 참고

package com.baekjoon.samsungtest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Info { // 빨간 구슬의 x,y 좌표, 파란 구슬의 x,y 좌표, 횟수를 나타내는 Info 클래스
	int rx, ry;
	int bx, by;
	int count;

	Info(int rx, int ry, int bx, int by, int count) {
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.count = count;
	}
}

public class BeadEscape2_13460 {
	static int N, M; // 보드의 세로 크기, 가로 크기
	static int result = -1; // 결과값
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map = new char[10][11];
	static Info info = new Info(0, 0, 0, 0, 0); // info라는 객체 생성

	static void bfs() {
		boolean[][][][] visit = new boolean[10][10][10][10]; // 빨간 구슬, 파란 구슬이 방문한 좌표를 체크
		Queue<Info> qu = new LinkedList<Info>();

		qu.add(info);
		visit[info.rx][info.ry][info.bx][info.by] = true;

		while (!qu.isEmpty()) {
			Info cur = qu.poll();

			if (cur.count > 10) { // 10번이 넘었을 경우
				break;
			}
			if (map[cur.rx][cur.ry] == 'O' && map[cur.bx][cur.by] != 'O') { // 빨간 구슬은 구멍에 들어가고 파란 구슬은 구멍에 안 들어갔을 경우
				result = cur.count;
				break;
			}

			for (int dir = 0; dir < 4; dir++) {
				int next_rx = cur.rx;
				int next_ry = cur.ry;
				int next_bx = cur.bx;
				int next_by = cur.by;

				while (true) { // 빨간 구슬 이동
					if (map[next_rx][next_ry] != '#' && map[next_rx][next_ry] != 'O') { // 빨간 구슬의 위치가 벽과 구멍이 아닌 경우
						next_rx += dx[dir];
						next_ry += dy[dir];
					} else {
						if (map[next_rx][next_ry] == '#') { // 벽인 경우 반대 방향으로 한 칸 이동
							next_rx -= dx[dir];
							next_ry -= dy[dir];
						}
						break;
					}
				}
				while (true) { // 파란 구슬 이동
					if (map[next_bx][next_by] != '#' && map[next_bx][next_by] != 'O') { // 파란 구슬의 위치가 벽과 구멍이 아닌 경우
						next_bx += dx[dir];
						next_by += dy[dir];
					} else {
						if (map[next_bx][next_by] == '#') { // 벽인 경우 반대 방향으로 한 칸 이동
							next_bx -= dx[dir];
							next_by -= dy[dir];
						}
						break;
					}
				}

				if (next_rx == next_bx && next_ry == next_by) { // 빨간 구슬과 파란 구슬의 위치가 같은 경우
					if (map[next_rx][next_ry] != 'O') { // 빨간 구슬의 위치가 구멍이 아닌 경우
						int red_dist = Math.abs(next_rx - cur.rx) + Math.abs(next_ry - cur.ry); // 빨간 구슬이 이동한 거리
						int blue_dist = Math.abs(next_bx - cur.bx) + Math.abs(next_by - cur.by); // 파란 구슬이 이동한 거리

						if (red_dist > blue_dist) { // 빨간 구슬의 이동 거리가 더 클 경우 반대 방향으로 한 칸 이동
							next_rx -= dx[dir];
							next_ry -= dy[dir];
						} else { // 파란 구슬의 이동 거리가 더 클 경우 반대 방향으로 한 칸 이동
							next_bx -= dx[dir];
							next_by -= dy[dir];
						}
					}
				}
				if (!visit[next_rx][next_ry][next_bx][next_by]) { // 방문하지 않은 좌표일 경우 큐에 넣는다.
					visit[next_rx][next_ry][next_bx][next_by] = true; // 방문 체크
					Info next = new Info(0, 0, 0, 0, 0);
					next.rx = next_rx;
					next.ry = next_ry;
					next.bx = next_bx;
					next.by = next_by;
					next.count = cur.count + 1;
					qu.add(next);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String st = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = st.charAt(j);

				if (map[i][j] == 'R') { // 빨간 구슬일 경우 좌표 저장
					info.rx = i;
					info.ry = j;
				}
				if (map[i][j] == 'B') { // 파란 구슬일 경우 좌표 저장
					info.bx = i;
					info.by = j;
				}
			}
		}
		bfs();
		System.out.println(result);
	}
}