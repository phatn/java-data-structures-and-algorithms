package com.musictribe.queue;

public interface Queue<E> {
	
	int size();
	
	boolean isEmpty();
	
	void enqueue(E element);
	
	E dequeue();
}
