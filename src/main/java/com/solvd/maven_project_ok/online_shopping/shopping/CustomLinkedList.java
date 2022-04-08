package com.solvd.Maven_Project.olineShopping.shopping;

public class CustomLinkedList<T> {
	private Node<T> head;

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

	public void delete(int index) {
		Node<T> node = head;
		for (int i = 0; i < index - 1; i++) {
			node = node.getNextNode();
		}
		node.setNextNode(node.getNextNode().getNextNode());
	}

}
