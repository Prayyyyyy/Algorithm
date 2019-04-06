package com.baekjoon.samsungtest;

import java.util.Scanner;

class Dice {
	int x;
	int y;
	int top, bottom;
	int left, right;
	int front, back;

	Dice(int x, int y, int top, int bottom, int left, int right, int front, int back) {
		this.x = x;
		this.y = y;
		this.top = top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
		this.front = front;
		this.back = back;
	}
}

public class DiceSpinning_14499 {
	static int N, M;
	static int x, y;
	static int k;
	static int[] count;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map = new int[20][20];
	static Dice dice;

	static boolean isCheck() { // 범위체크
		if (dice.x >= 0 && dice.x < N && dice.y >= 0 && dice.y < M) {
			return true;
		}
		return false;
	}

	static boolean update(int idx) {
		int temp = 0;
		if (count[idx] == 1) { // 동쪽으로 이동할 경우
			dice.x += dx[0];
			dice.y += dy[0];
			if (!isCheck()) { // 지도를 벗어난 경우 다시 주사위를 원래 위치로 복귀
				dice.x -= dx[0];
				dice.y -= dy[0];
				return false;
			}
			// 주사위가 이동한만큼 해당되는 면의 값 이동
			temp = dice.top;
			dice.top = dice.left;
			dice.left = dice.bottom;
			dice.bottom = dice.right;
			dice.right = temp;

		} else if (count[idx] == 2) { // 서쪽으로 이동할 경우
			dice.x += dx[1];
			dice.y += dy[1];
			if (!isCheck()) {
				dice.x -= dx[1];
				dice.y -= dy[1];
				return false;
			}
			temp = dice.top;
			dice.top = dice.right;
			dice.right = dice.bottom;
			dice.bottom = dice.left;
			dice.left = temp;

		} else if (count[idx] == 3) { // 북쪽으로 이동할 경우
			dice.x += dx[2];
			dice.y += dy[2];
			if (!isCheck()) {
				dice.x -= dx[2];
				dice.y -= dy[2];
				return false;

			}
			temp = dice.top;
			dice.top = dice.front;
			dice.front = dice.bottom;
			dice.bottom = dice.back;
			dice.back = temp;

		} else { // 남쪽을으로 이동할 경우
			dice.x += dx[3];
			dice.y += dy[3];
			if (!isCheck()) {
				dice.x -= dx[3];
				dice.y -= dy[3];
				return false;
			}
			temp = dice.top;
			dice.top = dice.back;
			dice.back = dice.bottom;
			dice.bottom = dice.front;
			dice.front = temp;
		}

		if (map[dice.x][dice.y] == 0) { // 이동한 칸이 0인 경우
			map[dice.x][dice.y] = dice.bottom;
		} else { // 이동한 칸이 0이 아닌 경우
			dice.bottom = map[dice.x][dice.y];
			map[dice.x][dice.y] = 0;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		k = sc.nextInt();

		count = new int[k];
		dice = new Dice(x, y, 0, 0, 0, 0, 0, 0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < k; i++) {
			count[i] = sc.nextInt();
		}

		for (int i = 0; i < k; i++) {
			if (!update(i)) { // 범위를 벗어난 경우 무시
				continue;
			}
			System.out.println(dice.top);
		}
	}
}