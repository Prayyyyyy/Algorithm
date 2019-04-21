package com.baekjoon.string_example;

import java.util.Scanner;

public class WhyisKMPcalledKMP_2902 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.next();
		char[] arr = st.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (Character.isUpperCase(arr[i]) == true) {
				System.out.print(arr[i]);
			}
		}
	}
}