package com.baekjoon.ifexample;

import java.util.Scanner;

public class NumberLessThanX_10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();

		int[] num_arr = new int[N];
		
		for(int i = 0; i < num_arr.length; i++) {
			num_arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < num_arr.length; i++) {
			if(num_arr[i] < X) {
				System.out.print(num_arr[i] + " ");
			}
		}
	}
}