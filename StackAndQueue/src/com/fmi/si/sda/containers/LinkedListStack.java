package com.fmi.si.sda.containers;

import com.fmi.si.sda.interfaces.Stack;
import com.fmi.sda.node.Node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
