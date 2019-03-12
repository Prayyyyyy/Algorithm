package com.baekjoon.barkingdog.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class NandM8_15657 {
	static int N, M;
	static int[] arr, arr2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];
		arr2 = new int[N];

		for (int i = 0; i < N; i++) {
			arr2[i] = sc.nextInt();
		}

		Arrays.sort(arr2);
		solve(arr, 0);
	}

	static void solve(int[] arr, int k) {
		if (k == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (k > 0 && arr[k - 1] > arr2[i]) {
				continue;
			}
			arr[k] = arr2[i];
			solve(arr, k + 1);
		}
	}
}
