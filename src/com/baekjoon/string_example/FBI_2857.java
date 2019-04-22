package com.baekjoon.string_example;

import java.util.Scanner;

public class FBI_2857 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		int[] arr = new int[6];

		for (int i = 1; i <= 5; i++) {
			String st = sc.next();

			if (st.contains("FBI")) {
				check = true;
				arr[i] = i;
			}
		}

		for (int i = 1; i <= 5; i++) {
			if (!check) {
				System.out.println("HE GOT AWAY!");
				break;
			} else {
				if (arr[i] != 0) {
					System.out.print(arr[i] + " ");
				}
			}
		}
	}
}