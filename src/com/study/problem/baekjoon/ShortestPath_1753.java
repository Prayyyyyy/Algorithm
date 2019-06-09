package com.study.problem.baekjoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int dest; // 간선의 목적지
	int weight; // 간선의 가중치

	Edge(int dest, int weight) {
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge e) {
		// TODO Auto-generated method stub
		return this.weight - e.weight;
	}
}

public class ShortestPath_1753 {
	static int V, E, K; // 정점의 개수, 간선의 개수, 시작점의 번호
	static int[] dist; // 시작점에서 정점까지의 최단 경로를 저장하는 배열
	static boolean[] visit; // 각 정점의 방문여부를 체크하는 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();

		dist = new int[V + 1];
		visit = new boolean[V + 1];
		
		// 각 정점의 연결된 간선을 저장
		ArrayList<Edge>[] edge = (ArrayList<Edge>[]) new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE; // 모든 정점에 최댓값을 저장
			edge[i] = new ArrayList<Edge>(); // 해당되는 정점에 ArrayList 생성
		}
		dist[K] = 0; // 시작점의 길이는 무조건 0

		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();

			edge[u].add(new Edge(v, w)); // 간선 추가
		}

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); // 우선순위 큐
		pq.offer(new Edge(K, 0)); // 시작점을 큐에 넣음

		while (!pq.isEmpty()) {
			Edge cur = pq.poll(); // 우선순위 큐이므로 가중치가 가장 낮은 것을 pop
			if (visit[cur.dest]) { // 이미 방문한 정점일 경우
				continue;
			}

			visit[cur.dest] = true;
			for (Edge i : edge[cur.dest]) {
				if (!visit[i.dest]) { // 방문하지 않은 정점일 경우
					dist[i.dest] = Math.min(dist[i.dest], (dist[cur.dest] + i.weight)); // 저장되어있는 거리와 새로운 거리를 비교
					pq.offer(new Edge(i.dest, dist[i.dest]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) { // 경로가 존재하지 않는 경우
				System.out.println("INF");
			} else { // 경로가 존재한 경우
				System.out.println(dist[i]);
			}
		}
	}
}