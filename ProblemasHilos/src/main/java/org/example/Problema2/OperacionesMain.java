package org.example.Problema2;

import java.util.Random;

public class OperacionesMain {
    public static void main(String[] args) {
        Thread[] hilos=new Thread[500];
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        for(int i=0;i<hilos.length;i++){

            Thread hilo = new Thread(()->{
            try {
                Thread.sleep((int)(Math.random()*100)+200);
            } catch (InterruptedException e) {
                System.out.println("interrumpido");
            }
            Random rand=new Random();
            cuentaBancaria.ingresar(rand.nextInt(1,50));
            cuentaBancaria.retirar(rand.nextInt(1,100));
        });
        hilos[i]=hilo;
        hilo.start();

            System.out.println("saldo :"+cuentaBancaria.getSaldo());
        }
    }
}
