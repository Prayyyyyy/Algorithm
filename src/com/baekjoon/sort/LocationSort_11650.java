package com.baekjoon.sort;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LocationSort_11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		ArrayList<Point> arr = new ArrayList<Point>();

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr.add(new Point(x, y));
		}

		Collections.sort(arr, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				// TODO Auto-generated method stub
				if (p1.x == p2.x) {
					return Integer.compare(p1.y, p2.y);
				} else {
					return Integer.compare(p1.x, p2.x);
				}
			}
		});

		for (int i = 0; i < N; i++) {
			System.out.println(arr.get(i).x + " " + arr.get(i).y);
		}
	}
}