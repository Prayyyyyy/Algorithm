package com.baekjoon.onedimensionalarray;

import java.util.Scanner;

public class OXQuiz_8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < N; i++) {
			String st = sc.nextLine();
			String[] st_arr = st.split("");
			int count = 0, result = 0;
			
			for(int j = 0; j < st_arr.length; j++) {
	
				if(st_arr[j].equals("O")) {
					count++;
					result += count;
				} else {
					count = 0;
				}
			}
			
			System.out.println(result);
		}
	}
}