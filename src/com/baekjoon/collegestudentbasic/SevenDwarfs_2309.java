package com.baekjoon.collegestudentbasic;

import java.util.Arrays;
import java.util.Scanner;

public class SevenDwarfs_2309 {
	static int arr[] = new int[9];
	static boolean visit[] = new boolean[9];
	static boolean flag = false;

	static void dfs(int k, int cnt, int sum) {
		if (flag) {
			return;
		}
		if (cnt == 7) {
			if (sum == 100) {
				int[] result = new int[7];
				for (int i = 0, index = 0; i < 9; i++) {
					if (visit[i]) {
						result[index++] = arr[i];
					}
				}
				Arrays.sort(result);
				for (int i = 0; i < 7; i++) {
					System.out.println(result[i]);
				}
				flag = true;
			}
			return;
		}
		if (k >= 9) {
			return;
		}
		visit[k] = true;
		dfs(k + 1, cnt + 1, sum + arr[k]);
		visit[k] = false;

		dfs(k + 1, cnt, sum);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}

		dfs(0, 0, 0);
	}
}