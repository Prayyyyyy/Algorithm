package com.study.problem.baekjoon;

import java.util.Scanner;

public class IntelligentTrain_2455 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int result = 0;

		for (int i = 0; i < 4; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int candi = 0;

			if (i == 0) {
				candi = b;
			} else {
				candi = result - a + b;
			}
			result = Math.max(result, candi);
		}

		System.out.println(result);
	}
}