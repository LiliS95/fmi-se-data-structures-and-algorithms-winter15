package com.fmi.se.sda.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dimitar
 */
public class Node {
    
    int value;
    List<Node> children;
    
    public Node(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.value;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        return this.value == other.value;
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
