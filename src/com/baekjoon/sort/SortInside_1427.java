package com.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

public class SortInside_1427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String N = sc.nextLine();

		int size = N.length();

		char[] arr = new char[size];

		for (int i = 0; i < size; i++) {
			arr[i] = N.charAt(i);
		}

		Arrays.sort(arr);

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
	}
}