package com.baekjoon.onedimensionalarray;

import java.util.Scanner;

public class NumberofNumbers_2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		int[] count = new int[10];
		int result = A * B * C;

		while (result > 0) {
			count[result % 10]++;
			result /= 10;
		}

		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
	}
}