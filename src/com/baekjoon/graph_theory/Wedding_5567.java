package com.baekjoon.graph_theory;

import java.util.Scanner;

public class Wedding_5567 {
	static int N, M, result;
	static int[][] map = new int[501][501];
	static boolean[] visit = new boolean[501];
	static boolean[] check = new boolean[501];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			map[a][b] = map[b][a] = 1;
		}

		for (int i = 2; i <= N; i++) {
			if (map[1][i] == 1) { // 상근이의 친구일 경우
				visit[i] = true;
				check[i] = true;
				result++;
			}
		}

		for (int i = 2; i <= N; i++) {
			if (check[i]) { // 상근이의 친구일 경우
				for (int j = 2; j <= N; j++) { // 상근이의 친구 중에 초대받지 않은 친구 찾는 for문
					if (!visit[j] && map[i][j] == 1) { // 초대받지 않았고 상근이의 친구의 친구일 경우
						visit[j] = true; // 중복되지 않도록 true로 변경
						result++;
					}
				}
			}
		}

		System.out.println(result);
	}
}