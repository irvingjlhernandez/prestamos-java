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
public class WriteFilesMultiprocesing implements Runnable{
    Path path = Paths.get("/home/gibran/Desktop/universidad/Programación Avanzada/prestamos-java/prestamo/src/main/java/com/prestamo/db/dataset.csv");
    //COLA DE LINEAS DE ARHIVO, sacar y escribir en su archivo correspondiente
    
    @Override
    public void run() {
          
    }
    
}
