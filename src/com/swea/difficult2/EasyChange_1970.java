package com.swea.difficult2;

import java.util.Scanner;

public class EasyChange_1970 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int[] change = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
			int N = sc.nextInt();

			System.out.println("#" + t);

			for (int i : change) {
				System.out.format("%d ", N / i);
				N %= i;
			}
			System.out.println("");
		}
	}
}