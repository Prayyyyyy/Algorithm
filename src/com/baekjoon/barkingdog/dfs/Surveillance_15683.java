//na982님 코드 참고

package com.baekjoon.barkingdog.dfs;

import java.util.Scanner;

class CCTV {
	int x, y, type;

	CCTV(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}

public class Surveillance_15683 {

	static int[] rotateSize = { 4, 2, 4, 4, 1 };
	static int[][] map = new int[8][8];
	static int N, M, result;
	static int cctvSize;
	static CCTV cctv[] = new CCTV[8];

	static void mapCopy(int[][] desc, int[][] src) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				desc[i][j] = src[i][j];
			}
		}
	}

	static void update(int dir, CCTV cctv) {
		dir = (dir % 4);

		if (dir == 0) {
			for (int y = cctv.y + 1; y < M; y++) {
				if (map[cctv.x][y] == 6) {
					break;
				}
				map[cctv.x][y] = -1;
			}
		} else if (dir == 1) {
			for (int x = cctv.x - 1; x >= 0; x--) {
				if (map[x][cctv.y] == 6) {
					break;
				}
				map[x][cctv.y] = -1;
			}
		} else if (dir == 2) {
			for (int y = cctv.y - 1; y >= 0; y--) {
				if (map[cctv.x][y] == 6) {
					break;
				}
				map[cctv.x][y] = -1;
			}
		} else {
			for (int x = cctv.x + 1; x < N; x++) {
				if (map[x][cctv.y] == 6) {
					break;
				}
				map[x][cctv.y] = -1;
			}
		}
	}

	static void dfs(int cctvIndex) {
		if (cctvIndex == cctvSize) {
			int count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						count++;
					}
				}
			}

			result = Math.min(count, result);
			return;
		}

		int[][] backup = new int[8][8];
		int type = cctv[cctvIndex].type;

		for (int dir = 0; dir < rotateSize[type]; dir++) {
			mapCopy(backup, map);

			if (type == 0) {
				update(dir, cctv[cctvIndex]);
			} else if (type == 1) {
				update(dir, cctv[cctvIndex]);
				update(dir + 2, cctv[cctvIndex]);
			} else if (type == 2) {
				update(dir, cctv[cctvIndex]);
				update(dir + 1, cctv[cctvIndex]);
			} else if (type == 3) {
				update(dir, cctv[cctvIndex]);
				update(dir + 1, cctv[cctvIndex]);
				update(dir + 2, cctv[cctvIndex]);
			} else {
				update(dir, cctv[cctvIndex]);
				update(dir + 1, cctv[cctvIndex]);
				update(dir + 2, cctv[cctvIndex]);
				update(dir + 3, cctv[cctvIndex]);
			}

			dfs(cctvIndex + 1);
			mapCopy(map, backup);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		cctvSize = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv[cctvSize] = new CCTV(i, j, map[i][j] - 1);
					cctvSize++;
				}
			}
		}

		result = 100;
		dfs(0);
		System.out.println(result);
	}
}