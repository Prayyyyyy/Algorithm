// na982님 코드 참고

package com.baekjoon.samsungtest;

import java.util.Scanner;

public class Steep_14890 {
	static int N; // 지도의 크기
	static int L; // 경사로의 길이
	static int result; // 지나갈 수 있는 길의 개수
	static int[][] map = new int[200][100]; // 원래 지도의 크기는 100*100인데 지도를 90도 회전시킨 후 밑으로 합치기 위해서 200*100으로 설정

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[j + N][i] = map[i][j];
			}
		}

		int i, j; // for문에 들어갈 변수
		int count = 0; // 유효성을 판단하는 변수

		for (i = 0; i < 2 * N; i++) {
			count = 1; // 한 행을 돌때마다 1로 초기화
			for (j = 0; j < N - 1; j++) {
				if (map[i][j] == map[i][j + 1]) { // 평지일 경우
					count++;
				} else if (map[i][j] + 1 == map[i][j + 1] && count >= L) { // 오르막길일 경우
					count = 1;
				} else if (map[i][j] - 1 == map[i][j + 1] && count >= 0) { // 내리막길일 경우
					count = (1 - L);
				} else {
					break;
				}
			}
			if (j == N - 1 && count >= 0) { // 한 행을 다 돌았고 count 변수가 0 이상일때만 개수 증가
				result++;
			}
		}
		System.out.println(result);
	}
}