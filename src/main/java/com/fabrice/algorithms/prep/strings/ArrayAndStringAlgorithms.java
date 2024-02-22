package com.fabrice.algorithms.prep.strings;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayAndStringAlgorithms {

    /**
     * uncompress -- example 2c => cc or 2n3f2s => nnfffss
     * */
    public String uncompress(String s){
        StringBuilder uncompressedResults = new StringBuilder();
        String numbers = "0123456789";
        int i = 0, j = 0;
        while (j<s.length()){
            if(numbers.contains(String.valueOf(s.charAt(j))))
                j++;
            else{
                int num = Integer.parseInt(s.substring(i,j));
                int count=0;
                do{
                    uncompressedResults.append(s.charAt(j));
                    count++;
                }while (count < num);
                j++;
                i = j;
            }
        }
        return uncompressedResults.toString();
    }

    /**
     * compress -- example cc => 2c or nnfffss => 2n3f2s
     */

    public String compress(String s){
       StringBuilder compressedResults = new StringBuilder();
       s = s + " ";
       int i = 0, j = 0;
       while (j < s.length()){
           if(s.charAt(i) == s.charAt(j)){
               j++;
           }else{
               int count = j - i;
               if(count > 1)
                   compressedResults.append(count).append(s.charAt(i));
               else
                   compressedResults.append(s.charAt(i));
                i = j;
           }
       }
       return compressedResults.toString();
    }

    /**
     * Sort even number should come first and odd number after
     */
    public int [] sortEvenOdd(int [] arr){
        int evenIndex = 0;
        int oddIndex = arr.length-1;
        while (evenIndex < oddIndex){
            if(arr[evenIndex] % 2 == 0){
                evenIndex ++;
            }else{
                int temp = arr[oddIndex];
                arr[oddIndex] = arr[evenIndex];
                arr[evenIndex] = temp;
                oddIndex --;
            }
        }
        return arr;
    }

    /**
     * Anagram example fabrice and cebrifa
     * */
    public boolean anagrams(String s1, String s2) {
        return countChar(s1).equals(countChar(s2));
    }

    public Map<Character, Integer> countChar(String s){
        Map<Character, Integer> count = new HashMap<>();
        for(Character c :  s.toCharArray()){
            count.putIfAbsent(c, 0);
            count.put(c, count.get(c) + 1);
        }
        return count;
    }

    /**
     * Most Frequent Char example bookeeper = e
     * */

    public char mostFrequentChar(String s) {
        Map.Entry<Character, Integer> entry = charCounterMap(s).entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        return entry == null ? '0' : entry.getKey();
    }

    public Map<Character, Integer> charCounterMap(String s){
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(Character c : s.toCharArray()){
            map.putIfAbsent(c, 1);
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    /**
     * Pair Sum example [3, 2, 5, 4, 1], target = 8 => [0, 2]
     * Time Complexity : O(n), Space Complexity : O(n)
     * The brute for where we use nested loops is
     * O(n2) for Time and Space O1
     * */
    public List<Integer> pairSum(List<Integer> numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.putIfAbsent(numbers.getFirst(), 0);
        for (int index=1; index<numbers.size(); index++){
            int complement = target - numbers.get(index);
            if((map.containsKey(complement))){
                return List.of(map.get(complement), index);
            }
            map.putIfAbsent(numbers.get(index), index);
        }
        return List.of();
    }

    /**
     * Pair Product example [3, 2, 5, 4, 1], target = 8 => [1, 3]
     * Time Complexity : O(n), Space Complexity : O(n)
     * The brute for where we use nested loops is
     * O(n2) for Time and Space O1
     * */
    public List<Integer> pairProduct(List<Integer> numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.putIfAbsent(numbers.getFirst(), 0);
        for(int index=1; index<numbers.size(); index++){
            int complement = target / numbers.get(index);
            if(map.containsKey(complement)){
                return List.of(map.get(complement), index);
            }
            map.putIfAbsent(numbers.get(index), index);
        }
        return List.of();
    }

    /**
     * Intersection using Java 8
     * */
    public List<Integer> intersection(List<Integer> input1, List<Integer> input2) {
        if(input1.equals(input2))
            return input1;
        List<Integer> list = new ArrayList<>(input1);
        list.addAll(input2);
        return list.stream()
                .filter(e -> Collections.frequency(list, e) > 1)
                .collect(Collectors.toSet()).stream().toList();
    }

    /**
     * Intersection not using java 8
     * */
    public List<Integer> findIntersection(List<Integer> input1, List<Integer> input2) {
        if(input1.equals(input2))
            return input1;
        Set<Integer> set = new TreeSet<>();
        for(Integer num : input1){
            if(input2.contains(num)){
                set.add(num);
            }
        }
        return set.stream().toList();
    }

    /**
     * Five Sort example [12, 5, 1, 5, 12, 7] => [12, 7. 1, 12, 5, 5]
     * Time Complexity : O(n), Space Complexity : O(n)
     * The brute for where we use nested loops is
     * O(n2) for Time and Space O1
     * */
    public List<Integer> fiveSort(List<Integer> array) {
        int i = 0;
        int j = array.size()-1;
        while (i < j){
            if(array.get(j) == 5)
                j--;
            else if(array.get(i) != 5){
                i++;
            }else{
                Collections.swap(array, i, j);
            }
        }
        return array;
    }
}
