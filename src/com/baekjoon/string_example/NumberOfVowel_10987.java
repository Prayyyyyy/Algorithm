package com.baekjoon.string_example;

import java.util.Scanner;

public class NumberOfVowel_10987 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.next();
		int result = 0;

		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) == 'a' || st.charAt(i) == 'e' || st.charAt(i) == 'i' || st.charAt(i) == 'o'
					|| st.charAt(i) == 'u') {
				result++;
			}
		}

		System.out.println(result);
	}
}