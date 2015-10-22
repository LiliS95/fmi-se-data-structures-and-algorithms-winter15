package com.fmi.si.sda.interfaces;

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
public interface Stack<T> {

    public void push(T data);

    public T pop();

    public boolean isEmpty();

}
