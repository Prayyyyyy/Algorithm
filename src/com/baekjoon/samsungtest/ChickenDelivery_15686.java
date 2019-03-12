package com.baekjoon.samsungtest;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class ChickenDelivery_15686 {
	static int N; // 도시의 크기
	static int M; // 치킨집 중에 고를 수 있는 최대 개수
	static int result = Integer.MAX_VALUE; // 도시의 치킨 거리의 최솟값
	static int[][] map = new int[50][50]; // 도시의 정보를 저장하는 배열
	static boolean[] visit = new boolean[13]; // 방문 체크 배열
	static ArrayList<Point> houseList = new ArrayList<Point>(); // 집의 좌표를 저장하는 ArrayList
	static ArrayList<Point> storeList = new ArrayList<Point>(); // 치킨집의 좌표를 저장하는 ArrayList

	static void dfs(int start, int cnt, ArrayList<Point> answerList) {
		if (cnt == M) { // 도시 중에 치킨집을 M개를 골랐을 경우
			int dist = 0; // 도시의 치킨 거리
			for (int i = 0; i < houseList.size(); i++) {
				int min_dist = Integer.MAX_VALUE; // 치킨 거리
				Point p1 = new Point(houseList.get(i));
				for (int j = 0; j < answerList.size(); j++) {
					Point p2 = new Point(answerList.get(j));
					min_dist = Math.min(Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y), min_dist); // 집이 선택된 치킨집의 치킨 거리 중에 최솟값을 구한다
				}
				dist += min_dist;
			}
			result = Math.min(result, dist);
			return;
		}

		for (int i = start; i < storeList.size(); i++) {
			if (!visit[i]) { // 방문을 안했을 경우
				visit[i] = true;
				answerList.add(storeList.get(i)); // 방문을 한 치킨집을 answerList에 추가
				dfs(i + 1, cnt + 1, answerList);
				visit[i] = false;
				answerList.remove(answerList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		ArrayList<Point> answerList = new ArrayList<Point>(); // M개 선택한 치킨집의 좌표를 넣을 ArrayList

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] == 1) {
					houseList.add(new Point(i, j));
				}
				if (map[i][j] == 2) {
					storeList.add(new Point(i, j));
				}
			}
		}
		dfs(0, 0, answerList);
		System.out.println(result);
	}
}