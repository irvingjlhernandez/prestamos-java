package com.prestamo.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Stream;
import  java.time.LocalDateTime;
import java.io.FileReader;
import java.io.FileWriter;


public class WriteFileTask {
    
    public void CrearDirectorio(){
        File directorio = new File("/home/gibran/Desktop/universidad/Programación Avanzada/prestamos-java/prestamo/src/main/java/com/prestamo/db/resultado");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
                }
            }
    }

    public String CrearNombre(){
        String path = "/home/gibran/Desktop/universidad/Programación Avanzada/prestamos-java/prestamo/src/main/java/com/prestamo/db/resultado/";
        LocalDateTime hoy = LocalDateTime.now();
        int ano = hoy.getYear();
        int mes = hoy.getMonthValue();
        int dia = hoy.getDayOfMonth();
        int hora = hoy.getHour();
        int minuto = hoy.getMinute();
        String nombre_archivo = path
                                +String.valueOf(ano)
                                +String.valueOf(mes)
                                +String.valueOf(dia)
                                +"_"
                                +String.valueOf(hora)
                                +String.valueOf(minuto)
                                +".csv";
        return nombre_archivo;
    }
    public void CrearArchivo(){
        String nombre_archivo = CrearNombre();
                        
        try{ 
            String [] record = "2,Virat,Kohli,India,30".split(",");
                                
            FileWriter mFileWriter = new FileWriter(nombre_archivo, false);
            CSVWriter writer = new CSVWriter(mFileWriter);
            writer.writeNext(record);  
            writer.close();
            System.out.println(nombre_archivo);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
