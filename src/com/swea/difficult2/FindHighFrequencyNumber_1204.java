package com.swea.difficult2;

import java.util.Scanner;

public class FindHighFrequencyNumber_1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int max = Integer.MIN_VALUE;
			int result = 0;
			int[] score = new int[101];
			for (int i = 0; i < 1000; i++) {
				int student_score = sc.nextInt();
				score[student_score]++;
			}

			for (int i = 0; i < 101; i++) {
				if (score[i] >= max) {
					max = score[i];
					result = i;
				}
			}
			System.out.format("#%d %d\n", N, result);
		}
	}
}