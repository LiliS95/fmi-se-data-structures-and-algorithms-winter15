
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dimitar
 */
public class LinkedList implements List {

    private Node root;
    private Node tail;

    private int size;

    public LinkedList() {
        root = null;
        tail = null;
    }

    public LinkedList(LinkedList other) {
        this.root = other.root;
        this.tail = other.tail;
        this.size = other.size;
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            root = newNode;
            tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        size++;
    }

    @Override
    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(value);
        } else {
            Node newNode = new Node(value);

            Node current = root;
            Node parent = null;
            int cnt = 0;

            while (cnt++ < index) {
                parent = current;
                current = current.getNext();
            }

            if (current != root) {
                if (parent != null) {
                    parent.setNext(newNode);
                }
                newNode.setNext(current);
            } else {
                newNode.setNext(current);
                root = newNode;
            }
            size++;
        }
    }

    @Override
    public void remove() {
        remove(size - 1);
    }

    @Override
    public void remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = root;
        Node parent = null;
        int cnt = 0;

        while (cnt++ < index) {
            parent = current;
            current = current.getNext();
        }

        if (current != root) {
            if (parent != null) {
                parent.setNext(current.getNext());
            }
            current.setNext(null);
        } else {
            root = current.getNext();
            current.setNext(null);
        }
        size--;
    }

    @Override
    public void reverse() {
        Node current = root;
        Node parent = null;
        Node next;

        while (current != null) {
            next = current.getNext();
            current.setNext(parent);
            parent = current;
            current = next;
        }

        Node t = tail;
        tail = root;
        root = t;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = root;

        if (current != null) {
            result.append(current.getData());
            current = current.getNext();
        }

        while (current != null) {
            result.append(" ").append(current.getData());
            current = current.getNext();
        }
        return result.toString();
    }
}
