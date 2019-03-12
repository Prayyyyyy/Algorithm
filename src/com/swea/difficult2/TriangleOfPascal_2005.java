package com.swea.difficult2;

import java.util.Scanner;

public class TriangleOfPascal_2005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int size = 0;
			
			for(int j = 1; j <= N; j++) {
				size += j;
			}
			int[][] arr = new int[size+1][size+1];
			for(int j = 1; j <= N; j++) {
				arr[j][1] = arr[j][j] = 1;				
			}
			
			for(int j = 1; j <= N; j++) {
				for(int k = 1; k <= N; k++) {
					if(j == k || j == 1) {
						continue;
					} else {
						arr[j][k] = arr[j-1][k-1] + arr[j-1][k];
					}
				}
			}
			System.out.println("#" + i);
			
			for(int j = 1; j <= N; j++) {
				for(int k = 1; k <= N; k++) {
					if(j < k) {
						continue;
					} else {
						System.out.print(arr[j][k] +" ");
					}
				}
				System.out.println("");
			}
		}
	}
}