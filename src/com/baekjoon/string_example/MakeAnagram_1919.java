package com.baekjoon.string_example;

import java.util.Scanner;

public class MakeAnagram_1919 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.next();
		String st2 = sc.next();
		int result = 0;
		int[] st_arr = new int[26];
		int[] st2_arr = new int[26];

		for (int i = 0; i < st.length(); i++) {
			st_arr[st.charAt(i) - 97]++;
		}
		for (int i = 0; i < st2.length(); i++) {
			st2_arr[st2.charAt(i) - 97]++;
		}
		for (int i = 0; i < 26; i++) {
			if (st_arr[i] != st2_arr[i]) {
				result += Math.abs(st_arr[i] - st2_arr[i]);
			}
		}

		System.out.println(result);
	}
}