package com.baekjoon.collegestudentbasic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFSandBFS_1260 {
	static int N, M, V;
	static int[][] graph;
	static boolean[] visit;

	static void dfs(int start) {
		visit[start] = true;
		System.out.print(start + " ");

		for (int i = 1; i <= N; i++) {
			if (graph[start][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}

	static void bfs() {
		Queue<Integer> qu = new LinkedList<>();

		qu.add(V);
		visit[V] = true;

		while (!qu.isEmpty()) {
			int p = qu.poll();

			for (int i = 1; i <= N; i++) {
				if (graph[p][i] == 1 && !visit[i]) {
					visit[i] = true;
					qu.add(i);
				}
			}
			System.out.print(p + " ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		graph = new int[N + 1][N + 1];
		visit = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			graph[x][y] = graph[y][x] = 1;
		}

		dfs(V);
		visit = new boolean[N + 1];
		System.out.println("");
		bfs();
	}
}