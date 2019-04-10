// na982님 코드 참고

package com.baekjoon.samsungtest;

import java.util.Arrays;
import java.util.Scanner;

class Tree implements Comparable<Tree> {
	int x, y, age;

	Tree(int x, int y, int age) {
		this.x = x;
		this.y = y;
		this.age = age;
	}

	public int compareTo(Tree compareTree) {
		if (this.age < compareTree.age) {
			return -1;
		} else if (this.age == compareTree.age) {
			return 0;
		} else {
			return 1;
		}
	}
}

class QUEUE {
	private int front;
	private int rear;
	private int size;
	private Tree[] tree;

	QUEUE(int size) {
		front = 0;
		rear = 0;
		this.size = size;
		tree = new Tree[this.size];
	}

	boolean isEmpty() {
		return (front == rear);
	}

	boolean isFull() {
		return (rear == this.size - 1);
	}

	void push(Tree val) {
		if (isFull()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			tree[rear++] = val;
		}
	}

	void pop() {
		if (isFull()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			front++;
		}
	}

	Tree front() {
		if (isFull()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			return tree[front];
		}
	}

	int size() {
		return (rear - front);
	}
}

public class TreeFinancialTechnology_16235 {
	public static final int MAX = 684000;
	static int N, M, K;
	static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[][] map = new int[10][10];
	static int[][] add = new int[10][10];
	static Tree init_tree[] = new Tree[100];
	static QUEUE tree[] = new QUEUE[2];
	static QUEUE new_tree = new QUEUE(MAX);
	static QUEUE dead_tree = new QUEUE(MAX);
	static QUEUE birth_tree = new QUEUE(MAX);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				add[i][j] = sc.nextInt();
				map[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			init_tree[i] = new Tree(x, y, z);
			init_tree[i].x--;
			init_tree[i].y--;
		}

		Arrays.sort(init_tree, 0, M);
		int cur = 0;
		int next = 0;

		tree[cur] = new QUEUE(MAX);

		for (int i = 0; i < M; i++) {
			tree[cur].push(init_tree[i]);
		}

		for (int i = 0; i < K; i++) {
			next = (cur + 1) % 2;

			dead_tree = new QUEUE(MAX);
			birth_tree = new QUEUE(MAX);
			tree[next] = new QUEUE(MAX);

			while (!new_tree.isEmpty()) {
				Tree cur_tree = new_tree.front();
				new_tree.pop();

				if (map[cur_tree.x][cur_tree.y] >= cur_tree.age) {
					map[cur_tree.x][cur_tree.y] -= cur_tree.age;

					cur_tree.age++;
					tree[next].push(cur_tree);
				} else {
					dead_tree.push(cur_tree);
				}
			}

			while (!tree[cur].isEmpty()) {
				Tree cur_tree = tree[cur].front();
				tree[cur].pop();

				if (map[cur_tree.x][cur_tree.y] >= cur_tree.age) {
					map[cur_tree.x][cur_tree.y] -= cur_tree.age;

					cur_tree.age++;
					tree[next].push(cur_tree);

					if ((cur_tree.age % 5) == 0) {
						birth_tree.push(cur_tree);
					}
				} else {
					dead_tree.push(cur_tree);
				}
			}

			while (!dead_tree.isEmpty()) {
				Tree cur_tree = dead_tree.front();
				dead_tree.pop();

				map[cur_tree.x][cur_tree.y] += (cur_tree.age / 2);
			}

			new_tree = new QUEUE(MAX);
			while (!birth_tree.isEmpty()) {
				Tree cur_tree = birth_tree.front();
				birth_tree.pop();

				for (int dir = 0; dir < 8; dir++) {
					Tree next_tree = new Tree(0, 0, 0);
					next_tree.x = cur_tree.x + dx[dir];
					next_tree.y = cur_tree.y + dy[dir];
					next_tree.age = 1;
					if (next_tree.x < 0 || next_tree.x >= N || next_tree.y < 0 || next_tree.y >= N) {
						continue;
					}
					new_tree.push(next_tree);
				}
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					map[j][k] += add[j][k];
				}
			}

			cur = next;
		}

		System.out.println(tree[next].size() + new_tree.size());
	}
}