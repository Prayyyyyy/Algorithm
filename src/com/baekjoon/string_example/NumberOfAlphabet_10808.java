package com.baekjoon.string_example;

import java.util.Scanner;

public class NumberOfAlphabet_10808 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String st = sc.next();
		char[] arr = st.toCharArray();
		int[] num = new int[26];
		
		for(int i = 0; i < arr.length; i++) {
			num[(int)(arr[i] - 97)]++;
		}
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
}