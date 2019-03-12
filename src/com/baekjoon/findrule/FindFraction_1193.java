package com.baekjoon.findrule;

import java.util.Scanner;

public class FindFraction_1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int line = 0, num = 0, top, bottom;

		while (num < N) {
			line++;
			num = line * (line + 1) / 2;
		}

		if (line % 2 == 0) {
			top = line - (num - N);
			bottom = 1 + (num - N);
		} else {
			top = 1 + (num - N);
			bottom = line - (num - N);
		}

		System.out.println(top + "/" + bottom);
	}
}