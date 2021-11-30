package com.prestamo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import com.prestamo.utils.Architecture;
import com.prestamo.utils.ReadFileMultiTask;
import com.prestamo.utils.WriteFileTask;
import com.prestamo.utils.CrearArchivo;

public class App {
  

  public static void main(String[] args) throws IOException, InterruptedException, ExecutionException{
  
        try {
          File directorio = new File("/home/gibran/Desktop/universidad/Programación Avanzada/prestamos-java/prestamo/src/main/java/com/prestamo/db/input_dividido");
          if (!directorio.exists()) {
              if (directorio.mkdirs()) {
                  System.out.println("Directorio creado");
                  Architecture arquitectura = new Architecture();
                  int num_cores = arquitectura.getCores();
                  CrearArchivo archivos = new CrearArchivo(num_cores);
                  archivos.crearArchivo();
              } else {
                  System.out.println("Error al crear directorio");
                  }
          }
  
          ReadFileMultiTask reader = new ReadFileMultiTask();
          reader.execute();
          WriteFileTask prueba = new WriteFileTask();
          prueba.CrearDirectorio();
          prueba.CrearArchivo(); 

        } catch (Exception e) {
            System.out.println(e);
        }
  }
}