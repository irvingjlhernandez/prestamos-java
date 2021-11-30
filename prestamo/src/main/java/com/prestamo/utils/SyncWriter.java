package com.prestamo.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Stream;
import  java.time.LocalDateTime;
import java.io.FileReader;
import java.io.FileWriter;

public class SyncWriter {
    private PrintWriter pw;
    private int id;
    public SyncWriter(String path, int id) throws FileNotFoundException {
        pw = new PrintWriter(path);
        this.id = id;
    }

    public void close() {
        pw.close();
    }

    public void crearArchivo(List<String[]> stringList){
        String nombre_archivo ="/home/gibran/Desktop/universidad/Programación Avanzada/prestamos-java/prestamo/src/main/java/com/prestamo/db/input_dividido/"
                                +String.valueOf(this.id)
                                +".csv";          
        try{ 
              
            FileWriter mFileWriter = new FileWriter(nombre_archivo, false);
            CSVWriter writer = new CSVWriter(mFileWriter);
            writer.writeAll(stringList);  
            writer.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
