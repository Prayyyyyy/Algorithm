package com.baekjoon.barkingdog.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NandM7_15656 {
	static int N, M;
	static int[] arr, arr2;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String[] st = br.readLine().split(" ");
		String[] st2 = br.readLine().split(" ");

		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);

		arr = new int[M];
		arr2 = new int[N];

		for (int i = 0; i < N; i++) {
			arr2[i] = Integer.parseInt(st2[i]);
		}

		Arrays.sort(arr2);
		solve(arr, 0);
		bw.flush();
		bw.close();
	}

	static void solve(int[] arr, int k) throws IOException {
		if (k == M) {
			for (int i = 0; i < M; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[k] = arr2[i];

			solve(arr, k + 1);
		}
	}
}