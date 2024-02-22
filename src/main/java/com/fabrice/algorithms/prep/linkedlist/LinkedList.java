package com.fabrice.algorithms.prep.linkedlist;

import com.fabrice.algorithms.prep.linkedlist.util.Node;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    /**
     * Transverse a linked list : O(n) time complexity and O(n) time complexity and 0(1) space complexity
     * */
    public List<String> linkedListValues(Node<String> head) {
        List<String> list = new ArrayList<>();
        Node<String> current  = head;
        while (current != null){
            list.add(current.value);
            current = current.next;
        }
        return list;
    }

    /**
     * Transverse a linked list Recursively : O(n) time complexity and 0(1) space complexity
     * */
    List<String> list = new ArrayList<>();
    public List<String> linkedListValuesRecursively(Node<String> head) {
        if(head == null) return list;
        else{
            list.add(head.value);
            linkedListValuesRecursively(head.next);
        }

        return list;
    }
}
