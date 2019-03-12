package com.swea.difficult2;

import java.util.Scanner;

public class Simple369Game_1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			String st = String.valueOf(i);
			String[] arr = st.split("");
			int cnt = 0;

			for (int j = 0; j < arr.length; j++) {
				if (arr[j].equals("3") || arr[j].equals("6") || arr[j].equals("9")) {
					cnt++;
				}
			}
			if (cnt == 0) {
				System.out.print(i + " ");
			} else {
				for (int j = 0; j < cnt; j++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}
		}
	}
}