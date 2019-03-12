package com.baekjoon.collegestudentbasic;

import java.util.ArrayList;
import java.util.Scanner;

public class StrictInequality_2529 {
	static int N;
	static ArrayList<String> list = new ArrayList<String>();
	static boolean[] visit = new boolean[10];
	static String[] sign;

	static void dfs(int k, int cnt, String st) {
		if (cnt == N) {
			list.add(st);
		} else {
			for (int i = 0; i <= 9; i++) {
				if (!visit[i]) {
					if (sign[cnt].equals("<")) {
						if (k >= i) {
							continue;
						}
					} else {
						if (k <= i) {
							continue;
						}
					}
					visit[i] = true;
					dfs(i, cnt + 1, st + i);
				}
			}
		}
		visit[k] = false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		sc.nextLine();
		sign = sc.nextLine().split(" ");

		for (int i = 0; i <= 9; i++) {
			visit[i] = true;
			dfs(i, 0, i + "");
		}
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));
	}
}