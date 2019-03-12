package com.baekjoon.collegestudentbasic;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399 {
	static int N, result = 0, sum = 0;
	static int[] line;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		line = new int[N];

		for (int i = 0; i < N; i++) {
			line[i] = sc.nextInt();
		}

		Arrays.sort(line);

		for (int i = 0; i < N; i++) {
			sum += line[i];
			result += sum;
		}
		System.out.println(result);
	}
}