package com.prestamo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
 
public class ReadFileTask extends RecursiveTask<Integer> {
 
    private static final long serialVersionUID = 1L;
    private File[] files;
    private final static Integer THRESHOLD = 20;
 
    public ReadFileTask(File[] files) {
        this.files = files;
    }
 
    @Override
    protected Integer compute() {
        int all = 0;
        int size = files.length;
        
        if (size > THRESHOLD) {
            int mid = size / 2;
            ForkJoinTask<Integer> left = new ReadFileTask(Arrays.copyOfRange(files, 0, mid)).fork();
            ForkJoinTask<Integer> right = new ReadFileTask(Arrays.copyOfRange(files, mid, size)).fork();
                         
            left.join();
            right.join();
            try {
                all = left.get() + right.get();
            } catch (InterruptedException | ExecutionException e1) {
                e1.printStackTrace();
            }
        } else {
            for (File f : files) {
                try (BufferedReader reader = Files.newBufferedReader(f.toPath())) {
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        all++;
                    }
                } catch (IOException e) {
                }
            }
        }
        return all;
    }
}