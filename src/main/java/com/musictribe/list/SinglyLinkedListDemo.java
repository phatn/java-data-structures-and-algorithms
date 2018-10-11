package com.musictribe.list;

public class SinglyLinkedListDemo {

	public static void main(String[] args) {
		SinglyLinkedList<String> nameList = new SinglyLinkedList<>();
		nameList.addFirst("Phat");
		nameList.addFirst("Vi");
		nameList.addLast("Ruby");
		
		while(!nameList.isEmpty()) {
			System.out.println(nameList.removeFirst());
		}
	}

}
