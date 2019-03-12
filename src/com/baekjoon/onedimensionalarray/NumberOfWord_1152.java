package com.baekjoon.onedimensionalarray;

import java.util.Scanner;

public class NumberOfWord_1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String st = sc.nextLine().trim(); // trim() : 문자열의 좌, 우 끝의 공백을 제거한다.
		
		if(st.isEmpty()) {
			System.out.println("0");
		} else {
			System.out.println(st.split(" ").length);
		}
		
	}
}