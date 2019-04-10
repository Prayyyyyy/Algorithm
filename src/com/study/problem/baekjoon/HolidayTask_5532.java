package com.study.problem.baekjoon;

import java.util.Scanner;

public class HolidayTask_5532 {
	static int L, B, A, C, D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		L = sc.nextInt(); // 총 방학일 수
		A = sc.nextInt(); // 국어 총 페이지
		B = sc.nextInt(); // 수학 총 페이지
		C = sc.nextInt(); // 국어 최대 페이지
		D = sc.nextInt(); // 수학 최대 페이지

		int math = 0;
		int kor = 0;
		int result = 0;

		if (A % C == 0) {
			kor = A / C;
		} else {
			kor = (A / C) + 1;
		}

		if (B % D == 0) {
			math = B / D;
		} else {
			math = (B / D) + 1;
		}

		result = Math.max(kor, math);
		if (L - result < 0) {
			result = 0;
		} else {
			result = L - result;
		}
		System.out.println(result);
	}
}