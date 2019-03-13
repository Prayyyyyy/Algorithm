// na982님 코드 참고

package com.baekjoon.samsungtest;

import java.util.Scanner;

public class StartandLink_14889 {
	static int N; // 사람이 몇명인지 나타내는 변수
	static int result = Integer.MAX_VALUE; // 능력치의 차이의 최솟값
	static int[][] ability = new int[20][20]; // 능력치를 저장하는 배열
	static int[] pick = new int[20]; // 선택된 사람을 저장하는 배열
	static int[] start = new int[10]; // 스타트팀에 속한 사람을 저장하는 배열
	static int[] link = new int[10]; // 링크팀에 속한 사람을 저장하는 배열

	static void update() { // 선택이 다 완료된 경우 스타트팀 능력치 합과 링크팀 능력치의 합의 차이를 업데이트
		int start_size = 0, link_size = 0;
		int start_sum = 0, link_sum = 0;
		
		for (int i = 0; i < N; i++) {
			if (pick[i] == 0) { // 선택된 사람의 값이 1일 경우 스타트팀에 배정
				start[start_size++] = i;
			} else { // 선택된 사람의 값이 0일 경우 스타트팀에 배정
				link[link_size++] = i;
			}
		}

		// 이중 for문을 통해 각 팀의 능력치의 합을 구한다.
		for (int i = 0; i < N / 2; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				start_sum += (ability[start[i]][start[j]] + ability[start[j]][start[i]]);
				link_sum += (ability[link[i]][link[j]] + ability[link[j]][link[i]]);
			}
		}

		result = Math.min(result, Math.abs(start_sum - link_sum)); // 최솟값 업데이트
	}

	static void dfs(int index, int count) {
		if (count == (N / 2)) { // 선택이 완료된경우
			update();
			return;
		}

		for (int i = index; i < N; i++) {
			pick[i] = 1;
			dfs(i + 1, count + 1);
			pick[i] = 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ability[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0);
		System.out.println(result);
	}
}