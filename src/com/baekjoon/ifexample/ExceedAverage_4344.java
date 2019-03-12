package com.baekjoon.ifexample;

import java.util.Scanner;

public class ExceedAverage_4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();

		
		for(int i = 0; i < C; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			double sum = 0, num = 0;
			double avr = 0, per = 0;
			
			for(int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			
			avr = sum / N;
			for(int j = 0; j < N; j++) {
				if(arr[j] > avr) {
					num++;
				}
			}
			
			per = num / N * 100.0;
			System.out.printf("%.3f", per);
			System.out.println("%");
		}
	}
}
