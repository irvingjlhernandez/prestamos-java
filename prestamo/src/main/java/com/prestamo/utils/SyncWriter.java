package com.prestamo.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.opencsv.CSVWriter;
import java.io.IOException;
import java.util.List;
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

    public void crearArchivo(List<String[]> stringList,String rutaArchivo){
        String s1 = System.getProperty("file.separator");
        String nombre_archivo =rutaArchivo+s1+"input_dividido"+s1
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
