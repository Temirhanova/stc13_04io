package ru.innopolis.stc13.io.sentence;

import ru.innopolis.stc13.io.sentence.fileParser.ParserOfFiles;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] sourceWord = {"__eat__", "__drink__", "__cook__", "__sell__", "__buy__", "__price__", "__money__", "__try__", "__find__", "__fall__", "__read__", "__play__", "__think__", "__want__", "__know__", "__feel__", "__be__"};
        int probability = 10;
        Random random = new Random();
        String path = "E:\\JAVA Innopolis\\4. paskege io\\io\\src\\ru\\innopolis\\stc13\\io\\result";
        int n = 9;
        int size = 7;
        FileGenerator fileGenerator = new FileGenerator(path, n, size, sourceWord, probability);
        fileGenerator.genFiles();
        ParserOfFiles parserOfFiles = new ParserOfFiles();
        parserOfFiles.getFiles(path);
    }
}
