/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

/**
 *
 * @author condo
 */
// Juego.java
import java.util.*;

public class Juego {
    protected int numeroDeVidas;    
    protected int record;            
    protected final int vidasInicial;  

    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.vidasInicial = numeroDeVidas;
        this.record = 0;
    }

    
    public void reiniciarPartida() {
        this.numeroDeVidas = this.vidasInicial;
    }

    
    public void actualizaRecord() {
        if (this.numeroDeVidas > this.record) {
            this.record = this.numeroDeVidas;
        }
    }

    public boolean quitaVida() {
        if (numeroDeVidas > 0) {
            numeroDeVidas--;
        }
        return numeroDeVidas > 0;
    }    
    public int getNumeroDeVidas() {
        return numeroDeVidas;
    }

    public void setNumeroDeVidas(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }
}
