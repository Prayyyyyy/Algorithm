package com.baekjoon.samsungtest;

import java.util.Scanner;

public class FineDustBye_17144 {
	static int R, C, T, result; // 행, 열, 시간(초), T초가 지난 후 남아있는 미세먼지의 양
	static int airCleaner_x; // 아래쪽 공기청정기의 x좌표
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map = new int[51][51];
	static int[][] spread; // 확산되는 양을 저장하는 배열

	static void spread() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] < 5) { // 미세먼지의 양이 5보다 작을 경우
					continue;
				} else { // 미세먼지의 양이 5보다 클 경우
					int data = map[i][j] / 5; // 미세먼지를 5로 나눈 몫
					int count = 0; // 미세먼지가 인접한 방향의 개수

					for (int dir = 0; dir < 4; dir++) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];

						if (nx >= 0 && nx < R && ny >= 0 && ny < C) { // 범위 체크
							if (map[nx][ny] == -1) { // 공기청정기가 있는 칸은 제외
								continue;
							} else {
								count++; // 개수 증가
								spread[nx][ny] += data; // 확산되는 양을 배열에 누적
							}
						}
					}
					data *= count; // 확산한 미세먼지의 양을 저장
					map[i][j] -= data; // 원래 미세먼지의 양에서 확산한 미세먼지의 양을 제거
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1) { // 공기청정기가 있는 칸은 제외
					continue;
				} else {
					map[i][j] += spread[i][j]; // 남아있는 미세먼지의 양과 유입된 미세먼지를 더함
				}
			}
		}
	}

	static void blow() {
		int first_low = airCleaner_x - 1; // 위쪽 공기청정기의 x좌표
		int second_low = airCleaner_x; // 아래쪽 공기청정기의 x좌표

		// 위쪽 공기청정기의 순환
		for (int x = first_low - 1; x > 0; x--) { // 맨 왼쪽 열
			map[x][0] = map[x - 1][0];
		}

		for (int y = 0; y < C - 1; y++) { // 맨 위쪽 행
			map[0][y] = map[0][y + 1];
		}

		for (int x = 0; x < first_low; x++) { // 맨 오른쪽 열
			map[x][C - 1] = map[x + 1][C - 1];
		}

		for (int y = C; y > 1; y--) { // 위쪽 공기청정기의 행
			map[first_low][y] = map[first_low][y - 1];
		}
		map[first_low][1] = 0; // 위쪽 공기청정기의 바로 앞부분은 0

		// 아래 공기청정기의 순환
		for (int x = second_low + 1; x < R - 1; x++) { // 맨 왼쪽 열
			map[x][0] = map[x + 1][0];
		}

		for (int y = 0; y < C - 1; y++) { // 맨 아래쪽 행
			map[R - 1][y] = map[R - 1][y + 1];
		}

		for (int x = R - 1; x > second_low; x--) { // 맨 오른쪽 열
			map[x][C - 1] = map[x - 1][C - 1];
		}

		for (int y = C; y > 1; y--) { // 아래쪽 공기청정기의 행
			map[second_low][y] = map[second_low][y - 1];
		}
		map[second_low][1] = 0; // 아래쪽 공기청정기의 바로 앞부분은 0
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] == -1) {
					airCleaner_x = i; // 아래쪽 공기청정기의 x좌표 저장
				}
			}
		}

		while (T != 0) { // T초동안 반복
			T--;
			spread = new int[51][51]; // 초기화

			spread(); // 미세먼지 확산
			blow(); // 공기청정기 작동
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] >= 0) { // 공기청정기를 제외
					result += map[i][j];
				}
			}
		}

		System.out.println(result);
	}
}