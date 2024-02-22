package com.fabrice.algorithms.prep.interviews;

import java.util.*;

public class Caterpillar {
    public List<String> mapDigitsToLetter(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        for (char digit : digits.toCharArray()) {
            String letters = digitToLetters.get(digit);
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                String currentCombination = queue.poll();
                for (char letter : letters.toCharArray()) {
                    queue.offer(currentCombination + letter);
                }
            }
        }

        result.addAll(queue);
        return result;
    }


    /**
     *
     * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     *
     * Example 1:
     * Input: digits = "23"Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * Example 2:
     * Input: digits = ""Output: []
     * Example 3:
     * Input: digits = "2"Output: ["a","b","c"]
     *
     * Constraints:
     * 0 <= digits.length <= 4
     * digits[i] is a digit in the range ['2', '9'].
     * */



}
