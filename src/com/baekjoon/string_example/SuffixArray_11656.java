package com.baekjoon.string_example;

import java.util.Arrays;
import java.util.Scanner;

public class SuffixArray_11656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String st = sc.next();
		int size = st.length();
		String[] arr = new String[size];
		
		for(int i = 0; i < size; i++) {
			arr[i] = st;
			st = st.substring(1, st.length());
		}
		Arrays.sort(arr);
		
		for(int i = 0; i < size; i++) {
			System.out.println(arr[i]);
		}
	}
}