package com.baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SortNumber2_2751 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		mergeSort(arr, 0, n - 1);
		for (int i = 0; i < n; i++)
			bw.write(arr[i] + "\n");
		bw.flush();
	}

	// 원래 내 코드(시간초과 떠서 Main클래스를 다르게 바꿈)
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(System.in);
	//
	// int N = sc.nextInt();
	// int[] arr = new int[N];
	//
	// for (int i = 0; i < N; i++) {
	// arr[i] = sc.nextInt();
	// }
	//
	// solve(arr);
	// }
	//
	// private static void solve(int[] array) {
	// int[] arr = array;
	//
	// mergeSort(arr, 0, arr.length - 1);
	//
	// for (int i : arr) {
	// System.out.println(i);
	// }
	// }

	public static void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}

	public static void merge(int[] array, int left, int mid, int right) {
		int[] L = Arrays.copyOfRange(array, left, mid + 1);
		int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);

		int i = 0, j = 0, k = left;
		int ll = L.length, rl = R.length;

		while (i < ll && j < rl) {
			if (L[i] <= R[j]) {
				array[k] = L[i++];
			} else {
				array[k] = R[j++];
			}
			k++;
		}

		while (i < ll) {
			array[k++] = L[i++];
		}

		while (j < rl) {
			array[k++] = R[j++];
		}
	}
}