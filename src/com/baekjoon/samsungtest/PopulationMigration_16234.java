// na982님 코드 참고
// 백준에 코드를 제출하면 계속 78%에서 시간 초과로 오류가 뜬다. 나중에 풀 때 시간개념도 생각하면서 풀 것

package com.baekjoon.samsungtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class POSITION {
	int x;
	int y;

	POSITION(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class PopulationMigration_16234 {
	static int N;
	static int L;
	static int R;
	static int[][] map = new int[50][50];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] count;
	static int[] sum;

	static void create_area(int sx, int sy, int[][] status, int index) {
		int[][] visit = new int[50][50];

		Queue<POSITION> qu = new LinkedList<POSITION>();
		POSITION head = new POSITION(sx, sy);
		visit[sx][sy] = 1;
		qu.add(head);

		while (!qu.isEmpty()) {
			POSITION cur = qu.poll();

			status[cur.x][cur.y] = index;
			count[index]++;
			sum[index] += map[cur.x][cur.y];

			for (int i = 0; i < 4; i++) { // 네 방향을 돈다
				POSITION next = new POSITION(cur.x + dx[i], cur.y + dy[i]); // 다음 방향을 저장하는 객체(x, y좌표)

				if (next.x < 0 || next.x >= N || next.y < 0 || next.y >= N) { // 맵 사이즈의 범위를 벗어난 경우
					continue;
				}
				
				int delta = Math.abs(map[cur.x][cur.y] - map[next.x][next.y]); // 인구의 수 차이
				if (visit[next.x][next.y] == 0 && L <= delta && delta <= R) { // 방문 하지 않았고 차이가 범위안에 존재할 경우
					visit[next.x][next.y] = 1;
					qu.add(next);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
			
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		boolean isUpdate = true;
		
		while (isUpdate) { // 업데이트가 발생하지 않을 때까지 반복
			isUpdate = false;

			int[][] status = new int[50][50];
			int area_index = 0;
			count = new int[2501];
			sum = new int[2501];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (status[i][j] == 0) {
						area_index++;
						create_area(i, j, status, area_index);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int index = status[i][j];
					int avg = sum[index] / count[index];
					if (map[i][j] != avg) { // 평균과 나라의 인구 수가 다를 경우
						map[i][j] = avg; // 인구 이동
						isUpdate = true; // 업데이트
					}
				}
			}
			
			if (isUpdate) {
				result++;
			}
		}
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
}