package com.baekjoon.stringexample;

import java.util.Scanner;

public class FindAlphabet_10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String st = sc.nextLine();
		
		int[] arr = new int[26];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		
		for(int i = 0; i < st.length(); i++) {
			char ch = st.charAt(i);
			if(arr[Integer.valueOf(ch) - 97] == -1) {
				arr[Integer.valueOf(ch) - 97] = i;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");			
		}
	}
}