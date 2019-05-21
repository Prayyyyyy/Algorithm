package com.swea.difficult2;

import java.util.Scanner;

public class WaterPriceCompetition_1284 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int A_result = 0;
			int B_result = 0;
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();

			A_result = P * W;
			if (W <= R) {
				B_result = Q;
			} else {
				B_result = Q + (S * (W - R));
			}

			if (A_result > B_result) {
				System.out.format("#%d %d\n", t, B_result);
			} else {
				System.out.format("#%d %d\n", t, A_result);
			}
		}
	}
}