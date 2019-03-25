package com.study.problem.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Parenthesis_9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			Stack<String> stack = new Stack<String>(); // 스택 생성 및 초기화
			String st = sc.next();
			String[] arr = st.split(""); // 문자열을 쪼개 배열에 저장
			boolean check = true; // 괄호 문자열인지 아닌지 체크하는 변수

			for (int i = 0; i < arr.length; i++) {
				if (arr[i].equals("(")) { // 여는 괄호일 경우 push
					stack.push(arr[i]);
				} else if (arr[i].equals(")")) { // 닫는 괄호일 경우 스택이 비어있는지 아닌지 먼저 확인
					if (!stack.isEmpty()) { // 비어있지 않을 경우 pop
						stack.pop();
					} else { // 비었을 경우 체크 변수를 false 바꾸고 break
						check = false;
						break;
					}
				}
			}

			if (!stack.isEmpty()) { // 스택안에 원소가 아직 남아있다면 체크변수를 false
				check = false;
			}

			if (check) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}