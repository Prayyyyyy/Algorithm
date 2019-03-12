package com.baekjoon.barkingdog.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NandM3_15651 {
	static int N, M;
	static int[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		String[] st = br.readLine().split(" ");

		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		arr = new int[M];

		solve(arr, 0);

		bw.flush();
		bw.close();
	}

	static void solve(int[] arr, int k) throws IOException {
		if (k == M) {
			for (int i = 0; i < M; i++) {
				bw.write(arr[i] + 1 + " ");
			}
			bw.write("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[k] = i;
			solve(arr, k + 1);
		}
	}
}