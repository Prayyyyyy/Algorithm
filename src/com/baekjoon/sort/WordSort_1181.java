package com.baekjoon.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WordSort_1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}

		// 길이로 정렬
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String st, String st2) {
				// TODO Auto-generated method stub
				return Integer.compare(st.length(), st2.length());
			}
		});

		// 같은 길이 내에서 알파벳 순으로 정렬
		int j, len, temp;
		for (int i = 0; i < N; i++) {
			len = arr[i].length();
			for (j = i + 1; j < N; j++) {
				temp = arr[j].length();
				if (len != temp) {
					break;
				}
			}
			Arrays.sort(arr, i, j);
			i = j - 1;
		}

		System.out.println(arr[0]);
		for (int i = 1; i < N; i++) {
			if (arr[i - 1].equals(arr[i])) { // 같은 단어일 경우
				continue;
			}
			System.out.println(arr[i]);
		}
	}
}