package ru.innopolis.stc13.io.sentence.fileParser;

import java.io.*;
import java.util.ArrayList;

public class ParserOfFiles {

    public ArrayList<File> getFiles(String pathDirectiry) {
        File folder = new File(pathDirectiry);
        ArrayList<File> files = new ArrayList<>();
        for (File file: folder.listFiles()) {
            files.add(file);
        }
        return files;
    }

    public void parse(String pathDirectory, ArrayList<File> files, String[] words) {
        for (File file: files) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(file)){
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
