/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebasfiltro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Irving
 */
public class Manejador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i,j;
        BufferedReader archivoNormal = null;
        ArrayList<ArrayList<String>> estructuraFiltrada = new ArrayList<>();
        String columnas = "";
        String filtrado = "";
        String[] campos = null;
        String ruta = "C://Users/Irving/Documents/Maestria/Materias/Primer Semestre/Programacion Avanzada/Proyecto/";
        String nombreArchivo = "pruebas.csv";
        String linea;
        String[] camposAuxiliar = null;
        
        try{
            File archivoMenor = new File(ruta, nombreArchivo);
            archivoNormal = new BufferedReader (new FileReader(archivoMenor));
            linea = archivoNormal.readLine();
            campos = linea.split(",");
        }catch (FileNotFoundException e){
            System.out.println("Error: Archivo no encontrado");
            System.out.println(e.getMessage());
        }catch(Exception e) {
            System.out.println("Error de lectura del archivo");
            System.out.println(e.getMessage());
        }finally {
            try {
                if(archivoNormal != null)
                    archivoNormal.close();
            }
            catch (Exception e) {
                System.out.println("Error al cerrar el archivo");
                System.out.println(e.getMessage());
            }
        }
        for(i=0;i<campos.length;i++){
            System.out.println("\t"+Integer.toString(i+1)+" --- "+campos[i]);
        }
        
        System.out.println ("Ingresa las columnas de interes: ");
        Scanner columnaEscaner = new Scanner (System.in);
        columnas = columnaEscaner.nextLine ();
        System.out.println ("Ingresa el criterio de filtrado: ");
        Scanner filtroEscaner = new Scanner (System.in);
        filtrado = filtroEscaner.nextLine ();
        
        estructuraFiltrada = Filtros.filtarArchivo(ruta, "pruebas.csv", filtrado,columnas, campos);
        for(i=0;i<estructuraFiltrada.size();i++){
            for(j=0;j<estructuraFiltrada.get(i).size();j++){
                System.out.print(estructuraFiltrada.get(i).get(j));
            }
            System.out.println("");
        }
        
    }
    
}
