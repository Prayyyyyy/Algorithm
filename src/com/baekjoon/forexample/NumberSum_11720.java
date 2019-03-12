package com.baekjoon.forexample;

import java.util.Scanner;

public class NumberSum_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		int result = 0;
		
		String st = sc.nextLine();
		String[] st_arr = st.split("");
		int[] num_arr = new int[100];
		
		for(int i = 0; i < N; i++) {
			num_arr[i] = Integer.parseInt(st_arr[i]);
			result += num_arr[i];
		}
		
		System.out.println(result);
	}
}