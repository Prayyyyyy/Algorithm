package com.baekjoon.stringexample;

import java.util.Scanner;

public class GroupWordChecker_1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] st = new String[N];
		int count = 0, result = 0;

		for (int i = 0; i < N; i++) {
			st[i] = sc.next();
			char[] arr = st[i].toCharArray();

			for (int j = 0; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[j] == arr[k] && arr[j] != arr[k - 1]) {
						count = 1;
					}
				}
			}
			if (count == 0) {
				result++;
			}
			count = 0;
		}
		System.out.println(result);
	}
}