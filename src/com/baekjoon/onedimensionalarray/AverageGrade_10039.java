package com.baekjoon.onedimensionalarray;

import java.util.Scanner;

public class AverageGrade_10039 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		int result = 0;
		
		for(int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] < 40) {
				arr[i] = 40;
			}
			result += arr[i];
		}
		
		System.out.println(result / 5);
	}
}