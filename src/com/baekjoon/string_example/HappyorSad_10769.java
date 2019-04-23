package com.baekjoon.string_example;

import java.util.Scanner;

public class HappyorSad_10769 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.nextLine();
		int happy = 0;
		int sad = 0;

		for (int i = 0; i < st.length() - 3; i++) {
			if (st.charAt(i) == ':' && st.charAt(i + 1) == '-' && st.charAt(i + 2) == ')') { // 행복한 이모티콘일 경우
				happy++;
			} else if (st.charAt(i) == ':' && st.charAt(i + 1) == '-' && st.charAt(i + 2) == '(') { // 슬픈 이모티콘일 경우
				sad++;
			}
		}
		if (happy == sad) { // 이모티콘의 수가 같은 경우
			if (happy == 0) { // 어떤 이모티콘도 포함되어 있지 않는 경우
				System.out.println("none");
			} else { // 행복한 이모티콘과 슬픈 이모티콘의 수가 동일하게 포함되어 있는 경우
				System.out.println("unsure");
			}
		} else { // 이모티콘의 수가 다른 경우
			if (happy > sad) { // 행복한 이모티콘이 슬픈 이모티콘보다 많이 포함되어 있는 경우
				System.out.println("happy");
			} else { // 슬픈 이모티콘이 행복한 이모티콘보다 많이 포함되어 있는 경우
				System.out.println("sad");
			}
		}
	}
}