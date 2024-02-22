package com.fabrice.algorithms.prep.strings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayAndStringAlgorithmsTest {

    ArrayAndStringAlgorithms obj = new ArrayAndStringAlgorithms();

    @Test
    void uncompress() {
        assertEquals( "cc", obj.uncompress("2c"));
        assertEquals( "ffnnnrr", obj.uncompress("2f3n2r"));
    }

    @Test
    void compress(){
        assertEquals( "2c", obj.compress("cc"));
        assertEquals( "2f3n2r", obj.compress("ffnnnrr"));
    }

    @Test
    void sortEvenOdd(){
        int [] actual = new int[]{2, 3, 7, 9, 8, 5, 4};
        int [] expected = new int[]{2, 4, 8, 9, 5, 7, 3};
        assertEquals(
                Arrays.toString(expected),
                Arrays.toString(obj.sortEvenOdd(actual))
        );
    }

    @Test
    void anagram(){
        assertTrue(obj.anagrams("fabrice", "cebrifa"));
        assertTrue(obj.anagrams("restful", "fluster"));
        assertTrue(obj.anagrams("monkeyswrite", "newyorktimes"));
        assertFalse(obj.anagrams("cats", "tocs"));
    }

    @Test
    void mostFrequentChar(){
        assertEquals('e', obj.mostFrequentChar("bookeeper"));
        assertEquals('d', obj.mostFrequentChar("david"));
        assertEquals('i', obj.mostFrequentChar("mississipi"));
    }

    @Test
    void pairSum(){
        List<Integer> actual = List.of(3, 2, 5, 4, 1);
        List<Integer> expected = List.of(0, 2);
        assertEquals(expected, obj.pairSum(actual, 8));

        List<Integer> actual1 = List.of(4, 7, 9, 2, 5, 1);
        List<Integer> expected1 = List.of(3, 5);
        assertEquals(expected1, obj.pairSum(actual1, 3));
    }

    @Test
    void pairProduct(){
        List<Integer> actual = List.of(3, 2, 5, 4, 1);
        List<Integer> expected = List.of(1, 3);
        assertEquals(expected, obj.pairProduct(actual, 8));

        List<Integer> actual1 = List.of(4, 7, 9, 2, 5, 1);
        List<Integer> expected1 = List.of(4, 5);
        assertEquals(expected1, obj.pairProduct(actual1, 5));
    }

    @Test
    void intersection(){
        List<Integer> actualInput1 = List.of(4,2,1,6);
        List<Integer> actualInput2 = List.of(3,6,9,2,10);
        List<Integer> expected = List.of(2,6);
        assertEquals(expected, obj.intersection(actualInput1, actualInput2));

        List<Integer> actualInput3 = List.of(4,2,1);
        List<Integer> actualInput4 = List.of(1,2,4,6);
        List<Integer> expected1 = List.of(1,2,4);
        assertEquals(expected1, obj.intersection(actualInput3, actualInput4));
    }

    @Test
    void findIntersection(){
        List<Integer> actualInput1 = List.of(4,2,1,6);
        List<Integer> actualInput2 = List.of(3,6,9,2,10);
        List<Integer> expected = List.of(2,6);
        assertEquals(expected, obj.findIntersection(actualInput1, actualInput2));

        List<Integer> actualInput3 = List.of(4,2,1);
        List<Integer> actualInput4 = List.of(1,2,4,6);
        List<Integer> expected1 = List.of(1,2,4);
        assertEquals(expected1, obj.findIntersection(actualInput3, actualInput4));

        List<Integer> actualInput5 = new ArrayList<>();
        List<Integer> actualInput6 = new ArrayList<>();
        List<Integer> expected2 = new ArrayList<>();

        IntStream.range(0, 60000).forEach(i -> {
            actualInput5.add(i);
            actualInput6.add(i);
            expected2.add(i);
        });
        assertEquals(expected2, obj.findIntersection(actualInput5, actualInput6));
    }

    @Test
    void fiveSort(){
        List<Integer> actual = new ArrayList<>(List.of(12, 5, 1, 5, 12, 7));
        List<Integer> expected = List.of(12, 7, 1, 12, 5, 5);
        assertEquals(expected, obj.fiveSort(actual));

        List<Integer> actual1 = new ArrayList<>(List.of(5, 1, 2, 5, 5, 3, 2, 5, 1, 5, 5, 5, 4, 5));
        List<Integer> expected1 = List.of(4, 1, 2, 1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5);
        assertEquals(expected1, obj.fiveSort(actual1));
    }
}