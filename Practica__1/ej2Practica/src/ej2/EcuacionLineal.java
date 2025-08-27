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
public class EcuacionLineal {
    private double a;
    private double b;
    private double c;

    public EcuacionLineal(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante(){
        return (b*b)-(4*a*c);
    }
    double getRaiz1() {
       double d=getDiscriminante();
        if (d >= 0) {
            return (-b+Math.sqrt(d))/(2*a);
        }
        else{
            return 0;
        }
    }
    double getRaiz2() {
       double d=getDiscriminante();
        if (d >= 0) {
            return (-b-Math.sqrt(d))/(2*a);
        }
        else{
            return 0;
        }
    }
    public void leer(){
        Scanner lee=new Scanner(System.in);
        System.out.println("ingrea el a:");
        a=lee.nextDouble();
        System.out.println("ingrea el b:");
        b=lee.nextDouble();
        System.out.println("ingrea el c:");
        c=lee.nextDouble();
    }
    public void mostrarResultado(){
        if (getDiscriminante()>0) {
            System.out.println("raiz x: "+getRaiz1());
            System.out.println("raiz y: "+getRaiz2());
        }
        else if(getDiscriminante()==0){
            System.out.println("raiz x: "+getRaiz1());
        }
        else{
            System.out.println("la ecuacion no tiene soluciones reales ");
        }
    }
}
