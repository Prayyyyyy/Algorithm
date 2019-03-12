package com.baekjoon.stringexample;

import java.util.Scanner;

public class RepeatString_2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int R = sc.nextInt();
			String st = sc.next();

			String[] arr = st.split("");
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < R; k++) {
					System.out.print(arr[j]);
				}
			}
			System.out.println("");
		}
	}
}