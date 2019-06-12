package com.study.problem.baekjoon;

import java.util.Scanner;

public class Ball_1547 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		boolean[] check = new boolean[4];
		check[1] = true;

		for (int i = 0; i < M; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();

			if (check[X]) {
				check[Y] = true;
				check[X] = false;
				continue;
			}

			if (check[Y]) {
				check[X] = true;
				check[Y] = false;
				continue;
			}
		}
		for (int i = 1; i < 4; i++) {
			if (check[i]) {
				System.out.println(i);
			}
		}
	}
}