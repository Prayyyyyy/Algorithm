package com.baekjoon.string_example;

import java.util.Scanner;

public class MakeCrossWord_2804 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String A = sc.next();
		String B = sc.next();
		char[][] puzzle = new char[30][30];
		int x = 0;
		int y = 0;

		for (int i = 0; i < A.length(); i++) {
			for (int j = 0; j < B.length(); j++) {
				if (A.charAt(i) == B.charAt(j)) { // 공유하는 문자가 나왔을 경우
					x = i; // A의 인덱스 값을 저장
					y = j; // B의 인덱스 값을 저장
					i = A.length();
					break;
				}
			}
		}
		for (int i = 0; i < B.length(); i++) {
			for (int j = 0; j < A.length(); j++) {
				if (i == y) { // 행이 저장한 인덱스 값과 일치한 경우 단어 A 저장
					puzzle[i][j] = A.charAt(j);
				} else {
					if (j == x) { // 열이 저장한 인덱스 값과 일치한 경우 단어 B 저장
						puzzle[i][j] = B.charAt(i);
					} else { // 나머지 글자는 .으로 저장
						puzzle[i][j] = '.';
					}
				}
			}
		}

		for (int i = 0; i < B.length(); i++) {
			for (int j = 0; j < A.length(); j++) {
				System.out.print(puzzle[i][j]);
			}
			System.out.println("");
		}
	}
}