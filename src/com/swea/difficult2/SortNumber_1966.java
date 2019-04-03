package com.swea.difficult2;

import java.util.Arrays;
import java.util.Scanner;

public class SortNumber_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);

			System.out.format("#%d ", t);
			for (int i = 0; i < N; i++) {
				System.out.format("%d ", arr[i]);
			}
			System.out.println("");
		}
	}
}