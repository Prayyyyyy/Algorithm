package com.baekjoon.forexample;

import java.util.Scanner;

public class CutTen_11721 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String st = sc.nextLine();
		String arr[] = st.split("");
		
		for(int i = 0; i < arr.length; i++) {
			if(i % 10 == 0 && i > 0) {
				System.out.println();
			}
			
			System.out.print(arr[i]);
		}
	}
}