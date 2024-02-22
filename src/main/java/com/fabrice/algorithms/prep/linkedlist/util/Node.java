package com.fabrice.algorithms.prep.linkedlist.util;

public class Node<T>{
    public T value;
    public Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }
}
