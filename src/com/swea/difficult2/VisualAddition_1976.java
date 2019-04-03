package com.swea.difficult2;

import java.util.Scanner;

public class VisualAddition_1976 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int result_hour = 0;
			int result_min = 0;
			int first_hour = sc.nextInt();
			int first_min = sc.nextInt();
			int second_hour = sc.nextInt();
			int second_min = sc.nextInt();

			result_hour = first_hour + second_hour;
			result_min = first_min + second_min;

			if (result_hour > 12) {
				result_hour -= 12;
			}

			if (result_min >= 60) {
				result_min -= 60;
				result_hour++;
				if (result_hour > 12) {
					result_hour -= 12;
				}
			}

			System.out.format("#%d %d %d\n", t, result_hour, result_min);
		}
	}
}