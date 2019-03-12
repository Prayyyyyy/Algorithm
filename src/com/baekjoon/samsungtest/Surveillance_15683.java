package com.baekjoon.samsungtest;

import java.util.Scanner;

class CCTV { // CCTV의 정보를 담는 클래스
	int type; // CCTV의 종류
	int x; // CCTV의 x좌표
	int y; // CCTV의 y좌표

	CCTV(int type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}
}

public class Surveillance_15683 {
	static int N; // 사무실의 세로 크기(행)
	static int M; // 사무실의 세로 크기(열)
	static int result = Integer.MAX_VALUE; // 사각 지대의 최소 크기
	static int cctvSize = 0; // cctv의 갯수
	static int[][] office = new int[8][8]; // 사무실의 정보를 저장하는 배열
	static int[] rotateSize = { 4, 2, 4, 4, 1 }; // 각각 cctv의 회전 수를 저장하는 배열
	static CCTV cctv[] = new CCTV[8]; // cctv의 정보를 저장하는 배열

	static void update(int dir, CCTV cctv) { // cctv의 사각지대를 체크하는 함수
		dir = (dir % 4);

		if (dir == 0) {
			for (int y = cctv.y + 1; y < M; y++) {
				if (office[cctv.x][y] == 6) {
					break;
				}
				office[cctv.x][y] = -1;
			}
		} else if (dir == 1) {
			for (int x = cctv.x - 1; x >= 0; x--) {
				if (office[x][cctv.y] == 6) {
					break;
				}
				office[x][cctv.y] = -1;
			}
		} else if (dir == 2) {
			for (int y = cctv.y - 1; y >= 0; y--) {
				if (office[cctv.x][y] == 6) {
					break;
				}
				office[cctv.x][y] = -1;
			}
		} else {
			for (int x = cctv.x + 1; x < N; x++) {
				if (office[x][cctv.y] == 6) {
					break;
				}
				office[x][cctv.y] = -1;
			}
		}
	}

	static void copy(int[][] desc, int[][] src) { // 원래 배열을 복사하는 메소드
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				desc[i][j] = src[i][j];
			}
		}
	}

	static void dfs(int cctvIndex) {
		if (cctvIndex == cctvSize) { // cctv를 모두 체크했을 경우
			int temp = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (office[i][j] == 0) {
						temp++;
					}
				}
			}
			result = Math.min(temp, result);
			return;
		}

		int type = cctv[cctvIndex].type; // 간략화하기 위해 type을 다른 변수에 저장
		int[][] copyOffice = new int[8][8]; // 복사본을 저장할 배열

		for (int dir = 0; dir < rotateSize[type]; dir++) {
			copy(copyOffice, office);

			if (type == 0) {
				update(dir, cctv[cctvIndex]);
			} else if (type == 1) {
				update(dir, cctv[cctvIndex]);
				update(dir + 2, cctv[cctvIndex]);
			} else if (type == 2) {
				update(dir, cctv[cctvIndex]);
				update(dir + 1, cctv[cctvIndex]);
			} else if (type == 3) {
				update(dir, cctv[cctvIndex]);
				update(dir + 1, cctv[cctvIndex]);
				update(dir + 2, cctv[cctvIndex]);
			} else {
				update(dir, cctv[cctvIndex]);
				update(dir + 1, cctv[cctvIndex]);
				update(dir + 2, cctv[cctvIndex]);
				update(dir + 3, cctv[cctvIndex]);
			}

			dfs(cctvIndex + 1);
			copy(office, copyOffice);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				office[i][j] = sc.nextInt();

				if (office[i][j] > 0 && office[i][j] < 6) {
					cctv[cctvSize] = new CCTV(office[i][j] - 1, i, j); // cctv의 타입에서 1를 빼주는 것이 중요
					cctvSize++;
				}
			}
		}
		dfs(0);
		System.out.println(result);
	}
}