package com.baekjoon.string_example;

import java.util.Scanner;

public class Ring_5555 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String ring = sc.next();
		int result = 0;
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String st = sc.next();

			for (int j = 0; j < ring.length() - 1; j++) {
				st = st + st.charAt(j);
			}

			if (st.contains(ring)) {
				result++;
			}
		}

		System.out.println(result);
	}
}