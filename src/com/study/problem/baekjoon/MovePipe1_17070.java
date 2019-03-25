package com.study.problem.baekjoon;

import java.util.Scanner;

public class MovePipe1_17070 {
	static int[][] map = new int[16][16]; // 집의 크기를 저장하는 배열
	static int[] dx = { 1, 0, 1 }; // 아래, 오른쪽, 대각선 이동의 x좌표
	static int[] dy = { 0, 1, 1 }; // 아래, 오른쪽, 대각선 이동의 y좌표
	static int N; // 새 집의 크기
	static int result; // 방법의 수

	static void move(int x, int y, int dir) { // dir = 0 : 세로, dir = 1 : 가로, dir = 2 : 대각선
		if (x == N - 1 && y == N - 1) { // x, y좌표가 파이프 한쪽 끝에 도달한 경우
			result++;
			return;
		}

		for (int i = 0; i < 3; i++) { // 아래, 오른쪽, 대각선아래만 확인하면 됌
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 새로운 좌표의 범위 체크
				if (i == 0 && dir != 1) { // 새로운 좌표의 이동이 아래쪽과 방향이 가로가 아닌 경우
					if (map[nx][ny] == 0) { // 새로운 좌표가 벽이 아닌 경우
						move(nx, ny, 0); // 아래 방향으로 이동
					}
				} else if (i == 1 && dir != 0) { // 새로운 좌표의 이동이 오른쪽과 방향이 세로가 아닌 경우
					if (map[nx][ny] == 0) { // 새로운 좌표가 벽이 아닌 경우
						move(nx, ny, 1); // 오른쪽 방향으로 이동
					}
				} else if (i == 2) { // 새로운 좌표의 이동이 대각선일 경우
					if (map[nx][ny] == 0 && map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) { // 대각선으로 갈 때 체크하는 3가지 좌표를 체크
						move(nx, ny, 2); // 대각선 방향으로 이동
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		move(0, 1, 1);
		System.out.println(result);
	}
}