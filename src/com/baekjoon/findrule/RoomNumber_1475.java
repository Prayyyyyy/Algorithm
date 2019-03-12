package com.baekjoon.findrule;

import java.util.Scanner;

public class RoomNumber_1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int result, i = 0, count = 0, max = 0;
		int[] arr = new int[10];

		if (N == 0) {
			arr[0]++;
		} else {
			while (N > 0) {
				result = N % 10;
				N /= 10;
				arr[result]++;
				i++;
			}
		}

		count = arr[6] + arr[9];

		if (count % 2 == 0) {
			arr[6] = count / 2;
			arr[9] = count / 2;
		} else {
			arr[6] = (count / 2) + 1;
			arr[9] = (count / 2) + 1;
		}

		max = arr[0];
		for (int j = 1; j < 10; j++) {
			if (max < arr[j]) {
				max = arr[j];
			}
		}

		System.out.println(max);
	}
}