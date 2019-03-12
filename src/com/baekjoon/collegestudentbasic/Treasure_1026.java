package com.baekjoon.collegestudentbasic;

import java.util.Arrays;
import java.util.Scanner;

public class Treasure_1026 {
	static int N, result = 0;
	static int[] arr_A;
	static int[] arr_B;

	static void reverseArray() {
		int temp = 0;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr_B[i] < arr_B[j]) {
					temp = arr_B[i];
					arr_B[i] = arr_B[j];
					arr_B[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr_A = new int[N];
		arr_B = new int[N];

		for (int i = 0; i < N; i++) {
			arr_A[i] = sc.nextInt();
		}
		Arrays.sort(arr_A);

		for (int i = 0; i < N; i++) {
			arr_B[i] = sc.nextInt();
		}

		reverseArray();

		for (int i = 0; i < N; i++) {
			result += arr_A[i] * arr_B[i];
		}

		System.out.println(result);
	}
}