/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej2;
import java.util.Scanner;
/**
 *
 * @author condo
 */
public class Test {
    public static void main(String[] args) {
        EcuacionLineal e1=new EcuacionLineal(1, 03, 1);
        e1.leer();
        e1.mostrarResultado();
        System.out.println("---------------------");
        EcuacionLineal e2=new EcuacionLineal(1, 03, 1);
        e2.leer();
        e2.mostrarResultado();
        System.out.println("---------------------");
        EcuacionLineal e3=new EcuacionLineal(1, 03, 1);
        e3.leer();
        e3.mostrarResultado();
        
    }       
}

