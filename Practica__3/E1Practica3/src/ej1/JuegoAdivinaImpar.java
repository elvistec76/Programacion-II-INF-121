/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

/**
 *
 * @author condo
 */
public class JuegoAdivinaImpar extends ClaseJuegoAdivinaNumero {

    public JuegoAdivinaImpar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    public boolean validaNumero(int n) {
        if (n < 0 || n > 10) {
            System.out.println("Número fuera de rango. Debe estar entre 0 y 10.");
            return false;
        }
        if (n % 2 == 0) {
            System.out.println("Error: Debes ingresar un número IMPAR.");
            return false;
        }
        return true;
    }
}