package com.baekjoon.collegestudentbasic;

import java.util.Arrays;
import java.util.Scanner;

public class MakeCode_1759 {
	static int L, C;
	static char[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	static void dfs(int k, int cnt, String st) {
		int idx = arr[k] - 'a';
		visit[idx] = true;

		if (L == cnt) {
			if (isSatisfy()) {
				sb.append(st + "\n");
			}
		} else {
			for (int i = k + 1; i < C; i++) {
				if (!visit[arr[i] - 'a']) {
					dfs(i, cnt + 1, st + arr[i]);
				}
			}
		}
		visit[idx] = false;
	}

	static boolean isSatisfy() {
		int vowel = 0;
		int consonant = 0;

		if (visit[0])
			vowel++;
		if (visit[4])
			vowel++;
		if (visit[8])
			vowel++;
		if (visit[14])
			vowel++;
		if (visit[20])
			vowel++;

		for (int i = 0; i < 26; i++) {
			if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
				continue;
			}

			if (visit[i]) {
				consonant++;
			}
		}

		if (vowel > 0 && consonant > 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		L = sc.nextInt();
		C = sc.nextInt();

		arr = new char[C];

		for (int i = 0; i < C; i++) {
			arr[i] = sc.next().charAt(0);
		}
		Arrays.sort(arr);

		for (int i = 0; i <= C - L; i++) {
			visit = new boolean[26];
			dfs(i, 1, "" + arr[i]);
		}
		System.out.println(sb.toString());
	}
}