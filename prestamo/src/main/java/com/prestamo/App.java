package com.prestamo;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import com.prestamo.utils.ReadFileMultiTask;

public class App {
  public static void main(String[] args) throws IOException, InterruptedException, ExecutionException{
    //lee todOS OS arhivos
    ReadFileMultiTask reader = new ReadFileMultiTask();
    reader.execute();

  }

}