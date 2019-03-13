package com.swea.difficult2;

import java.util.Arrays;
import java.util.Scanner;

public class IntermediateMeanValue_1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t<= T; t++) {
			double result = 0, sum = 0;
			int[] arr = new int[10];
			
			for(int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			for(int i = 1; i < 9; i++) {
				sum += arr[i];
			}
			result = sum / 8;
			
			System.out.format("#%d %.0f\n", t, result);
		}
	}
}