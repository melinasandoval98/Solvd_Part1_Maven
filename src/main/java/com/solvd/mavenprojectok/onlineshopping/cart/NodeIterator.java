package com.solvd.mavenprojectok.onlineshopping.cart;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeIterator<T> implements Iterator<Node<T>> {

	Node<T> next;

	NodeIterator(Node<T> head) {
		next = head;
	}

	@Override
	public boolean hasNext() {
		return (next != null);
	}

	@Override
	public Node<T> next() {
		if (next == null)
			throw new NoSuchElementException();
		Node<T> res = next;
		next = next.getNextNode();
		return res;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}