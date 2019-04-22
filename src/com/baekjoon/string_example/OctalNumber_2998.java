package com.baekjoon.string_example;

import java.util.Scanner;

public class OctalNumber_2998 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.next();
		String result = "";

		if (st.length() % 3 == 1) {
			st = "00" + st;
		} else if (st.length() % 3 == 2) {
			st = "0" + st;
		}

		for (int i = 0; i < st.length() - 2; i += 3) {
			if (st.charAt(i) == '0' && st.charAt(i + 1) == '0' && st.charAt(i + 2) == '0') {
				result = result + "0";
			} else if (st.charAt(i) == '0' && st.charAt(i + 1) == '0' && st.charAt(i + 2) == '1') {
				result = result + "1";
			} else if (st.charAt(i) == '0' && st.charAt(i + 1) == '1' && st.charAt(i + 2) == '0') {
				result = result + "2";
			} else if (st.charAt(i) == '0' && st.charAt(i + 1) == '1' && st.charAt(i + 2) == '1') {
				result = result + "3";
			} else if (st.charAt(i) == '1' && st.charAt(i + 1) == '0' && st.charAt(i + 2) == '0') {
				result = result + "4";
			} else if (st.charAt(i) == '1' && st.charAt(i + 1) == '0' && st.charAt(i + 2) == '1') {
				result = result + "5";
			} else if (st.charAt(i) == '1' && st.charAt(i + 1) == '1' && st.charAt(i + 2) == '0') {
				result = result + "6";
			} else {
				result = result + "7";
			}
		}

		System.out.println(result);
	}
}