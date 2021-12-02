package com.prestamo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;

public class CrearArchivo {
    private static BufferedReader obj;
    private int num_cores;

    public CrearArchivo(int num_cores) {
        this.num_cores = num_cores; 
    }

    public void crearArchivo(String rutaArchivo, String nombreArchivo) throws IOException{
        String s1 = System.getProperty("file.separator");
        File doc = new File(rutaArchivo+s1+nombreArchivo);
        obj = new BufferedReader(new FileReader(doc));
        String strng;
        int aux = 0;
        List<List<String[]>> lista_archivos  = new ArrayList<List<String[]>>();
        for(int i =0; i<num_cores;i++){ 
        List<String[]> stringList = new ArrayList<String[]>();
        lista_archivos.add(stringList);
        }
        while ((strng = obj.readLine()) != null){
        
        for(int i =0; i<num_cores;i++){ 
        if(aux % num_cores==i){
            lista_archivos.get(i).add(new String[] {strng});
            }
        }
        aux++;
        }
        SyncWriter writer = null;
        ExecutorService pool = Executors.newFixedThreadPool(num_cores);
        for(int i = 0;i<num_cores;i++){ 
            writer = new SyncWriter(rutaArchivo+s1+"dataset.csv",i);
            pool.submit(new DividirArchivo(writer,lista_archivos.get(i),rutaArchivo));
        }
        pool.shutdown();
        writer.close();
    }
}
