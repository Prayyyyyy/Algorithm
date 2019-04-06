package com.swea.difficult2;

import java.util.Scanner;

public class Decompressing_1946 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int sum = 0;
			int[] num = new int[N];
			char[] alp = new char[N];
			char[][] arr = new char[10][10];

			for (int i = 0; i < N; i++) {
				alp[i] = sc.next().charAt(0);
				num[i] = sc.nextInt();
				sum += num[i];
			}

			int idx = 0;
			int cnt = 0;
			int check = 0;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					arr[i][j] = alp[idx];
					cnt++;
					if (cnt == num[idx]) {
						idx++;
						cnt = 0;
					}
					check++;
					if (check == sum) {
						i = 9;
						break;
					}
				}
			}
			System.out.format("#%d\n", t);
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (arr[i][j] == '\u0000') {
						j = 9;
						i = 9;
						break;
					}
					System.out.print(arr[i][j]);
				}
				System.out.println("");
			}
		}
	}
}