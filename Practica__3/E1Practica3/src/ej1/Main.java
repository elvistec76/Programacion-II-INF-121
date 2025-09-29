/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

/**
 *
 * @author condo
 */
public class Main {
    public static void main(String[] args) {
        ClaseJuegoAdivinaNumero juegoBase = new ClaseJuegoAdivinaNumero(3);
        JuegoAdivinaPar juegoPar = new JuegoAdivinaPar(3);
        JuegoAdivinaImpar juegoImpar = new JuegoAdivinaImpar(3);
        
        juegoBase.juega();
        System.out.println(); 
        juegoPar.juega();
        System.out.println();
        juegoImpar.juega();
    }
}
