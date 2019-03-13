package com.swea.difficult2;

import java.util.Scanner;

public class PalindromeCheckOfBeginner_1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int result = 0;
			String st = sc.next();
			String[] arr = st.split("");

			for (int i = 0; i < arr.length - 1; i++) {
				int k = arr.length - 1 - i;
				if (arr[i].equals(arr[k])) {
					result = 1;
				} else {
					result = 0;
					break;
				}
			}
			System.out.format("#%d %d\n", t, result);
		}
	}
}