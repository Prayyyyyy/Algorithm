package com.baekjoon.findrule;

import java.util.Scanner;

public class ACMHotel_10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();

			int count = 1;

			for (int j = 1; j < W + 1; j++) {
				for (int k = 1; k < H + 1; k++) {
					if (count == N) {
						if (j < 10) {
							System.out.println(k + "0" + j);
						} else {
							System.out.println(k + "" + j);
						}
					}
					count++;
				}
			}
		}

	}
}
