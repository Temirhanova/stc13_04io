package ru.innopolis.stc13.io.sentence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class SentenseTest {
    private int size = 10;
    private Word wordForSentense;
    private char[] endSentense = {'.','!', '?'};
    private static Random random = new Random();
    String[] sourceWord = {"__eat__", "__drink__", "__cook__", "__sell__", "__buy__", "__price__", "__money__", "__try__", "__find__", "__fall__", "__read__", "__play__", "__think__", "__want__", "__know__", "__feel__", "__be__"};
    private Sentense sentense;

    @BeforeEach
    void beforeEach() {
        System.out.println("start test");
        wordForSentense = new Word(size);
        sentense = new Sentense(size, wordForSentense);
    }

    @Test
    void generateSentenseByZeroTest() {
        assertThrows(IllegalArgumentException.class, ()->{sentense.generateSentense(0, sourceWord);});
    }

    @Test
    void generateSentenseDevideByZeroTest() {
        assertThrows(IllegalArgumentException.class, ()->{sentense.generateSentense(0, sourceWord);});
    }

    @Test
    void doWordEntitySet() {
        when(sentense.generateSentense(1, any())).thenReturn(anyString());
    }


}