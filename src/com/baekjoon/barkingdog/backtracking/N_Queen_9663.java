package com.baekjoon.barkingdog.backtracking;

import java.util.Scanner;

public class N_Queen_9663 {
	static int N, count = 0;
	static boolean[] col = new boolean[40];
	static boolean[] left = new boolean[40];
	static boolean[] right = new boolean[40];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		solve(0);
		System.out.println(count);
	}

	static void solve(int k) {
		if (k == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (col[i] || left[i + k] || right[k - i + N]) {
				continue;
			}
			col[i] = true;
			left[i + k] = true;
			right[k - i + N] = true;

			solve(k + 1);

			col[i] = false;
			left[i + k] = false;
			right[k - i + N] = false;
		}
	}
}