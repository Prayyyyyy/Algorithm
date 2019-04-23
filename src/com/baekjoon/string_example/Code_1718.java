package com.baekjoon.string_example;

import java.util.Scanner;

public class Code_1718 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.nextLine();
		String code = sc.next();
		String result = "";
		int st_size = st.length();
		int code_size = code.length();

		for (int i = 0; i < st_size; i++) {
			if (st.charAt(i) == ' ') { // 해당되는 문자가 공백인 경우
				result = result + ' ';
			} else { // 해당되는 문자가 공백이 아닌 경우
				int gap = st.charAt(i) - code.charAt(i % code_size); // 평문에서 암호화 키를 뺀 값을 저장
				if (gap > 0) { // 평문 문자가 더 큰 경우
					result = result + (char) ('a' + gap - 1);
				} else if (gap < 0) { // 암호화 키의 문자가 더 큰 경우
					gap = code.charAt(i % code_size) - st.charAt(i);
					result = result + (char) ('z' - gap);
				} else { // 두 문자가 같은 경우
					result = result + "z";
				}
			}
		}
		System.out.println(result);
	}
}