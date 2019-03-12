package com.swea.difficult2;

import java.util.Scanner;

public class LengthOfPatternBars_2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String st = sc.next();
			int length = 0;
			String[] arr = st.split("");

			for (int j = 0; j < 10; j++) {
				for (int k = j + 1; k < 10; k++) {
					if (arr[j].equals(arr[k])) {
						if (st.substring(j, k).equals(st.substring(k, k + (k - j)))) {
							length = k - j;
						} else {
							continue;
						}
					}
				}
			}
			System.out.print("#" + (i + 1) + " ");
			System.out.println(length);
		}
	}
}