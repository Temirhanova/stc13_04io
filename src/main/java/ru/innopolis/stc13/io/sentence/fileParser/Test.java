package ru.innopolis.stc13.io.sentence.fileParser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int countFiles = 6;
        WordFinder finder = new WordFinder();
        String path = "E:\\JAVA Innopolis\\4. paskege io\\io\\src\\ru\\innopolis\\stc13\\io\\result";
        String[] files = new String[countFiles];
        for (int i = 1; i <= countFiles; i++) {
            files[i - 1] = path + "\\file" + i + ".txt";
        }
        String words[] = {"spring", "innopolis", "cat"};
//        finder.getOccurrences(files, words, path+ "\\test\\result.txt", countFiles);
        try {
            finder.getOccurrences(files, words, path+ "\\test\\result.txt");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
