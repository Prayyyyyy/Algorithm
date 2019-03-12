package com.baekjoon.stringexample;

import java.util.Scanner;

public class Constant_2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String A = sc.next();
		String B = sc.next();
		String new_A = "";
		String new_B = "";
		
		char[] arr_A = A.toCharArray();
		char[] arr_B = B.toCharArray();
		char ch = 0;
		
		ch = arr_A[0];
		arr_A[0] = arr_A[2];
		arr_A[2] = ch;

		ch = arr_B[0];
		arr_B[0] = arr_B[2];
		arr_B[2] = ch;
		
		for(int i = 0; i < 3; i++) {
			new_A += Character.toString(arr_A[i]);
			new_B += Character.toString(arr_B[i]);
		}
		
		int num_A = Integer.parseInt(new_A);
		int num_B = Integer.parseInt(new_B);
		
		if(num_A > num_B) {
			System.out.println(num_A);
		} else {
			System.out.println(num_B);
		}
	}
}
