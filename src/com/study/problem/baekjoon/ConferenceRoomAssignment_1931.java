package com.study.problem.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Time { // 회의의 정보(시작 시간, 끝나는 시간)를 저장하는 클래스
	int begin; // 시작 시간
	int end; // 끝나는 시간

	Time(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
}

public class ConferenceRoomAssignment_1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 회의의 수
		int result = 0; // 최대 사용할 수 있는 회의 수
		ArrayList<Time> timeList = new ArrayList<Time>(); // Time클래스 객체들로 이루어진 ArrayList

		for (int i = 0; i < N; i++) {
			int begin = sc.nextInt();
			int end = sc.nextInt();
			timeList.add(new Time(begin, end));
		}

		Collections.sort(timeList, new Comparator<Time>() { // 끝나는 시간을 기준으로 오름차순으로 정렬
			@Override
			public int compare(Time t1, Time t2) {
				if (t1.end == t2.end) { // 끝나는 시간이 같을 경우
					return Integer.compare(t1.begin, t2.begin); // 시작 시간으로 정렬
				}
				return Integer.compare(t1.end, t2.end);
			}
		});

		int temp = Integer.MIN_VALUE; // 다음 시작 시간과 비교할 변수
		for (int i = 0; i < N; i++) {
			if (timeList.get(i).begin >= temp) { // 현재 시작 시간이 이전 끝나는 시간보다 늦을 경우
				temp = timeList.get(i).end; // 현재 끝나는 시간을 다음 시작 시간과 비교하기 위해 저장
				result++; // 회의 수 증가
			}
		}
		System.out.println(result);
	}
}