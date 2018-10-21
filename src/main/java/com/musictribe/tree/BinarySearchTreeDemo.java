package com.musictribe.tree;

import java.util.Iterator;

import com.musictribe.tree.BinarySearchTree.Traversal;

public class BinarySearchTreeDemo {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		/*tree.add(7);
		tree.add(3);
		tree.add(15);
		tree.add(2);
		tree.add(10);
		tree.add(20);*/
		
		tree.remove(3);
		Iterator<Integer> it = tree.getIterator(Traversal.PRE_ORDER);
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		/*System.out.println("Traversal IN-ORDER");
		Iterator<Integer> it = tree.getIterator(Traversal.IN_ORDER);
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		System.out.println();
		System.out.println("Traversal PRE-ORDER");
		it = tree.getIterator(Traversal.PRE_ORDER);
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		System.out.println();
		System.out.println("Traversal POST-ORDER");
		it = tree.getIterator(Traversal.POST_ORDER);
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}*/
	}

}
