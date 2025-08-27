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
public class Estadistica {
    private double [] valor;

    public Estadistica(int n) {
        this.valor = new double[n];
    }
    
    public double promedio(){
        double suma = 0;
        for(double v:valor){
            suma = suma + v;
        }
        return (suma/valor.length);
    }
    public double desviacion(){
        double m = promedio();
        double s = 0;
        for(double v:valor){
            s = s+Math.pow(v-m, 2);
        }
        return Math.sqrt(s/(valor.length-1));
    }
    public void leer(){
        Scanner lee=new Scanner(System.in);
        System.out.println("ingrese el los numeros: ");
        for(int i=0;i< valor.length;i++){
            valor[i]=lee.nextDouble();
        }
        lee.close();
    }
    
}
