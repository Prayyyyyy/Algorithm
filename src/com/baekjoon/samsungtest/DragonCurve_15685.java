package com.baekjoon.samsungtest;

import java.util.Scanner;

public class DragonCurve_15685 {
	static int N, result = 0;
	static int[][] map = new int[101][101];
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			int curve_size = 0;
			int[] curve = new int[1024];

			int x = sc.nextInt(); // 드래곤 커브의 시작 점 x좌표
			int y = sc.nextInt(); // 드래곤 커브의 시작 점 y좌표
			int d = sc.nextInt(); // 시작 방향
			int g = sc.nextInt(); // 세대

			curve[curve_size++] = d;
			map[y][x] = 1;

			for (int j = 0; j < g; j++) { // 역순으로 방향 체크
				for (int k = curve_size - 1; k >= 0; k--) {
					curve[curve_size++] = (curve[k] + 1) % 4;
				}
			}
			for (int j = 0; j < curve_size; j++) {
				y += dy[curve[j]];
				x += dx[curve[j]];
				if (y < 0 || y >= 101 || x < 0 || x >= 101) {
					continue;
				}
				map[y][x] = 1;
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}