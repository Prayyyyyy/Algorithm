package com.baekjoon.ifexample;

import java.util.Scanner;

public class SumCycle_1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int num = 0, count = 0;
		int result = N;
		
		while(true) {
			if(result < 10) {
				num = result;
			} else {
				num = (result / 10) + (result % 10);
				if(num >= 10) {
					num %= 10;
				}
			}
			
			result = ((result % 10) * 10) + num;
			
			count++;
			if(N == result) {
				break;
			}
		}
		System.out.println(count);
	}
}