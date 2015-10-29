package com.fmi.se.dsa.implementations;

import com.fmi.se.dsa.Node;
import com.fmi.se.dsa.interfaces.Stack;

/**
 *
 * @author Dimitar
 * @param <T>
 */
public class LinkedListStack<T> implements Stack<T> {

    private Node<T> top;

    @Override
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.top == null) {
            this.top = newNode;
        } else {
            newNode.setNext(this.top);
            this.top = newNode;
        }
    }

    @Override
    public T pop() {
        if (top != null) {
            Node<T> popped = this.top;
            this.top = top.getNext();
            return popped.getData();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }
}
