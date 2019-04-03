// na982님 코드 참고

package com.baekjoon.samsungtest;

import java.util.Scanner;

public class Resignation_14501 {
	static int N;
	static int result;
	static int[] T = new int[15];
	static int[] P = new int[15];

	static int solve(int day) {
		if (day > N) {
			return Integer.MIN_VALUE;
		} else if (day == N) {
			return 0;
		} else {
			result = Math.max(solve(day + 1), solve(day + T[day]) + P[day]);
			return result;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}

		result = solve(0);
		System.out.println(result);
	}
}