package ru.innopolis.stc13.io.sentence.fileParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FileConuter {

    private List<String> resultList = new ArrayList<>();
    private List<Thread> threads = new ArrayList<>();

    public String readFile(String fileName){
        int i = -1;
        String text = "";
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while ((i = fileInputStream.read()) != -1) {
                text += (char) i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(text);
    return text;
    }

   public void getOccurrences(String[] sources, String[] words, String res, int countFiles) {
        for(String fileName: sources) {
            Thread thread = new SingleFileParser(resultList, fileName, words);
            thread.start();
            threads.add(thread);
        }

        for(Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(resultList);
        save(res);
    }

    private void save(String fileName) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for(String s: resultList) {
                writer.write(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}