package ru.innopolis.stc13.io.sentence.fileParser;

import org.w3c.dom.css.Counter;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class WordFinder {
    private List<String> resultList = new ArrayList<>();
    private List<Thread> threads = new ArrayList<>();

    public static void getOccurrences(String[] sources, String[] words, String res) throws ExecutionException, InterruptedException {

        ExecutorService threadPoll = Executors.newFixedThreadPool(8);
        long start = System.nanoTime();
        System.out.println();
        List<Future<String>> futures = new ArrayList<>();
        FileConuter fileConuter = new FileConuter();
//        for (String filename: sources) {
//            futures.add(
//                    CompletableFuture.supplyAsync(() -> fileConuter.readFile(filename), threadPoll)
//            );
//        }

        String value = "";
        for (Future<String> future: futures) {
            value += future.get();
        }

        System.out.println("Executed by " + (System.nanoTime()-start/1000_000_000) + " s, value : " + value);
        threadPoll.shutdown();
    }

/*    public void getOccurrences(String[] sources, String[] words, String res, int countFiles) {
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
    */
}