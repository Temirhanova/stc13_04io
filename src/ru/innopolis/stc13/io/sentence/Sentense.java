package ru.innopolis.stc13.io.sentence;
import java.util.Random;

public class Sentense {
    private int size;
    private String sentense = "";
    private Word wordForSentense;
    private char[] endSentense = {'.','!', '?'};
    private static Random random = new Random();


    public Sentense(int size, Word word) {
        this.size = size;
        this.wordForSentense = word;
    }

    public String generateSentense(int probability, String[] array) {
        int index = random.nextInt(probability);
        int addPositin = 0;
        if (index == (int) 1/probability) {
            addPositin = random.nextInt(probability);
        }
        for (int i=0; i<this.size; i++) {
            if(addPositin == 3) {
                this.sentense += array[random.nextInt(array.length-1)].toString() + " ";
            } else {
                this.sentense += wordForSentense.generateRandomWords() + " ";
            }
        }
        this.sentense += this.sentense.substring(0, this.sentense.length()-1) + endSentense[random.nextInt(endSentense.length)]+" ";
        this.sentense = this.sentense.substring(0,1).toUpperCase() + this.sentense.substring(1, this.sentense.length());
        return this.sentense;
    }
}
