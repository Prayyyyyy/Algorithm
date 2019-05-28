package com.study.problem.baekjoon;

import java.util.Scanner;

public class LargestSquare_1915 {
	static int N, M; // 배열의 행, 열
	static int result; // 가장 큰 정사각형의 넓이
	static int[][] map = new int[1000][1000]; // 배열의 정보를 저장
	static int[][] dp = new int[1000][1000]; // 정사각형의 한 변의 길이를 저장

	static int dp(int x, int y) {
		if (x == 0 || y == 0) { // 첫 행, 첫 열일 경우
			dp[x][y] = 1;
		}
		if (dp[x][y] != 0) { // 이미 방문한 경우
			return dp[x][y];
		}
		
		// x, y좌표를 기준으로 대각선, 위쪽, 왼쪽을 크기 비교하고 가장 작은 값을 구하고 +1
		dp[x][y] = Math.min(dp[x - 1][y - 1], Math.min(dp[x - 1][y], dp[x][y - 1])) + 1;

		return dp[x][y];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String st = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = st.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					int candi = dp(i, j); // (i, j)을 끝으로 하는 정사각형의 한 변의 길이
					result = Math.max(candi, result);
				}
			}
		}
		System.out.println(result * result);
	}
}