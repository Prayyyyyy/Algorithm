package com.baekjoon.collegestudentbasic;

import java.util.Scanner;

public class MaximumDifference_10819 {
	static int N, result = 0;
	static int[] arr = new int[8];
	static int[] arr2 = new int[8];
	static boolean[] visit = new boolean[8];

	static void dfs(int k) {
		if (k == N) {
			int sum = 0;

			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(arr2[i] - arr2[i + 1]);
			}
			result = Math.max(sum, result);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr2[k] = arr[i];
				dfs(k + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		dfs(0);
		System.out.println(result);
	}
}