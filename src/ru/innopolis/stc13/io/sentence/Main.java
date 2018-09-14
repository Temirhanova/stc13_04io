package ru.innopolis.stc13.io.sentence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] sourceWord = {"__eat__", "__drink__", "__cook__", "__sell__", "__buy__", "__price__", "__money__", "__try__", "__find__", "__fall__", "__read__", "__play__", "__think__", "__want__", "__know__", "__feel__", "__be__"};
        int probability = 10;
        Random random = new Random();
        String path = "E:\\JAVA Innopolis\\4. paskege io\\io\\src\\ru\\innopolis\\stc13\\io\\result";
        int n = 9;
        int size = 7;
        genFiles(path, n, size, sourceWord, probability);
    }
    public static void genFiles(String path, int n, int size, String[] words, int probability) {
        Random random = new Random();
        StringBuilder stringBuilder = null;
        String myString = "";
        File filename;
        for(int i=0; i<n; i++) {
            filename = new File(path, "file"+i+".txt");
            try(FileOutputStream fileOutputStream = new FileOutputStream(filename)) {

                int sizeWord = random.nextInt(14)+1;
                int sizeSentence = random.nextInt(14)+1;
                int sizeParagraph = random.nextInt(19)+1;
                for (int p=0; p<size; p++) {
                    Paragraph paragraph = new Paragraph(sizeParagraph, new Sentense(sizeSentence, new Word(sizeWord)).generateSentense(probability, words));
                    myString += paragraph.generateParagraph();
                }
                byte[] buffer = myString.getBytes();
                fileOutputStream.write(buffer, 0, buffer.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
