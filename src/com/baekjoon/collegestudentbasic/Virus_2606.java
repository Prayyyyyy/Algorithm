package com.baekjoon.collegestudentbasic;

import java.util.Scanner;

public class Virus_2606 {
	static int num, pair, count = 0;
	static int[][] network;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		num = sc.nextInt();
		pair = sc.nextInt();

		network = new int[num + 1][num + 1];
		visit = new boolean[num + 1];

		for (int i = 0; i < pair; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			network[a][b] = network[b][a] = 1;
		}

		solve(1);

		System.out.println(count);
	}

	static void solve(int x) {
		visit[x] = true;

		for (int i = 1; i <= num; i++) {
			if (network[x][i] == 1 && !visit[i]) {
				count++;
				solve(i);
			}
		}
	}
}