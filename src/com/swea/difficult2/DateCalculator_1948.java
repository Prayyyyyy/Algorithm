package com.swea.difficult2;

import java.util.Scanner;

public class DateCalculator_1948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			int firstMonth = sc.nextInt();
			int firstDay = sc.nextInt();
			int secondMonth = sc.nextInt();
			int secondDay = sc.nextInt();
			int result = 0;

			if (firstMonth == secondMonth) {
				result = secondDay - firstDay + 1;
			} else {
				int firstDifference = day[firstMonth - 1] - firstDay + 1;
				for (int i = firstMonth; i < secondMonth - 1; i++) {
					result += day[i];
				}
				result = result + firstDifference + secondDay;
			}
			System.out.format("#%d %d\n", t, result);
		}
	}
}