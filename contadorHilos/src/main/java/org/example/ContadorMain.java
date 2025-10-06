package org.example;

import java.util.Random;

public class ContadorMain {


    public static void main(String[] args) throws InterruptedException {
        Thread[] hilos = new Thread[1000];
        ContadorVisitas contadorVisitas = new ContadorVisitas();

        for (int i = 0; i < 1000; i++) {

            Thread hilo= new Thread(()->{
               //nuemro aleatorio entre 50 y 150
                try {
                    Thread.sleep((int)(Math.random()*100)+50);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                contadorVisitas.incrementar();
            });
            hilos[i] = hilo;
            hilo.start();
        }
        for (int i = 0; i < 1000; i++) {
            hilos[i].join();
        }
        System.out.println("Contador de visitas "+contadorVisitas.getContador());

    }
}
