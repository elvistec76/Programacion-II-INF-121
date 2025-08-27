/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej3;
import java.util.Scanner;
/**
 *
 * @author condo
 */
public class Estructurado {
    public static void main(String[] args) {
        Scanner lee=new Scanner(System.in);
        double[]numeros =new double[10];
        double p,d;
        
        System.out.println("ingrese 10 numeros: ");
        for (int i = 0; i < 10; i++) {
            numeros[i]=lee.nextDouble();
        }
        p = promedio(numeros);
        d = desviacion(numeros);
        System.out.println("el promedio es : "+ p);
        System.out.println("la desviacion es: "+d);
        
        lee.close();
        
    }
    
    public static double promedio(double [] n){
        double suma=0;
        for (int i = 0; i < n.length; i++) {
            suma = suma + n[i];
        }
        return suma/n.length;
    }
    public static double desviacion(double [] n){
        double suma =0;
        double media = promedio(n);
        for (int i = 0; i < n.length; i++) {
            suma = suma + Math.pow(n[i]-media, 2);
        }
        return Math.sqrt(suma/(n.length-1));
    }
}
