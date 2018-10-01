package ru.innopolis.stc13.io.sentence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {
    String path;
    int n;
    int size;
    String[] words;
    int probability;

    public FileGenerator(String path, int n, int size, String[] words, int probability) {
        this.path = path;
        this.n = n;
        this.size = size;
        this.words = words;
        this.probability = probability;
    }

    public void genFiles() {
        Random random = new Random();
        StringBuilder stringBuilder = null;
        String myString = "";
        File filename;
        for(int i=0; i<this.n; i++) {
            filename = new File(this.path, "file"+i+".txt");
            try(FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
                int sizeWord = random.nextInt(14)+1;
                int sizeSentence = random.nextInt(14)+1;
                int sizeParagraph = random.nextInt(19)+1;
                for (int p=0; p<this.size; p++) {
                    Paragraph paragraph = new Paragraph(sizeParagraph, new Sentense(sizeSentence, new Word(sizeWord)).generateSentense(this.probability, this.words));
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
