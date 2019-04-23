package com.baekjoon.string_example;

import java.util.Scanner;

public class Blind_2799 {
	static int N, M;
	static int[] result = new int[5]; // 블라인드 타입의 개수를 저장하는 배열
	static char[][] apt = new char[501][501]; // 아파트의 상태
	static char[][][] window = { // 창문의 5가지 형태
			{ { '.', '.', '.', '.' }, { '.', '.', '.', '.' }, { '.', '.', '.', '.' }, { '.', '.', '.', '.' } },
			{ { '*', '*', '*', '*' }, { '.', '.', '.', '.' }, { '.', '.', '.', '.' }, { '.', '.', '.', '.' } },
			{ { '*', '*', '*', '*' }, { '*', '*', '*', '*' }, { '.', '.', '.', '.' }, { '.', '.', '.', '.' } },
			{ { '*', '*', '*', '*' }, { '*', '*', '*', '*' }, { '*', '*', '*', '*' }, { '.', '.', '.', '.' } },
			{ { '*', '*', '*', '*' }, { '*', '*', '*', '*' }, { '*', '*', '*', '*' }, { '*', '*', '*', '*' }, } };

	static boolean check(int x, int y, int idx) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (window[idx][i][j] != apt[i + x][j + y]) { // 일치하지않은 경우
					return false;
				}
			}
		}
		// 일치하는 경우
		return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		for (int i = 0; i < (5 * M) + 1; i++) {
			String st = sc.next();
			for (int j = 0; j < (5 * N) + 1; j++) {
				apt[i][j] = st.charAt(j);
			}
		}

		for (int i = 1; i < (5 * M) + 1; i += 5) {
			for (int j = 1; j < (5 * N) + 1; j += 5) {
				for (int idx = 0; idx < 5; idx++) {
					if (check(i, j, idx)) { // 일치한 경우
						result[idx]++;
						break;
					}
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.print(result[i] + " ");
		}
	}
}