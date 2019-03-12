package com.baekjoon.samsungtest;

import java.util.Scanner;

class Wheel {
	int index; // 톱니바퀴의 번호
	String[] arr = new String[9]; // 톱니바퀴를 저장할 배열

	Wheel(int index, String[] arr) {
		this.index = index;
		this.arr = arr;
	}
}

public class Cogwheel_14891 {
	static Wheel wheel[] = new Wheel[4]; // 톱니바퀴의 정보를 저장하는 배열
	static int K; // 회전 횟수
	static int result = 0; // 네 톱니바퀴의 점수의 합

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			String st = sc.next();
			wheel[i] = new Wheel(i, st.split(""));
		}

		K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int num = sc.nextInt();
			int dir = sc.nextInt();
			num--;

			int move_wheel[] = new int[4]; // 이동하는 톱니바퀴를 저장하는 배열
			move_wheel[num] = dir;
			for (int left = num - 1; left >= 0; left--) { // 선택이 된 톱니바뷔의 왼쪽 탐색
				int right = left + 1;
				if (wheel[left].arr[2].equals(wheel[right].arr[6])) {
					break;
				} else {
					move_wheel[left] = move_wheel[right] * -1;
				}
			}

			for (int right = num + 1; right < 4; right++) { // 선택이 된 톱니바뷔의 오른쪽 탐색
				int left = right - 1;
				if (wheel[left].arr[2].equals(wheel[right].arr[6])) {
					break;
				} else {
					move_wheel[right] = move_wheel[left] * -1;
				}
			}

			String st = "";
			for (int idx = 0; idx < 4; idx++) {
				if (move_wheel[idx] == 1) { // 시계방향으로 Shift
					st = wheel[idx].arr[7];
					for (int j = 7; j >= 1; j--) {
						wheel[idx].arr[j] = wheel[idx].arr[j - 1];
					}
					wheel[idx].arr[0] = st;
				} else if (move_wheel[idx] == -1) { // 반시계방향으로 Shift
					st = wheel[idx].arr[0];
					for (int j = 0; j <= 6; j++) {
						wheel[idx].arr[j] = wheel[idx].arr[j + 1];
					}
					wheel[idx].arr[7] = st;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			if (wheel[i].arr[0].equals("1")) {
				switch (i) {
				case 0:
					result += 1;
					break;
				case 1:
					result += 2;
					break;
				case 2:
					result += 4;
					break;
				case 3:
					result += 8;
					break;
				}
			}
		}
		System.out.println(result);
	}
}