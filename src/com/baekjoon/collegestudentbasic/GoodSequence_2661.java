package com.baekjoon.collegestudentbasic;

import java.util.Scanner;

public class GoodSequence_2661 {
	static int N;
	static boolean check = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		dfs(1, "1");
	}

	static void dfs(int len, String s) {
		if (check) {
			return;
		}

		if (len == N) {
			check = true;
			System.out.println(s);
		} else {
			for (int i = 1; i <= 3; i++) {
				if (checkString(s + i)) {
					dfs(len + 1, s + i);
				}
			}
		}
	}
 
	static boolean checkString(String s) {
		int len = s.length();
		int half = len / 2;
		int start = len - 1;
		int end = len;

		for (int i = 1; i <= half; i++) {
			if (s.substring(start - i, end - i).equals(s.substring(start, end))) {
				return false;
			}
			start--;
		}
		return true;
	}
}