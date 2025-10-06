package org.example.Problema2;

import java.util.List;
import java.util.Random;

public class CuentaBancaria {
    private double saldo=10000;

   /* public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }*/

    public boolean retirar(double valor){
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }else if(valor > saldo){
           return false;
        }
        return false;
    }
    public void ingresar(double valor){
        saldo += valor;

    }
    public double getSaldo(){
        return saldo;
    }
    public List<String> obtenerHistorial(){
        return List.of();
    }
}
