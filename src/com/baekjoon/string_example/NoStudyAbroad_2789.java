package com.baekjoon.string_example;

import java.util.Scanner;

public class NoStudyAbroad_2789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] alp = { 'C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E' };

		String st = sc.next();
		char[] arr = st.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < alp.length; j++) {
				if (arr[i] == alp[j]) {
					arr[i] = '\0';
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '\0') {
				continue;
			}
			System.out.print(arr[i]);
		}
	}
}