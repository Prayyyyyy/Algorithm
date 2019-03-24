package com.study.problem.baekjoon;

import java.util.Scanner;

public class CuttingChocolate_2163 {
	static int map[][] = new int[301][301];

	static void init() {  // (1, N) 모양의 초콜릿을 자를 수 있는 최소한의 수를 구하기
		for (int i = 2; i < map[1].length; i++) {
			map[1][i] = i - 1; // (1, N)의 최소한의 수 : N-1
		}
	}

	static int dp(int x, int y) { // 초콜릿을 자르는 과정
		if (x == 1) {
			return map[x][y];
		}
		return dp(x - 1, y) + map[1][y] + 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int result = 0; // 최소 쪼개기 횟수
		int N = sc.nextInt(); // 초콜릿의 크기(행)
		int M = sc.nextInt(); // 초콜릿의 크기(열)

		init();
		result = dp(N, M);
		System.out.println(result);
		// System.out.println((N*M)-1); 가장 단순한 해결 방법
	}
}