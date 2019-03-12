package com.baekjoon.sort;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SortNumber3_10989 {
	static void count_sort(int arr[], int exp) {
		int size = arr.length;
		int output[] = new int[size];
		int count[] = new int[10];
		int i, index;
		
		for (i = 0; i < size; i++) {
			count[(arr[i] / exp) % 10]++;			
		}
		
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];			
		}
		
		for (i = size - 1; i > -1; i--) {
			index = arr[i] / exp;
			output[count[index % 10] - 1] = arr[i];
			count[index % 10]--;
		}
		
		for (i = 0; i < size; i++) {			
			arr[i] = output[i];
		}
	}

	static void radix_sort(int arr[]) {
		int max = arr[0];
		for (int i : arr) {
			if (max < i) {
				max = i;							
			}
		}
		
		for (int exp = 1; max / exp > 0; exp *= 10) {
			count_sort(arr, exp);			
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());			
		}
		radix_sort(arr);
		
		for (int i = 0; i < n; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.flush();
	}
}