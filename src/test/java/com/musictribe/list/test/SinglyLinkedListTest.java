package com.musictribe.list.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.musictribe.list.List;
import com.musictribe.list.SinglyLinkedList;

public class SinglyLinkedListTest {

	private static Logger LOG = LoggerFactory.getLogger(SinglyLinkedListTest.class);
	
	private List<String> list = null;
	
	@Before
	public void init() {
		list =  new SinglyLinkedList<>();
	}
	
	@Test
	public void testAddFirst() {
		LOG.info("Adding item in the first of the list");
		list.addFirst("Nguyen");
		list.addFirst("Phat");
		String firstName = list.first();
		String lastName = list.last();
		assertEquals("Phat", firstName);
		assertEquals("Nguyen", lastName);
	}
}	
