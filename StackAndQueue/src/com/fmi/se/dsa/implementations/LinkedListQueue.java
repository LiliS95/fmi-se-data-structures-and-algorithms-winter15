package com.fmi.se.dsa.implementations;

import com.fmi.se.dsa.Node;
import com.fmi.se.dsa.interfaces.Queue;

/**
 *
 * @author Dimitar
 * @param <T>
 */
public class LinkedListQueue<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;

    @Override
    public void push(T data) {
        Node<T> newNode = new Node<>(data);

        if (!isEmpty()) {
            this.tail.setNext(newNode);
            this.tail = newNode;
        } else {
            this.head = this.tail = newNode;
        }
    }

    @Override
    public T pop() {
        if (this.head != null) {
            Node<T> popped = this.head;
            if (this.head == this.tail) {
                this.tail = this.head = null;
            } else {
                this.head = this.head.getNext();
            }
            return popped.getData();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

}
