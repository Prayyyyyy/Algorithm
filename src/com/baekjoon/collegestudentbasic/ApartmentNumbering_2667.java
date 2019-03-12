package com.baekjoon.collegestudentbasic;

import java.util.Arrays;
import java.util.Scanner;

public class ApartmentNumbering_2667 {
	static int N, count = -1;
	static char[][] map;
	static boolean[][] visit;
	static int[] number;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new char[N][N];
		visit = new boolean[N][N];
		number = new int[N * N];

		for (int i = 0; i < N; i++) {
			String st = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1' && !visit[i][j]) {
					count++;
					number[count]++;
					solve(i, j);
				}
			}
		}

		Arrays.sort(number);
		
		System.out.println(count + 1);
		for (int i = 0; i < number.length; i++) {
			if (number[i] != 0) {
				System.out.println(number[i]);
			}
		}
	}

	static void solve(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == '1') {
				if (!visit[nx][ny]) {
					number[count]++;
					solve(nx, ny);
				}
			}
		}
	}
}