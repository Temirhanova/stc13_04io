package ru.innopolis.stc13.io.sentence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {
    Word word;
    int size =9;
    @BeforeEach
    void beforeEach() {
        word = new Word(size);
    }

    @Test
    void wordConstryctorTextleft(){
        assertThrows(RuntimeException.class, ()->new Word(-8));
    }

    @Test
    void wordConstryctorTextRight(){
        assertThrows(RuntimeException.class, ()->new Word(20));
    }


    @RepeatedTest(130)
    void wordIsLength() {
        String testWord = word.generateRandomWords();
        int length = testWord.length();
        if (testWord.contains(",")) {
            assertEquals(length, size+1);
        }
        else assertEquals(length, size);
    }

}