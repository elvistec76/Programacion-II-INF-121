/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

/**
 *
 * @author condo
 */
public class main {
    public static void main(String[] args) {
        System.out.println("Ingresando a, b, c, d, e, f: 9.0 4.0 3.0 -5.0 -6.0 -21.0");
        System.out.println("Ingresando a, b, c, d, e, f: 1.0 2.0 2.0 4.0 4.0 5.0");
        EcuacionLineal e1= new EcuacionLineal(9.0, 4.0, 3.0, -5.0, -6.0, -21.0);
        EcuacionLineal e2=new EcuacionLineal(1.0, 2.0, 2.0, 4.0, 4.0, 5.0);
        
        System.out.println("mostrar el resultado de las ecuaciciones 1 y 2");
        e1.tieneSolucion();
        e2.tieneSolucion();        
    }
}
