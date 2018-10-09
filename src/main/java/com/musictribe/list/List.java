package com.musictribe.list;

public interface List<E> {
	
	int size();
	
	boolean isEmpty();
	
	E first();
	
	E last();
	
	void addFirst(E element);
	
	void addLast(E element);
	
	void removeFirst();
	
}
