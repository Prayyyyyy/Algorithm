package com.baekjoon.string_example;

import java.util.Scanner;

public class String_1120 {
	static String A;
	static String B;

	static int solve(int front, int back) {
		String st = ""; // 추가할 문자열
		String temp = A; // 완성된 문자열
		int count = 0; // 차이의 개수를 저장

		for (int i = 0; i < front; i++) { // front만큼 앞쪽에 추가
			st += B.charAt(i);
		}
		temp = st + A;
		st = "";

		for (int i = B.length() - back; i < B.length(); i++) { // back만큼 뒤쪽에 추가
			st += B.charAt(i);
		}

		temp = temp + st;

		for (int i = 0; i < temp.length(); i++) { // 문자열 비교
			if (temp.charAt(i) != B.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		A = sc.next();
		B = sc.next();
		int result = Integer.MAX_VALUE; // A와 B의 차이의 최솟값
		int diff = B.length() - A.length(); // B와 A의 길이 차이

		for (int i = diff; i >= 0; i--) { // 앞, 뒤를 넣는 모든 경우의 수를 체크
			int candi = 0;
			candi = solve(i, diff - i);
			result = Math.min(candi, result);
		}

		System.out.println(result);
	}
}