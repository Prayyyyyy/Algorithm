package com.baekjoon.forexample;

import java.util.Scanner;

public class Year2007_1924 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int result = 0;
		
		for(int i = 0; i < x; i++) {
			result += month[i];
		}
		
		result += y;
		
		switch(result % 7) {
		case 0:
			System.out.println("SUN");
			break;
			
		case 1:
			System.out.println("MON");
			break;
			
		case 2:
			System.out.println("TUE");
			break;
			
		case 3:
			System.out.println("WED");
			break;
			
		case 4:
			System.out.println("THU");
			break;

		case 5:
			System.out.println("FRI");
			break;

		case 6:
			System.out.println("SAT");
			break;
				
		}
		
	}
}
