// na982님 코드 참고

package com.baekjoon.samsungtest;

import java.util.Scanner;

public class Snake_3190 {
	static int N, K, L; // 보드의 크기, 사과의 개수, 뱀의 방향 변환 횟수
	static int head_x, head_y, tail_index; // 뱀 머리의 x,y 좌표, 꼬리의 길이
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[] snake_x = new int[10101]; // 뱀의 위치(x좌표)
	static int[] snake_y = new int[10101]; // 뱀의 위치(y좌표)
	static char[] cmd = new char[10101]; // 방향 변환 명령의 정보
	static int[][] map = new int[101][101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		int x;
		int y;
		for (int i = 0; i < K; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			map[x][y] = 1; // 사과가 있는 좌표를 1로 저장
		}

		int time;
		char ch;
		L = sc.nextInt();
		for (int i = 0; i < L; i++) {
			time = sc.nextInt();
			ch = sc.next().charAt(0);
			cmd[time] = ch; // 해당되는 시간에 방향 변환 정보 저장
		}

		int dir = 0; // 방향
		time = 0;

		// 초기값 설정
		head_x = head_y = 1;
		tail_index = time; // 머리와 꼬리가 동일함
		snake_x[time] = head_x;
		snake_y[time] = head_y;
		map[head_x][head_y] = -1;

		while (true) {
			time++;

			head_x += dx[dir];
			head_y += dy[dir];
			// 뱀의 머리가 벽 또는 자기자신의 몸과 부딪힌 경우
			if (head_x < 1 || head_x > N || head_y < 1 || head_y > N || map[head_x][head_y] == -1) {
				break;
			}

			// 뱀의 이동한 위치 저장
			snake_x[time] = head_x;
			snake_y[time] = head_y;

			if (map[head_x][head_y] == 0) { // 사과가 없을 경우
				int tail_x = snake_x[tail_index]; // 꼬리의 x좌표
				int tail_y = snake_y[tail_index]; // 꼬리의 y좌표
				map[tail_x][tail_y] = 0; // 꼬리가 위치한 부분을 비움
				tail_index++; // 뱀의 위치가 한칸 짧아짐
			}
			map[head_x][head_y] = -1; // 뱀의 머리 부분을 맵에서 -1로 변경

			if (cmd[time] == 'D') { // 오른쪽일 경우
				dir = (dir + 1) % 4;
			}

			if (cmd[time] == 'L') { // 왼쪽일 경우
				dir = (dir + 3) % 4;
			}
		}
		System.out.println(time);
	}
}