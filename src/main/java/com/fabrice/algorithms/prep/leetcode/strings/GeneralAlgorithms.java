package com.fabrice.algorithms.prep.leetcode.strings;

public class GeneralAlgorithms {


    /**
     *  121
     *  reminder = 121 % 10 = 1 / 12%10 = 2
     *  reverse = reverse * 10 + reminder
     *  121/10 = 1
     **/
    public boolean palindrome(int number) {
        int reverse = 0;
        int temp = number;
        while (temp > 0){
            int reminder = temp % 10;
            reverse = (reverse * 10) + reminder;
            temp = temp/10;
        }
        return number == reverse;
    }
}
