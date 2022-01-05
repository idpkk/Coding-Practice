package com.practice;

import java.util.HashSet;
import java.util.Set;

//Input a number and check if the sum of two numbers in a BST matches with it.

class BST1 {
	static class Node {
		int data;
		Node left, right;

		static Node newNode(int data) {
			Node node = new Node();
			node.data = data;
			node.left = null;
			node.right = null;
			return node;
		}

		static Node insert(Node root, int data) {
			if (root == null) {
				return newNode(data);
			} else if (root.data > data) {
				root.left = newNode(data);
			} else {
				root.right = newNode(data);
			}
			return root;
		}
	}

	static boolean matchPair(Node root, int sum, Set<Integer> set) {
		if (root == null) {
			return false;
		}
		if (matchPair(root.left, sum, set)) {
			return true;
		}

		if (set.contains(sum - root.data)) {
			System.out.println(root.data + " " + (sum - root.data));
			return true;
		} else {
			set.add(root.data);
		}
		return matchPair(root.right, sum, set);
	}

	public static void main(String args[]) {
		Node root = null;
		root = Node.insert(root, 15);
		root = Node.insert(root, 10);
		root = Node.insert(root, 20);
		root = Node.insert(root, 8);
		root = Node.insert(root, 12);
		root = Node.insert(root, 16);
		root = Node.insert(root, 25);
		root = Node.insert(root, 10);
		System.out.println(matchPair(root, 28, new HashSet<Integer>()));
	}
}
