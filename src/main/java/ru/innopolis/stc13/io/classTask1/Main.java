package ru.innopolis.stc13.io.classTask1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        copyFile("D://note1.txt", "D://note.txt");

    }

    public static String readFile(String filename) {
        String text = null;
        try(FileInputStream fileInputStream = new FileInputStream(filename)) {
            System.out.println("Размер файла: " + fileInputStream.available());
            int i = -1;
            while ((i = fileInputStream.read()) != -1) {
                text += (char) i;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
        System.out.println(text);
        return text;
    }



    public static void writeFile(String filename, String content) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            byte[] buffer = content.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String fileName1, String fileName2) {
        writeFile(fileName1, readFile(fileName2));
    }
}
