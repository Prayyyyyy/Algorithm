package com.baekjoon.samsungtest;

import java.util.Scanner;

class Fish { // 상어의 좌표, 속도, 방향, 크기를 저장하는 클래스
	int x;
	int y;
	int speed;
	int dir;
	int size;

	Fish(int x, int y, int speed, int dir, int size) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.dir = dir;
		this.size = size;
	}
}

public class FishingKing_17143 {
	static int R, C, M, result; // 행, 열, 상어의 수, 결과값
	static int[][] map = new int[101][101]; // 원본 배열
	static int[][] moveMap = new int[101][101]; // 상어를 이동시키고 저장한 배열
	static Fish[] fish = new Fish[10001];
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };

	static void kill(int y) { // 낚시왕이 상어를 잡는 메소드
		for (int x = 1; x <= R; x++) {
			if (map[x][y] != 0) { // 상어가 존재할 경우
				result += fish[map[x][y]].size;
				fish[map[x][y]].x = -1;
				fish[map[x][y]].y = -1;
				fish[map[x][y]].size = 0;
				map[x][y] = 0;
				break;
			}
		}
	}

	static void move(int idx) { // 상어를 이동시키는 메소드
		int nx = fish[idx].x;
		int ny = fish[idx].y;
		int speed = fish[idx].speed;
		int dir = fish[idx].dir;
		int size = fish[idx].size;

		for (int i = 0; i < speed; i++) {
			if (nx + dx[dir] <= 0 || nx + dx[dir] > R || ny + dy[dir] <= 0 || ny + dy[dir] > C) { // 좌표를 벗어난 경우 방향 변환
				if (dir == 1) {
					dir = 2;
				} else if (dir == 2) {
					dir = 1;
				} else if (dir == 3) {
					dir = 4;
				} else {
					dir = 3;
				}
				nx += dx[dir];
				ny += dy[dir];
			} else {
				nx += dx[dir];
				ny += dy[dir];
			}
		}

		if (moveMap[nx][ny] != 0) { // 상어가 이동한 곳에 다른 상어가 있을 경우
			if (size > fish[moveMap[nx][ny]].size) { // 새로 이동한 상어의 크기가 더 클 경우
				fish[moveMap[nx][ny]].x = -1;
				fish[moveMap[nx][ny]].y = -1;
				fish[moveMap[nx][ny]].size = 0;
				fish[idx].x = nx;
				fish[idx].y = ny;
				fish[idx].dir = dir;
				moveMap[nx][ny] = idx;
			} else { // 원래 있던 상어의 크기가 더 클 경우
				fish[idx].x = -1;
				fish[idx].y = -1;
				fish[idx].size = 0;
			}
		} else { // 상어가 이동한 곳에 다른 상어가 없을 경우
			moveMap[nx][ny] = idx;
			fish[idx].x = nx;
			fish[idx].y = ny;
			fish[idx].dir = dir;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();

		for (int i = 1; i <= M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();

			fish[i] = new Fish(r, c, s, d, z); // 배열에다가 상어를 저장
			map[r][c] = i; // 상어의 위치에 인덱스를 저장
		}
		for (int i = 1; i <= C; i++) { // 낚시군이 1번 열부터 가장 오른쪽 열까지 이동
			kill(i);

			for (int j = 1; j <= M; j++) { // 상어를 차례대로 이동
				if (fish[j].size == 0) { // 상어가 잡혀서 없어진 경우는 제외
					continue;
				} else {
					move(j);
				}
			}
			for (int j = 1; j <= R; j++) { // 이동한 상어를 원본 배열에 저장
				for (int k = 1; k <= C; k++) {
					map[j][k] = moveMap[j][k];
				}
			}
			moveMap = new int[101][101]; // 초기화
		}

		if (M == 0) { // 상어가 없을 경우
			result = 0;
		}
		System.out.println(result);
	}
}