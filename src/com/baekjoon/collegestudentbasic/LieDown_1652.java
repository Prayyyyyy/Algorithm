package com.baekjoon.collegestudentbasic;

import java.util.Scanner;

public class LieDown_1652 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String[] input = new String[N];
		char[][] room = new char[N][N];
		boolean check = false;
		int count_row = 0, count_col = 0, len = 0;

		for (int i = 0; i < N; i++) {
			input[i] = sc.next();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				room[i][j] = input[i].charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (room[i][j] == '.') {
					len++;
					if (len == 2) {
						count_row++;
					}
				} else {
					len = 0;
				}
			}
			len = 0;
		}

		len = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (room[j][i] == '.') {
					len++;
					if (len == 2) {
						count_col++;
					}
				} else {
					len = 0;
				}
			}
			len = 0;
		}
		System.out.println(count_row + " " + count_col);
	}
}