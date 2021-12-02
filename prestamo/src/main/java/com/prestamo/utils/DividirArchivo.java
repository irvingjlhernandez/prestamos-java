package com.prestamo.utils;

import java.util.List;

public class DividirArchivo extends Thread {

    private List<String[]> stringList; 
    private SyncWriter sw;
    private String rutaArchivo;

    public DividirArchivo(SyncWriter sw,List<String[]> stringList, String rutaArchivo) {
        this.sw = sw;
        this.stringList = stringList;
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void run() {
        sw.crearArchivo(stringList,rutaArchivo);
    }
}
