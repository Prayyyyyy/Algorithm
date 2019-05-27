package com.study.problem.baekjoon;

import java.util.Scanner;

public class Jump_1890 {
	static int N; // 게임판의 크기
	static long result; // 결과값
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };
	static long[][] dp = new long[100][100]; // 각 좌표에 해당하는 경로의 수를 저장하는 배열
	static int[][] map = new int[100][100]; // 게임 판의 정보를 저장하는 배열

	static long dp(int x, int y) {
		if (x == N - 1 && y == N - 1) { // 종착점에 도착한 경우
			return 1;
		}
		if (dp[x][y] != -1) { // 이미 방문한 경우
			return dp[x][y]; // 여태까지 저장한 경우의 수를 리턴
		}

		dp[x][y] = 0; // 방문을 안한 경우

		for (int dir = 0; dir < 2; dir++) {
			int nx = x;
			int ny = y;

			for (int cnt = 0; cnt < map[x][y]; cnt++) {
				nx += dx[dir]; // 이동한 x좌표
				ny += dy[dir]; // 이동한 y좌표
			}

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
				dp[x][y] += dp(nx, ny); // 메모제이션
			}
		}

		return dp[x][y];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = -1; // 초기화
			}
		}

		result = dp(0, 0);
		System.out.println(result);
	}
}