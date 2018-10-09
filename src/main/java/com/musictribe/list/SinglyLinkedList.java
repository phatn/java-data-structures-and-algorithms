package com.musictribe.list;

public class SinglyLinkedList<E> implements List<E> {

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

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
		
	}
	
	private Node<E> head = null;
	
	private Node<E> tail = null;
	
	private int size = 0;
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void addFirst(E element) {
		head = new Node<>(element, head);
		if(isEmpty()) {
			tail = head;
		}
		size++;
	}

	@Override
	public void addLast(E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub

	}

	@Override
	public E first() {
		if(isEmpty()) {
			return null;
		}
		
		return head.getElement();
	}

	@Override
	public E last() {
		if(isEmpty()) {
			return null;
		}
		
		return tail.getElement();
	}

}
