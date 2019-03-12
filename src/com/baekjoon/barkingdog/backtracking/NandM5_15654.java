package com.baekjoon.barkingdog.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class NandM5_15654 {
	static int N, M;
	static int[] arr, arr2;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];
		arr2 = new int[N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr2[i] = sc.nextInt();
		}

		Arrays.sort(arr2);
		solve(arr, visit, 0);
	}

	static void solve(int[] arr, boolean[] visit, int k) {
		if (k == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[k] = arr2[i];

				solve(arr, visit, k + 1);
				visit[i] = false;
			}
		}
	}
}