package com.swea.difficult2;

import java.util.Scanner;

public class TwoNumericalArray_1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr_A = new int[20];
			int[] arr_B = new int[20];
			int temp = 0;
			int result = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				arr_A[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				arr_B[i] = sc.nextInt();
			}

			for (int i = 0; i <= N - M; i++) { // N이 더 클 경우
					for (int j = 0; j < M; j++) {
						temp += arr_A[j + i] * arr_B[j];
					}
					result = Math.max(temp, result);
					temp = 0;
				}
			for (int i = 0; i <= M - N; i++) { // M이 더 클 경우
					for (int j = 0; j < N; j++) {
						temp += arr_A[j] * arr_B[j + i];
					}
					result = Math.max(temp, result);
					temp = 0;
				}
			

			System.out.format("#%d %d\n", t, result);
		}
	}
}