package com.baekjoon.operation;

import java.util.Scanner;

public class SugarDelivery_2839 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N == 4 || N == 7) {
			System.out.println("-1");
		} else if (N % 5 == 1) {
			System.out.println((N / 5 - 1) + 2);
		} else if (N % 5 == 2) {
			System.out.println((N / 5 - 2) + 4);
		} else if (N % 5 == 3) {
			System.out.println((N / 5) + 1);	
		} else if (N % 5 == 4) {
			System.out.println((N / 5 -1) + 3);
		} else {
			System.out.println(N / 5);
		}
	}
}
