package com.swea.difficult3;

import java.util.Scanner;

public class CardGame_7102 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max = Integer.MIN_VALUE;
			int[] sum = new int[N + M + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					sum[i + j]++;
				}
			}

			for (int i = 1; i <= N + M; i++) {
				if (sum[i] >= max) {
					max = sum[i];
				}
			}

			System.out.format("#%d ", t);
			for (int i = 1; i <= N + M; i++) {
				if (sum[i] == max) {
					System.out.format("%d ", i);
				}
			}
			System.out.println();
		}
	}
}