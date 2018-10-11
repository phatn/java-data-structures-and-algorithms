package com.musictribe.list;

public class SinglyLinkedList<E> {
	
	private static class Node<E> {
		
		private E element;
		
		private Node<E> next;
		
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		@SuppressWarnings("unused")
		public void setElement(E element) {
			this.element = element;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	private Node<E> head = null;
	
	private Node<E> tail = null;
	
	private int size = 0;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E first() {
		if(size == 0) {
			return null;
		}
		
		return head.getElement();
	}
	
	public E last() {
		if(size == 0) {
			return null;
		}
		
		return tail.getElement();
	}
	
	public void addFirst(E element) {
		head = new Node<>(element, head);
		if(size == 0) {
			tail = head;
		}
		size++;
	}
	
	public void addLast(E element) {
		Node<E> newNode = new Node<>(element, null);
		if(size == 0) {
			head = newNode;
		}
			
		tail.setNext(newNode);
		tail = newNode;
		size++;
	}
	
	public E removeFirst() {
		if(size == 0) {
			return null;
		}
		
		E element = head.getElement();
		head = head.getNext();
		size--;
		if(size == 0) {
			tail = null;
		}
		return element;
	}
}
