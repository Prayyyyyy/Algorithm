package com.baekjoon.string_example;

import java.util.Scanner;

public class CommandPrompt_1032 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int size = 0;
		char[] arr = new char[50];
		char[] result = new char[50];

		for (int i = 0; i < N; i++) {
			String st = sc.next();
			size = st.length();
			if (i == 0) {
				result = st.toCharArray();
				continue;
			} else {
				arr = st.toCharArray();
				for (int j = 0; j < arr.length; j++) {
					if (arr[j] != result[j]) {
						result[j] = '?';
					}
				}
			}
		}
		for (int i = 0; i < size; i++) {
			System.out.print(result[i]);
		}
	}
}