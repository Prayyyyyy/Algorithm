package com.swea.difficult2;

import java.util.Scanner;

public class NumericalArrayRotation_1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int[][] arr90 = new int[N][N];
			int[][] arr180 = new int[N][N];
			int[][] arr270 = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr90[i][j] = arr[N - j - 1][i];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr180[i][j] = arr[N - i - 1][N - j - 1];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr270[i][j] = arr[j][N - i - 1];
				}
			}

			System.out.format("#%d\n", t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr270[i][j]);
				}
				System.out.println("");
			}
		}
	}
}