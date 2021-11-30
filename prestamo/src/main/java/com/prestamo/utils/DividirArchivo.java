package com.prestamo.utils;

import java.util.List;

public class DividirArchivo extends Thread {

    private List<String[]> stringList; 
    private SyncWriter sw;

    public DividirArchivo(SyncWriter sw,List<String[]> stringList) {
        this.sw = sw;
        this.stringList = stringList; 
    }

    @Override
    public void run() {
        sw.crearArchivo(stringList);
    }
}
