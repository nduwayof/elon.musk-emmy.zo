package com.fabrice.algorithms.prep.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GeneralAlgorithmsTest {

    GeneralAlgorithms obj = new GeneralAlgorithms();

    @Test
    void palindrome(){
        boolean expected = obj.palindrome(1221);
        assertTrue(expected);

        boolean expected1 = obj.palindrome(1234321);
        assertTrue(expected1);

        boolean expected2 = obj.palindrome(12281);
        assertFalse(expected2);

        boolean expected3 = obj.palindrome(1);
        assertTrue(expected3);
    }

}