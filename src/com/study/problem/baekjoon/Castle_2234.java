package com.study.problem.baekjoon;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class room { // 각 좌표의 방 크기와 방 번호를 나타내는 클래스
	int size;
	int num;

	room(int size, int num) {
		this.size = size;
		this.num = num;
	}
}

public class Castle_2234 {
	static int M, N;
	static int num, max, sum; // 방의 개수, 가장 넓은 방의 넓이, 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Point> qu; // 방의 넓이를 구할 때 쓰는 큐
	static Queue<Point> qu2; // 각 좌표에 속한 방 크기, 방 번호를 구할 때 쓰는 큐
	static int[][] map = new int[50][50]; // 벽에 대한 정보를 저장하는 배열
	static room[][] info = new room[50][50]; // 좌표에 대한 크기, 번호를 저장하는 배열
	static boolean[][] visit = new boolean[50][50]; // 방문체크

	static int bfs(int x, int y) {
		qu = new LinkedList<Point>();
		qu.add(new Point(x, y));
		qu2.add(new Point(x, y));
		visit[x][y] = true; // 방문 표시
		int area = 0; // 방의 넓이

		while (!qu.isEmpty()) {
			Point cur = qu.poll();
			area++;

			// 10진수를 2진수로 바꿈(네자리로 다 맞춤)
			String st = String.format("%04d", Integer.parseInt(Integer.toBinaryString(map[cur.x][cur.y]).toString()));

			for (int dir = 0; dir < 4; dir++) {
				if (st.charAt(dir) == '0') { // 벽이 아닐 경우
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];

					if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visit[nx][ny]) { // 범위 체크 및 방문을 안한 경우
						visit[nx][ny] = true; // 방문 표시
						qu.add(new Point(nx, ny));
						qu2.add(new Point(nx, ny));
					}
				}
			}
		}
		return area; // 방의 넓이를 리턴
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				info[i][j] = new room(0, 0); // 초기화
			}
		}

		qu2 = new LinkedList<Point>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 15) { // 벽으로 다 둘러쌓인 경우
					num++; // 방의 개수 증가
					info[i][j].num = num; // 해당 좌표의 방 번호 저장
					info[i][j].size = 1; // 해당 좌표의 방 사이즈를 1로 저장
					max = Math.max(1, max); // 모든 방의 크기가 1인 경우 대비
					continue;
				} else {
					if (!visit[i][j]) { // 방문하지 않은 경우
						num++; // 방의 개수 증가
						int candi = bfs(i, j); // bfs()를 통해 방의 넓이 구하기
						max = Math.max(candi, max); // 크기비교

						while (!qu2.isEmpty()) { // 방금 구한 모든 방의 좌표에 방 번호, 방크기 저장
							Point cur = qu2.poll();
							info[cur.x][cur.y].num = num;
							info[cur.x][cur.y].size = candi;
						}
					}
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {

				for (int dir = 0; dir < 4; dir++) {
					int x = i + dx[dir];
					int y = j + dy[dir];

					if (x >= 0 && x < M && y >= 0 && y < N) { // 범위 체크
						if (info[i][j].num != info[x][y].num) { // 방의 번호가 다를 경우
							sum = Math.max(sum, (info[i][j].size + info[x][y].size)); // 사이즈를 더한 후 크기 비교
						}
					}
				}
			}
		}

		System.out.println(num);
		System.out.println(max);
		System.out.println(sum);
	}
}