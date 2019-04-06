package com.swea.difficult2;

import java.util.Scanner;

public class SimplePrimeFactorization_1945 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] num = { 2, 3, 5, 7, 11 };
			int[] count = new int[5];

			while (true) {
				for (int i = 0; i < 5; i++) {
					if (N % num[i] == 0 && N != 0) {
						N /= num[i];
						count[i]++;
					}
				}
				if (N == 1) {
					break;
				}
			}
			System.out.format("#%d ", t);
			for (int i = 0; i < 5; i++) {
				System.out.print(count[i] + " ");
			}
			System.out.println("");
		}
	}
}