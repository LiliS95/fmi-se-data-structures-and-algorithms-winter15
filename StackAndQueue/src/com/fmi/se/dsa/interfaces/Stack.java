package com.fmi.se.dsa.interfaces;

/**
 *
 * @author Dimitar
 * @param <T>
 */
public interface Stack<T> {

    public void push(T data);

    public T pop();

    public boolean isEmpty();

}
