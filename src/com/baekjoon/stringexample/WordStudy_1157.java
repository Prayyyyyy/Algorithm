package com.baekjoon.stringexample;

import java.util.Scanner;

public class WordStudy_1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.nextLine().toUpperCase();

		int[] arr = new int[26];
		int max = 0;
		char answer = 0;

		for (int i = 0; i < st.length(); i++) {
			arr[st.charAt(i) - 65]++;
			if (arr[st.charAt(i) - 65] > max) {
				answer = st.charAt(i);
				max = arr[st.charAt(i) - 65];
			} else if (max == arr[st.charAt(i) - 65]) {
				answer = '?';
			}
		}
		
		System.out.println(answer);
	}
}