// na982님 코드 참고

package com.baekjoon.samsungtest;

import java.util.Scanner;

public class Tetromino_14500 {
	static int N, M;
	static int result;
	static int[][] map = new int[503][503];
	static int[][][] block = {
			{
				{1,1,1,1},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
			},
			{
				{1,0,0,0},
				{1,0,0,0},
				{1,0,0,0},
				{1,0,0,0}
			},
			{
				{1,1,0,0},
				{1,1,0,0},
				{0,0,0,0},
				{0,0,0,0}
			},
			{
				{1,0,0,0},
				{1,0,0,0},
				{1,1,0,0},
				{0,0,0,0}
			},
			{
				{1,1,1,0},
				{1,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
			},
			{
				{1,1,0,0},
				{0,1,0,0},
				{0,1,0,0},
				{0,0,0,0}
			},
			{
				{0,0,1,0},
				{1,1,1,0},
				{0,0,0,0},
				{0,0,0,0}
			},
			{
				{0,1,0,0},
				{0,1,0,0},
				{1,1,0,0},
				{0,0,0,0}
			},
			{
				{1,0,0,0},
				{1,1,1,0},
				{0,0,0,0},
				{0,0,0,0}
			},
			{
				{1,1,0,0},
				{1,0,0,0},
				{1,0,0,0},
				{0,0,0,0}
			},
			{
				{1,1,1,0},
				{0,0,1,0},
				{0,0,0,0},
				{0,0,0,0}
			},
			{
				{1,0,0,0},
				{1,1,0,0},
				{0,1,0,0},
				{0,0,0,0},
			},
			{
				{0,1,1,0},
				{1,1,0,0},
				{0,0,0,0},
				{0,0,0,0}
			},
			{
				{0,1,0,0},
				{1,1,0,0},
				{1,0,0,0},
				{0,0,0,0}
			},
			{
				{1,1,0,0},
				{0,1,1,0},
				{0,0,0,0},
				{0,0,0,0}
			},
			{
				{1,1,1,0},
				{0,1,0,0},
				{0,0,0,0},
				{0,0,0,0}
			},
			{
				{0,1,0,0},
				{1,1,0,0},
				{0,1,0,0},
				{0,0,0,0},
			},
			{
				{0,1,0,0},
				{1,1,1,0},
				{0,0,0,0},
				{0,0,0,0}
			},
			{
				{1,0,0,0},
				{1,1,0,0},
				{1,0,0,0},
				{0,0,0,0}
			}
	};
	
	static int check(int x, int y, int idx) {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				sum += ((block[idx][i][j])) * map[x + i][y + j];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = N; i < N + 3; i++) {
			for (int j = 0; j < M + 3; j++) {
				map[i][j] = -10000;
			}
		}
		for (int i = 0; i < N + 3; i++) {
			for (int j = M; j < M + 3; j++) {
				map[i][j] = -10000;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int idx = 0; idx < 19; idx++) {
					int temp = check(i, j, idx);
					result = Math.max(result, temp);
				}
			}
		}
		System.out.println(result);
	}
}