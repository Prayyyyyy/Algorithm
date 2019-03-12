package com.baekjoon.collegestudentbasic;

import java.util.Scanner;

public class ConnectedComponent_11724 {
	static int N, M, count = 0;
	static int[][] graph;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		graph = new int[N + 1][N + 1];
		visit = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u][v] = graph[v][u] = 1;
		}

		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				count++;
				solve(i);
			}
		}

		System.out.println(count);
	}

	static void solve(int x) {
		visit[x] = true;

		for (int i = 1; i <= N; i++) {
			if (graph[x][i] == 1 && !visit[i]) {
				solve(i);
			}
		}
	}
}