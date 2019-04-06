package com.baekjoon.samsungtest;

import java.util.Scanner;

public class ExamSupervisor_13458 {
	static int N;
	static int B, C;
	static long result;
	static int[] exam = new int[1000000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			exam[i] = sc.nextInt();
		}
		B = sc.nextInt();
		C = sc.nextInt();

		for (int i = 0; i < N; i++) {
			result++;
			exam[i] -= B;

			if (exam[i] > 0) {
				result += Math.ceil(1.0 * exam[i] / C);
			}
		}
		System.out.println(result);
	}
}