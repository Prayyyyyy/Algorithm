package com.swea.difficult2;

import java.util.Scanner;

public class EradicationFly_2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			int result = 0, sum = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N - M; i++) {
				for (int j = 0; j < N - M; j++) {
					sum = 0;
					for (int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							sum += map[i + k][i + l];
						}
					}
					result = Math.max(sum, result);
				}
			}
			System.out.format("#%d %d\n", t, result);
		}
	}
}