// na982님 코드 참고

package com.study.problem.baekjoon;

import java.util.Scanner;

public class Cogwheel_14891 {
	static char[][] wheel = new char[4][9]; // 톱니바퀴의 정보를 저장하는 배열
	static int K; // 회전 횟수
	static int result = 0; // 네 톱니바퀴의 점수의 합

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			String st = sc.next();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = st.charAt(j);
			}
		}

		K = sc.nextInt();

		while (K != 0) {
			int num = sc.nextInt();
			int dir = sc.nextInt();
			num--;
			K--;

			int[] move_cmd = new int[4];
			move_cmd[num] = dir;

			for (int left = num - 1; left >= 0; left--) {
				int right = left + 1;
				if (wheel[left][2] == wheel[right][6]) {
					break;
				} else {
					move_cmd[left] = move_cmd[right] * -1;
				}
			}

			for (int right = num + 1; right < 4; right++) {
				int left = right - 1;
				if (wheel[left][2] == wheel[right][6]) {
					break;
				} else {
					move_cmd[right] = move_cmd[left] * -1;
				}
			}

			for (int i = 0; i < 4; i++) {
				if (move_cmd[i] == 1) {
					char temp = wheel[i][7];
					for (int j = 7; j >= 1; j--) {
						wheel[i][j] = wheel[i][j - 1];
					}
					wheel[i][0] = temp;
				} else if (move_cmd[i] == -1) {
					char temp = wheel[i][0];
					for (int j = 0; j < 7; j++) {
						wheel[i][j] = wheel[i][j + 1];
					}
					wheel[i][7] = temp;
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			if (wheel[i][0] == '1') {
				if (i == 0) {
					result += 1;
				} else if (i == 1) {
					result += 2;
				} else if (i == 2) {
					result += 4;
				} else {
					result += 8;
				}
			}
		}
		System.out.println(result);
	}
}