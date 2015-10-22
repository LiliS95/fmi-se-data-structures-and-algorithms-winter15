/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.si.sda.interfaces;

/**
 *
 * @author Dimitar
 * @param <T>
 */
public interface Queue<T> {
    
    public void push(T data);
    
    public T pop();
    
    public boolean isEmpty();
}
