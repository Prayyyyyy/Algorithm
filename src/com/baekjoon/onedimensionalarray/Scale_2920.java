package com.baekjoon.onedimensionalarray;

import java.util.Scanner;

public class Scale_2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int arr[] = new int[8];
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] == i+1) {
				count++;
			} else if(arr[i] == 8-i) {
				count--;
			}
		}
		
		if(count == 8) {
			System.out.println("ascending");
		} else if(count == -8) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}