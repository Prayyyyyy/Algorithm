// na982님 코드 참고

package com.baekjoon.samsungtest;

import java.util.Scanner;

public class LadderManipulation_15684 {
	static int N; // 세로선의 개수
	static int M; // 가로선의 개수
	static int H; // 각각의 세로선마다 가로선을 놓을 수 있는 위치의 개수
	static int result; // 추가해야 하는 가로선 개수의 최솟값
	static int[][] map = new int[31][11];

	static boolean check() {
		boolean check = true;

		for (int i = 1; i <= N; i++) { // i번 세로선의 결과가 i번이 맞는지 체크
			int pos = i;
			for (int j = 0; j <= H; j++) {
				if (map[j][pos] == 1) {
					pos++;
				} else if (map[j][pos - 1] == 1) {
					pos--;
				}
			}
			if (pos != i) {
				return check = false;
			}
		}
		return check;
	}

	static void dfs(int cnt, int x, int y) {
		if (cnt >= result) {
			return;
		}
		if (check()) {
			result = cnt;
			return;
		}
		if (cnt == 3) {
			return;
		}
		for (int i = x; i <= H; i++) { // dfs를 통해 추가로 가로선을 그리는 모든 경우의 수를 확인
			for (int j = y; j < N; j++) {
				if (map[i][j] == 0 && map[i][j - 1] == 0 && map[i][j + 1] == 0) {
					map[i][j] = 1;
					dfs(cnt + 1, i, j);
					map[i][j] = 0;
				}
			}
			y = 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
		}

		result = 4;
		dfs(0, 1, 1);
		if (result == 4) {
			result = -1;
		}
		System.out.println(result);
	}
}