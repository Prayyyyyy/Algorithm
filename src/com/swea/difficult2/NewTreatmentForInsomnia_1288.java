package com.swea.difficult2;

import java.util.Scanner;

public class NewTreatmentForInsomnia_1288 {
	static boolean[] check;

	static void count(int num) {
		while (num > 0) {
			int remainder = num % 10;
			num = num / 10;
			check[remainder] = true;
		}
	}

	static boolean isCheck() {
		for (int i = 0; i < 10; i++) {
			if (!check[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int cnt = 1;
			int result = 0;
			check = new boolean[10];

			while (true) {
				int res = cnt * N;
				count(res);
				cnt++;

				if (isCheck()) {
					result = res;
					break;
				}
			}

			System.out.format("#%d %d\n", t, result);
		}
	}
}