package com.prestamo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Stream;

public class ReadFileMultiTask {
    Path path = Paths.get("src/main/java/com/prestamo/db/partitions");

    public void execute() throws IOException, InterruptedException, ExecutionException {
        useForkJoinPool(path);
        useParallelStream(path);
    }
 
    static void useForkJoinPool(Path path) throws InterruptedException, ExecutionException {
        long begin = System.currentTimeMillis();
 
        if (Files.exists(path) && Files.isDirectory(path)) {
            File[] list = path.toFile().listFiles();
            System.out.println(list.length);
            ReadFileTask task = new ReadFileTask(list);
                         // No se especifica el número de subprocesos en el grupo, el número de núcleos de CPU utilizados
            ForkJoinPool fjp = new ForkJoinPool();
            ForkJoinTask<Integer> future = fjp.submit(task);
            System.out.println(future.get());
        }
 
        System.out.println("used:" + (System.currentTimeMillis() - begin) + "mills");
    }
         // flujo paralelo
    static void useParallelStream(Path path) throws IOException {
        long begin = System.currentTimeMillis();
        if (Files.exists(path) && Files.isDirectory(path)) {
            int[] count = { 0, 0 };
            @SuppressWarnings("resource")
            Stream<Path> files = Files.list(path);
            files.parallel().forEach(p -> {
                count[0]++;
                try (BufferedReader reader = Files.newBufferedReader(p)) {
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        count[1]++;
                        // System.out.println(line);
                        // processLine(line);
                        //AQUI ESCRIBAN O PROCESEN
                    }
                } catch (IOException e) {
                }
            });
            System.out.println("files count:" + count[0]);
            System.out.println("line count:" + count[1]);
        }
        System.out.println("used:" + (System.currentTimeMillis() - begin) + "mills");
    }
    //

    
}