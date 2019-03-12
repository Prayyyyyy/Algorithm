package com.baekjoon.stringexample;

import java.util.Scanner;

public class CroatianAlphabet_2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.nextLine();

		String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		for (int i = 0; i < croatia.length; i++) {
			word = word.replace(croatia[i], "a");
		}

		System.out.println(word.length());
	}
}