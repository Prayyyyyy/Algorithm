package com.baekjoon.string_example;

import java.util.Scanner;

public class JOIandIOI_5586 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.next();
		int joi = 0;
		int ioi = 0;

		for (int i = 0; i < st.length(); i++) {
			if (i < st.length() - 2) {
				if (st.charAt(i) == 'J' && st.charAt(i + 1) == 'O' && st.charAt(i + 2) == 'I') {
					joi++;
				} else {
					if (st.charAt(i) == 'I' && st.charAt(i + 1) == 'O' && st.charAt(i + 2) == 'I') {
						ioi++;
					}
				}
			}
		}
		System.out.println(joi);
		System.out.println(ioi);
	}
}