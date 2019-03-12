package com.baekjoon.findrule;

import java.util.Scanner;

public class WomenSocietyPresident_2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();

			int[][] arr = new int[k + 1][n + 1];
			for (int j = 0; j < k; j++) {
				arr[j][0] = 0;
			}
			for (int j = 0; j < n + 1; j++) {
				arr[0][j] = j;
			}

			for (int j = 1; j < k + 1; j++) {
				for (int m = 1; m < n + 1; m++) {
					arr[j][m] = arr[j - 1][m] + arr[j][m - 1];
				}
			}
			System.out.println(arr[k][n]);
		}
	}
}