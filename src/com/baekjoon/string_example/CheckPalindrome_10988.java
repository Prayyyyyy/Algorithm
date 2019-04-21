package com.baekjoon.string_example;

import java.util.Scanner;

public class CheckPalindrome_10988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.next();
		int result = 1;
		char[] arr = st.toCharArray();
		int size = arr.length / 2;

		for (int i = 0; i < size; i++) {
			if (arr[i] != arr[arr.length - 1 - i]) {
				result = 0;
				break;
			}
		}

		System.out.println(result);
	}
}