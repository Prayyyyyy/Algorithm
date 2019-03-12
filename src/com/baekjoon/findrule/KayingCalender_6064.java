package com.baekjoon.findrule;

import java.util.Scanner;

public class KayingCalender_6064 {
	static int M, N, x, y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			M = sc.nextInt();
			N = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			int tN = 1;
			
			if (N >= x) {
				tN = x;
			} else {
				tN = x % N;
			}
			if (tN == 0) {
				tN = N;
			}

			int first = tN;

			for (int j = x;; j += M) {
				if (tN == y) {
					System.out.println(j);
					break;
				}
				tN += M;
				tN = tN % N;
				if (tN == 0) {
					tN = N;
				}
				if (first == tN) {
					System.out.println(-1);
					break;
				}
			}
		}
	}
}