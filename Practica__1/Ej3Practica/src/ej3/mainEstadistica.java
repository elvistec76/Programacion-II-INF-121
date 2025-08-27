/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej3;

/**
 *
 * @author condo
 */
public class mainEstadistica {
    public static void main(String[] args) {
        Estadistica x=new Estadistica(10);
        x.leer();
        System.out.println("promedio es: "+x.promedio());
        System.out.println("la desviacion estandar es: "+x.desviacion());
        
        
    }
}
