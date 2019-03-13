package com.swea.difficult2;

import java.util.Scanner;

public class WhereCanWordsBePut_1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int result = 0;
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] puzzle = new int[32][16];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					puzzle[j + N][i] = puzzle[i][j];
				}
			}

			for (int i = 0; i < 2 * N; i++) {
				for (int j = 0; j < N; j++) {
					if (puzzle[i][j] == 1) {

						boolean check = true;
						
						for (int k = j; k < K + j; k++) {
							if (k < N) {
								if (puzzle[i][k] == 0) {
									check = false;
								}
							} else {
								check = false;
							}
						}

						if (j - 1 >= 0 && puzzle[i][j - 1] == 1) {
							check = false;
						}
						if (j + K <= N && puzzle[i][K + j] == 1) {
							check = false;
						}

						if (check) {
							result++;
						}
					}
				}
			}

			System.out.format("#%d %d\n", t, result);
		}
	}
}