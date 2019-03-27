package com.baekjoon.samsungtest;

import java.util.Scanner;

public class InsertOperator_14888 {
	static int N;
	static int[] num_arr = new int[11];
	static int[] op_arr = new int[4];
	static int max_result = Integer.MIN_VALUE;
	static int min_result = Integer.MAX_VALUE;

	static void dfs(int result, int count) {
		if (count == N - 1) {
			max_result = Math.max(max_result, result);
			min_result = Math.min(min_result, result);

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (op_arr[i] != 0) {
				op_arr[i]--;

				if (i == 0) {
					dfs(result + num_arr[count + 1], count + 1);
				} else if (i == 1) {
					dfs(result - num_arr[count + 1], count + 1);
				} else if (i == 2) {
					dfs(result * num_arr[count + 1], count + 1);
				} else {
					dfs(result / num_arr[count + 1], count + 1);
				}

				op_arr[i]++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			num_arr[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			op_arr[i] = sc.nextInt();
		}

		dfs(num_arr[0], 0);

		System.out.println(max_result);
		System.out.println(min_result);
	}
}