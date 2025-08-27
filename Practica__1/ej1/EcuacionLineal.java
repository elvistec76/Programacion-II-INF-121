/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

/**
 *
 * @author condo
 */
public class EcuacionLineal {
    private double a,b,c,d,e,f;

    public EcuacionLineal(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public void tieneSolucion(){
        if ((a*d - b*c)!=0) {
            System.out.println("la ecuacion tiene solucion");
            System.out.println("x: "+getX()+" y:"+getY());
        }
        else
            System.out.println("la ecuacion no tiene solucion");
    }
    public double getX(){
        return ((e*d-b*f)/(a*d-b*c)); 
    }
    public double getY(){
        return ((a*f-e*c)/(a*d-b*c));
    }
}
