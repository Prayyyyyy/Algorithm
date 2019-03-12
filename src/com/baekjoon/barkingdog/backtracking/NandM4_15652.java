package com.baekjoon.barkingdog.backtracking;

import java.util.Scanner;

public class NandM4_15652 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];

		solve(arr, 0);
	}

	static void solve(int[] arr, int k) {
		if (k == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + 1 + " ");
			}
			System.out.println("");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (k > 0 && arr[k - 1] > i) {
				continue;
			}
			arr[k] = i;
			solve(arr, k + 1);
		}
	}
}