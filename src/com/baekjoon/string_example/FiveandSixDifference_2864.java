package com.baekjoon.string_example;

import java.util.Scanner;

public class FiveandSixDifference_2864 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int min = 0;
		int max = 0;
		String A = sc.next();
		String B = sc.next();
		String A_temp = A;
		String B_temp = B;

		// 최솟값
		A_temp = A.replaceAll("6", "5");
		B_temp = B.replaceAll("6", "5");
		min = Integer.parseInt(A_temp) + Integer.parseInt(B_temp);

		// 최댓값
		A_temp = A.replaceAll("5", "6");
		B_temp = B.replaceAll("5", "6");
		max = Integer.parseInt(A_temp) + Integer.parseInt(B_temp);

		System.out.println(min + " " + max);
	}
}