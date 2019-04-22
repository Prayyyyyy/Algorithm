package com.baekjoon.string_example;

import java.util.Scanner;

public class AlphabetDistance_5218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String A = sc.next();
			String B = sc.next();
			int[] arr = new int[A.length()];

			for (int j = 0; j < arr.length; j++) {
				if (A.charAt(j) <= B.charAt(j)) {
					arr[j] = B.charAt(j) - A.charAt(j);
				} else {
					arr[j] = (B.charAt(j) + 26) - A.charAt(j);
				}
			}

			System.out.print("Distances: ");
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println("");
		}
	}
}