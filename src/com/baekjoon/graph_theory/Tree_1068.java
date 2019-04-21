package com.baekjoon.graph_theory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree_1068 {
	static int N, result;
	static ArrayList<Integer>[] tree = (ArrayList<Integer>[]) new ArrayList[51];
	static boolean[] visit = new boolean[50];
	static int[] parent = new int[50];

	static void bfs(int remove) {
		Queue<Integer> qu = new LinkedList<>();
		result = 0;

		if (visit[remove]) {
			return;
		}

		qu.add(remove);
		visit[remove] = true;

		while (!qu.isEmpty()) {
			remove = qu.poll();
			boolean check = false;

			for (int i : tree[remove]) {
				if (!visit[i] && parent[remove] != i) { // 방문하지 않았고 부모정점과 현재 정점이 다른 경우
					check = true;
					qu.add(i);
					visit[i] = true;
				}
			}
			if (!check) { // 정점을 기준으로 탐색을 하지 못한 경우
				result++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) { // 입력받은 데이터의 부모를 배열에 저장
			int data = sc.nextInt();
			parent[i] = data;
		}

		int root = 0;
		for (int i = 0; i < N; i++) { // 인접리스트 생성
			int data = parent[i];

			if (data == -1) { // 부모가 -1인 경우(root인 경우)
				root = i;
				continue;
			}

			tree[data].add(i);
			tree[i].add(data);
		}

		int remove = sc.nextInt();
		bfs(remove); // 제거할 노드의 자식들 제거
		bfs(root); // 리프노드 탐색
		System.out.println(result);
	}
}