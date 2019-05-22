package com.swea.difficult3;

import java.util.Scanner;

public class ProgrammingContest_6913 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int num = 0;
			int max = 0;
			int[] people = new int[N];
			int[][] score = new int[N][M];

			for (int i = 0; i < N; i++) {
				int count = 0;
				for (int j = 0; j < M; j++) {
					score[i][j] = sc.nextInt();

					if (score[i][j] == 1) {
						count++;
					}
				}
				people[i] = count;
				if (count >= max) {
					max = count;
				}
			}

			for (int i = 0; i < N; i++) {
				if (people[i] == max) {
					num++;
				}
			}

			System.out.format("#%d %d %d\n", t, num, max);
		}
	}
}