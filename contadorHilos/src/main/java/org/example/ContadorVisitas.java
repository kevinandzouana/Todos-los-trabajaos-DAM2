package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class ContadorVisitas {
    private int contador=0;


    public  void incrementar(){
        contador++;

    }
    public int getContador(){
        return contador;
    }
}
