package com.musictribe.tree;

import java.util.Iterator;

import com.musictribe.queue.LinkedQueue;
import com.musictribe.queue.Queue;

public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {
	
	public enum Traversal { IN_ORDER, PRE_ORDER, POST_ORDER };
	
	private static class Node<E extends Comparable<E>> {
		
		private E element;
		
		private Node<E> left;
		
		private Node<E> right;
		
		public Node(E element, Node<E> left, Node<E> right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}

		public Node(E element) {
			this(element, null, null);
		}
		
		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getLeft() {
			return left;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public Node<E> getRight() {
			return right;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}
	}
	
	private Node<E> root = null;
	
	public int size() {
		return recSize(root);
	}
	
	
	
	private int recSize(Node<E> node) {
		if(node == null) {
			return 0;
		}
		
		return 1 + recSize(node.getLeft()) + recSize(node.getRight());
	}
	
	public E min() {
		Node<E> node = root;
		
		if(node == null) {
			return null;
		}
		
		while(node.getLeft() != null) {
			node = node.getLeft();
		}
		return node.getElement();
	}
	
	public E mmaxin() {
		Node<E> node = root;
		
		if(node == null) {
			return null;
		}
		
		while(node.getLeft() != null) {
			node = node.getLeft();
		}
		return node.getElement();
	}
	
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public Iterator<E> iterator() {
		return getIterator(Traversal.IN_ORDER);
	}
	
	public Iterator<E> getIterator(Traversal traversal) {
		final Queue<E> queue = new LinkedQueue<>();
		if(traversal == Traversal.IN_ORDER) {
			inOrder(root, queue);
		} else if(traversal == Traversal.PRE_ORDER) {
			preOrder(root, queue);
		} else if(traversal == Traversal.POST_ORDER) {
			postOrder(root, queue);
		}
		
		return new Iterator<E>() {

			@Override
			public boolean hasNext() {
				return !queue.isEmpty();
			}

			@Override
			public E next() {
				if(!hasNext()) {
					throw new IndexOutOfBoundsException("Illlegal invocation of next method");
				}
				return queue.dequeue();
			}
			
		};
	}
	
	private void preOrder(Node<E> node, Queue<E> queue) {
		if(node == null) {
			return;
		}
		
		queue.enqueue(node.getElement());
		preOrder(node.getLeft(), queue);
		preOrder(node.getRight(), queue);
		
	}
	
	private void inOrder(Node<E> node, Queue<E> queue) {
		if(node == null) {
			return;
		}
		
		inOrder(node.getLeft(), queue);
		queue.enqueue(node.getElement());
		inOrder(node.getRight(), queue);
		
	}
	
	private void postOrder(Node<E> node, Queue<E> queue) {
		if(node == null) {
			return;
		}
		
		postOrder(node.getLeft(), queue);
		postOrder(node.getRight(), queue);
		queue.enqueue(node.getElement());
		
	}
	
	public boolean contains(E target) {
		return recContains(target, root);
	}
	
	private boolean recContains(E target, Node<E> node) {
		if(node == null) {
			return false;
		}
		
		if(node.getElement().compareTo(target) == 0) {
			return true;
		}
		
		if(node.getElement().compareTo(target) > 0) {
			return recContains(target, node.getLeft());
		}
		
		return recContains(target, node.getRight());
	}
	
	public E get(E target) {
		return recGet(target, root);
	}
	
	private E recGet(E target, Node<E> node) {
		if(node == null) {
			return null;
		}
		
		if(node.getElement().compareTo(target) == 0) {
			return node.getElement();
		}
		
		if(node.getElement().compareTo(target) > 0) {
			return recGet(target, node.getLeft());
		}
		
		return recGet(target, node.getRight());
	}
	
	public void add(E element) {
		root = recAdd(element, root);
	}
	
	private Node<E> recAdd(E element, Node<E> node) {
		if(node == null) {
			node = new Node<>(element);
		} else if(element.compareTo(node.getElement()) <= 0) {
			node.setLeft(recAdd(element, node.getLeft()));
		} else {
			node.setRight(recAdd(element, node.getRight()));
		}
		return node;
	}
	
	public void remove(E target) {
		root = recRemove(target, root);
	}
	
	private Node<E> recRemove(E target, Node<E> node) {
		if(node == null) {
			return null;
		}
		
		int compareResult = target.compareTo(node.getElement());
		if(compareResult < 0) {
			node.setLeft(recRemove(target, node.getLeft()));
		} else if(compareResult > 0) {
			node.setRight(recRemove(target, node.getRight()));
		} else {
			node = removeNode(node);
		}
		return node;
	}
	
	private Node<E> removeNode(Node<E> node) {
		if(node.getLeft() == null) {
			return node.getRight();
		}
		
		if(node.getRight() == null) {
			return node.getLeft();
		}
		
		E element = getPredecessor(node.getLeft());
		node.setElement(element);
		node.setLeft(recRemove(element, node.getLeft()));
		return node;
	}
	
	private E getPredecessor(Node<E> node) {
		Node<E> current = node;
		while(current.getRight() != null) {
			current = current.getRight();
		}
		return current.getElement();
	}
}
