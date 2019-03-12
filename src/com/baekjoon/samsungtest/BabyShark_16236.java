// na982님 코드 참고

package com.baekjoon.samsungtest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Shark {
	int x; // 아기상어의 x좌표
	int y; // 아기상어의 y좌표
	int time; // 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간

	Shark(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

public class BabyShark_16236 {
	static int[][] map = new int[20][20]; // 물고기와 아기 상어가 사는 공간
	static int[] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우(x좌표)
	static int[] dy = { 0, 0, -1, 1 }; // 상, 하, 좌, 우(y좌표)
	static int N; // 공간의 크기
	static int sharkSize; // 아기 상어의 크기
	static int sharkEating; // 아기 상어가 먹은 물고기 마리 수
	static Shark shark; // 아기 정보를 저장하는 객체

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] == 9) { // 아기 상어의 좌표를 저장
					shark = new Shark(i, j, 0);
					sharkSize = 2;
					sharkEating = 0;
					map[i][j] = 0;
				}
			}
		}

		boolean isUpdate = true; // 업데이트를 한 경우 -> true, 안한 경우 -> false
		while (isUpdate) { // 업데이트가 없을 때까지 반복
			isUpdate = false;
			boolean[][] visit = new boolean[20][20]; // 방문을 체크하는 배열
			Queue<Shark> qu = new LinkedList<Shark>(); // Shark에 대한 큐 생성
			visit[shark.x][shark.y] = true; // 현재 shark의 위치를 방문함
			qu.add(shark); // 현재 shark를 큐에 push

			Shark temp = new Shark(20, 0, -1); // 후보

			while (!qu.isEmpty()) {
				Shark cur = qu.poll();

				if (temp.time != -1 && temp.time < cur.time) {
					break;
				}

				if (map[cur.x][cur.y] < sharkSize && map[cur.x][cur.y] != 0) { // 아기 상어의 크기보다 작은 물고기가 존재하는가?
					isUpdate = true; // 있다면 업데이트를 해야 한다
					if (temp.x > cur.x || (temp.x == cur.x && temp.y > cur.y)) { // 우선순위를 먼저 찾아야 함
						temp = cur;
					}
				}

				for (int i = 0; i < 4; i++) {
					Shark next = new Shark(0, 0, 0);
					next.x = cur.x + dx[i];
					next.y = cur.y + dy[i];
					next.time = cur.time + 1;

					if (next.x < 0 || next.x >= N || next.y < 0 || next.y >= N) { // 범위를 벗어난 경우
						continue;
					}
					if (!visit[next.x][next.y] && sharkSize >= map[next.x][next.y]) { // 방문한 적이 없고 아기의 상어가 물고기의 크기보다 같거나 작을 경우
						visit[next.x][next.y] = true;
						qu.add(next);
					}
				}
			}

			if (isUpdate) { // 업데이트를 한 경우(물고기를 잡아먹음)
				shark = temp; // 후보를 shark에 대입
				sharkEating++;
				if (sharkSize == sharkEating) { // 아기 상어의 크기와 먹은 물고기의 마리 수가 같은 경우
					sharkSize++; // 아기 상어의 크기를 증가
					sharkEating = 0; // 먹은 물고기 마리 수 초기화
				}
				map[shark.x][shark.y] = 0; // 아기 상어가 도착한 좌표 초기화
			}
		}
		System.out.println(shark.time);
	}
}