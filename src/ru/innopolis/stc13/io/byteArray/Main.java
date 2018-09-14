package ru.innopolis.stc13.io.byteArray;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    /*

    public static void main(String[] args) {
        String text = "Hello, world!";
        byte[] buffer = text.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer);
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)){
            int c;
            while ((c = bufferedInputStream.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }*/

    public static void main(String[] args) {
        byte[] arra1 = new byte[]{1,3,5,7};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arra1);
        int b;
        while ((b=byteArrayInputStream.read()) != -1) {
            System.out.println(b);
        }
        String text = "Hello world";
         byte[] arry2 = text.getBytes();
         ByteArrayInputStream byteArrayInputStream1 = new ByteArrayInputStream(arry2);
         b = 0;
         while ((b = byteArrayInputStream1.read()) != -1) {
             System.out.print((char) b);
         }
    }

}
