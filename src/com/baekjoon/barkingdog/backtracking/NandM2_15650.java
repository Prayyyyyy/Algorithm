package com.baekjoon.barkingdog.backtracking;

import java.util.Scanner;

public class NandM2_15650 {
	static int N, M;
	static int[] arr;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];
		visit = new boolean[N];

		solve(arr, visit, 0);
	}

	static void solve(int[] arr, boolean[] visit, int k) {
		if (k == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + 1 + " ");
			}
			System.out.println("");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				if (k > 0 && arr[k - 1] > i) {
					continue;
				}

				visit[i] = true;
				arr[k] = i;
				solve(arr, visit, k + 1);
				visit[i] = false;
			}
		}
	}
}