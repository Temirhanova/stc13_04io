package ru.innopolis.stc13.io.scanerRead;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerRead {
    public static void main(String[] args) {
        File file = new File("D://note.txt");
        List<String> stringList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                stringList.add(line);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
