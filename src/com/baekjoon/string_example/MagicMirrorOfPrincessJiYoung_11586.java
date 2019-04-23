package com.baekjoon.string_example;

import java.util.Scanner;

public class MagicMirrorOfPrincessJiYoung_11586 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		char[][] mirror = new char[100][100];

		for (int i = 0; i < N; i++) {
			String st = sc.next();
			for (int j = 0; j < N; j++) {
				mirror[i][j] = st.charAt(j);
			}
		}

		int state = sc.nextInt();

		if (state == 1) { // 그대로
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(mirror[i][j]);
				}
				System.out.println("");
			}
		} else if (state == 2) { // 좌우 반전
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					System.out.print(mirror[i][j]);
				}
				System.out.println("");
			}
		} else { // 상하 반전
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					System.out.print(mirror[i][j]);
				}
				System.out.println("");
			}
		}

	}
}