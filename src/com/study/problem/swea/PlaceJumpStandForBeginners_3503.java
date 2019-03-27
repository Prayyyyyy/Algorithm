package com.study.problem.swea;

import java.util.Arrays;
import java.util.Scanner;

public class PlaceJumpStandForBeginners_3503 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int result = Integer.MIN_VALUE; // 가장 큰 높이차의 최솟값
			int N = sc.nextInt(); // 점프대의 수 
			int[] arr = new int[N]; // 점프대의 높이를 저장하는 배열
			int[] temp = new int[N]; // 점프대를 재배치하여 저장하는 배열
			int num = N / 2; // 중간값을 저장하는 변수

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr); // 오름차순으로 정렬
			temp[num] = arr[0]; // 재배치하는 배열의 중간 값에 최소 높이의 점프대를 저장

			if (N % 2 == 0) { // N이 짝수일 경우
				temp[0] = arr[N - 1]; // N이 짝수일 경우 재배치할 배열에 첫 번째 값을 따로 저장해야 함 
				for (int i = 1; i < num; i++) {
					int check = 0; // 값을 비교하는 변수

					// 배열의 가운데를 기준으로 왼쪽으로 값을 채워넣음
					temp[num - i] = arr[2 * i - 1];
					check = Math.abs(temp[num - i] - temp[num - i + 1]);
					result = Math.max(check, result);

					// 배열의 가운데를 기준으로 오른쪽으로 값을 채워넣음
					check = 0;
					temp[num + i] = arr[2 * i];
					check = Math.abs(temp[num + i] - temp[num + i - 1]);
					result = Math.max(check, result);
				}
				// 첫 번째 원소를 비교를 안해서 마지막으로 비교
				result = Math.max(result, Math.max(Math.abs(temp[0] - temp[N - 1]), Math.abs(temp[0] - temp[1])));
			} else { // N이 홀수일 경우
				for (int i = 1; i <= num; i++) {
					int check = 0;

					temp[num - i] = arr[2 * i - 1];
					check = Math.abs(temp[num - i] - temp[num - i + 1]);
					result = Math.max(check, result);

					check = 0;
					temp[num + i] = arr[2 * i];
					check = Math.abs(temp[num + i] - temp[num + i - 1]);
					result = Math.max(check, result);
				}
			}
			System.out.format("#%d %d\n", t, result);
		}
	}
}