package com.solvd.maven_project_ok.online_shopping.shopping;

import java.util.Iterator;

public class CustomLinkedList<T> implements Iterable<T> {
	private Node<T> head;
	private int size = 1;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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
		size++;
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

	public void delete(int index) {
		Node<T> node = head;
		for (int i = 0; i < index - 1; i++) {
			node = node.getNextNode();
		}
		node.setNextNode(node.getNextNode().getNextNode());
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
