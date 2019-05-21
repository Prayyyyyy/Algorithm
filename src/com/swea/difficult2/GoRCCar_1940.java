package com.swea.difficult2;

import java.util.Scanner;

public class GoRCCar_1940 {
	static int dir, car;

	static void move(int cmd, int speed) {
		if (cmd == 1) {
			car += speed;
		} else {
			if (car < speed) {
				car = 0;
			} else {
				car -= speed;
			}
		}
		dir += car;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			dir = car = 0;
			for (int i = 0; i < N; i++) {
				int cmd = sc.nextInt();
				if (cmd != 0) {
					int speed = sc.nextInt();
					move(cmd, speed);
				} else {
					dir += car;
				}
			}
			System.out.format("#%d %d\n", t, dir);
		}
	}
}