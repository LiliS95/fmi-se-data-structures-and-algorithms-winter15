package com.fmi.si.sda.containers;

import com.fmi.sda.node.Node;
import com.fmi.si.sda.interfaces.Queue;

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

        if (this.tail != null) {
            this.tail.setNext(newNode);
            this.tail = newNode;
        } else {
            this.head = this.tail = newNode;
        }
    }

    @Override
    public T pop() {
        if (this.head != null) {
            T popped = this.head.getData();
            this.head = this.head.getNext();
            return popped;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

}
