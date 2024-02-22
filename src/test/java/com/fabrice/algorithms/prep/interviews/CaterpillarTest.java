package com.fabrice.algorithms.prep.interviews;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaterpillarTest {
    Caterpillar obj = new Caterpillar();

    @Test
    void getConcatenation(){
        List<String> actual = obj.mapDigitsToLetter("23");
        List<String> expected = List.of("ad","ae","af","bd","be","bf","cd","ce","cf");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test - with input 2")
    void getConcatenationWhenInputIs2(){
        List<String> actual = obj.mapDigitsToLetter("2");
        List<String> expected = List.of("a", "b","c");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test - with input 234")
    void getConcatenationWhenInputIs234(){
        List<String> actual = obj.mapDigitsToLetter("234");
        List<String> expected = List.of("adg", "adh", "adi", "aeg", "aeh", "aei",
                "afg", "afh", "afi", "bdg", "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi",
                "ceg", "ceh", "cei", "cfg", "cfh", "cfi");
        assertEquals(expected, actual);
    }
}