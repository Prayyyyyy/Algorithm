package com.baekjoon.findrule;

import java.util.Scanner;

public class Honeycomb_2292 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int ans;
		int count = 1;
		int sum = 1;

		while (true) {
			sum += 6 * (count - 1);
			if (sum >= n) {
				ans = count;
				break;
			}
			count++;
		}
		System.out.println(ans);
	}
}