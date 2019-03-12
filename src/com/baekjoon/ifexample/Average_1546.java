package com.baekjoon.ifexample;

import java.util.Scanner;

public class Average_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		double[] arr = new double[N];
		double max = 0, sum = 0;
		double result;
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		max = arr[0];

		for(int i = 1; i < arr.length; i++) {
			if(max <= arr[i]) {
				max = arr[i];
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (arr[i] / max) * 100;
			sum += arr[i];
		}
		
		result = sum / N;
		System.out.println(result);
	}
}