package com.baekjoon.string_example;

import java.util.Scanner;

public class WhiteSpace_1100 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] board = new char[8][8];
		int result = 0;

		for (int i = 0; i < 8; i++) {
			String st = sc.next();
			for (int j = 0; j < 8; j++) {
				board[i][j] = st.charAt(j);

				if (i % 2 == 0 && j % 2 == 0) {
					if (board[i][j] == 'F') {
						result++;
					}
				}

				if (i % 2 == 1 && j % 2 == 1) {
					if (board[i][j] == 'F') {
						result++;
					}
				}
			}
		}

		System.out.println(result);
	}
}