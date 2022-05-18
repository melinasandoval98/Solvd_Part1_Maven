package com.solvd.mavenprojectok.onlineshopping.cart;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CustomLinkedList<T> implements Iterable<Node<T>> {
	private Node<T> head;

	@Override
	public Iterator<Node<T>> iterator() {
		return new NodeIterator<T>(head);
	}

	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		if (this.head == null) {
			head = newNode;
		} else {
			Node<T> currentNode = head;
			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(newNode);
		}
	}

	public void insertHead(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.setNextNode(head);
		head = newNode;
	}

	public void insertAt(int index, T data) {
		Node<T> nodeToBeInserted = new Node<T>(data);
		Node<T> node = head;
		for (int i = 0; i < index - 1; i++) {
			node = node.getNextNode();
		}
		nodeToBeInserted.setNextNode(node.getNextNode());
		node.setNextNode(nodeToBeInserted);
	}

	public void deleteNodeAt(int index) {
		Node<T> node = head;
		for (int i = 0; i < index - 1; i++) {
			node = node.getNextNode();
		}
		node.setNextNode(node.getNextNode().getNextNode());
	}

	public void display() {
		if (head != null) {
			Node<T> currentNode = head;
			while (currentNode.getNextNode() != null) {
				System.out.println(currentNode.getData());
				currentNode = currentNode.getNextNode();
			}
			System.out.println(currentNode.getData());
		}
	}

	public int size() {
		int size = 0;
		if (head != null) {
			Node<T> currentNode = head;
			while (currentNode.getNextNode() != null) {
				size++;
				currentNode = currentNode.getNextNode();
			}
		}
		return size + 1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void clear() {
		if (head != null) {
			Node<T> currentNode = head;
			while (currentNode.getNextNode() != null) {
				currentNode = null;
			}
			head = null;
		}
	}

	public Stream<Node<T>> stream() {
		Iterator<Node<T>> it = iterator();
		int characteristics = 0;
		Spliterator<Node<T>> spliterator = Spliterators.spliterator(it, size(), characteristics);

		return StreamSupport.stream(spliterator, false);
	}

}