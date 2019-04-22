package com.baekjoon.string_example;

import java.util.Scanner;

public class CaesarCode_5598 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.next();
		char[] arr = st.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 'D') {
				arr[i] += 23;
			} else {
				arr[i] -= 3;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}