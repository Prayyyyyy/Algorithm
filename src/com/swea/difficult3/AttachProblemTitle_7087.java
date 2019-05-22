package com.swea.difficult3;

import java.util.Scanner;

public class AttachProblemTitle_7087 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int result = 0;
			int[] arr = new int[26];

			for (int i = 0; i < N; i++) {
				String st = sc.next();
				arr[st.charAt(0) - 65]++;
			}

			for (int i = 0; i < 26; i++) {
				if (arr[i] != 0) {
					result++;
				} else {
					break;
				}
			}

			System.out.format("#%d %d\n", t, result);
		}
	}
}