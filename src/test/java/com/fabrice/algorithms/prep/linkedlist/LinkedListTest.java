package com.fabrice.algorithms.prep.linkedlist;

import com.fabrice.algorithms.prep.linkedlist.util.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {

    LinkedList obj = new LinkedList();

    @Nested
    class LinkedListTransverse{
        Node<String> a;
        Node<String> b;
        Node<String> c;
        Node<String> d;

        @BeforeEach
        void setObj(){
            a = new Node<>("a");
            b = new Node<>("b");
            c = new Node<>("c");
            d = new Node<>("d");
            a.next = b;
            b.next = c;
            c.next = d;
        }

        @Test
        @DisplayName("Test - LinkedList Transverse")
        void linkedListValues(){
            List<String> expected = List.of("a", "b", "c", "d");
            assertEquals(expected, obj.linkedListValues(a));
        }

        @Test
        @DisplayName("Test - LinkedList Transverse Recursively")
        void linkedListValuesRecursively(){
            List<String> expected = List.of("a", "b", "c", "d");
            assertEquals(expected, obj.linkedListValuesRecursively(a));
        }
    }


}