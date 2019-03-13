package com.swea.difficult2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GradingOfAssistant_1983 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final String[] grades = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt() - 1;
			Integer[] student_grades = new Integer[N];
			int student_rank = 0, student_grade = 0;
			int mid_grade, final_grade, homework;
			String result = "";

			for (int i = 0; i < N; i++) {
				mid_grade = sc.nextInt();
				final_grade = sc.nextInt();
				homework = sc.nextInt();

				student_grades[i] = (mid_grade * 35) + (final_grade * 45) + (homework * 20);
			}

			student_grade = student_grades[K];
			Arrays.sort(student_grades, Collections.reverseOrder());
			student_rank = Arrays.asList(student_grades).indexOf(student_grade);
			result = grades[10 * student_rank / N];

			System.out.format("#%d %s\n", t, result);
		}
	}
}