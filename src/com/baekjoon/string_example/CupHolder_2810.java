package com.baekjoon.string_example;

import java.util.Scanner;

public class CupHolder_2810 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count = 1;
		String seat = sc.next();

		for (int i = 0; i < N; i++) {
			if (seat.charAt(i) == 'S') { // 일반석인 경우
				count++;
			} else { // 커플석인 경우
				i++;
				count++;
			}
		}

		if (N > count) {
			System.out.println(count);
		} else {
			System.out.println(N);
		}
	}
}