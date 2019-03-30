package com.study.problem.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class ApartmentNumbering_2667 {
	static int N;
	static int cnt;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] result;
	static int[][] map = new int[25][25];
	static boolean[][] visit = new boolean[25][25];

	static void dfs(int x, int y) { // 단지의 x, y좌표
		visit[x][y] = true; // 방문 체크

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
				if (!visit[nx][ny] && map[nx][ny] == 1) { // 방문하지 않았고 집이 있을 경우
					result[cnt]++; // 연결되어 있으므로 해당되는 단지의 수를 증가
					dfs(nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		result = new int[N * N];
		
		for (int i = 0; i < N; i++) {
			String st = sc.next(); // 문자열으로 입력
			for (int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j) - '0'; // 다시 int형으로 바꿔서 map에 저장
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) { // 집이 있고 방문하지 않을 경우
					result[cnt]++; // 그 단지가 속한 집의 수를 증가
					dfs(i, j); // 연결되어 있는 집 찾기
					cnt++; // 단지수 증가
				}
			}
		}

		Arrays.sort(result); // 오름차순
		System.out.println(cnt);
		for (int i = 0; i < result.length; i++) {
			if (result[i] != 0) { // 0이 아닌 경우만 출력
				System.out.println(result[i]);
			}
		}
	}
}