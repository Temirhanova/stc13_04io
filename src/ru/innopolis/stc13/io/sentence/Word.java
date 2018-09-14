package ru.innopolis.stc13.io.sentence;

import java.util.Random;

public class Word {
    private String text;
    private int size;
    private static Random random = new Random();

    String litters = "abcdefghijklmnopqrstuvwxyz";

    public Word(int size) {
        if (size > 16 | size < 0) {
            throw new RuntimeException("переданный параметр выходи за диапозон [1..15]");
        } else {
            this.size = size;
        }

    }

    public String generateRandomWords(){
        String text = "";
        for(int i = 0; i<this.size; i++) {
            text += litters.charAt(random.nextInt(litters.length()));
        }
        if(random.nextInt(50) > 40) {
            text +=",";
        }
        return text;

    }
}
