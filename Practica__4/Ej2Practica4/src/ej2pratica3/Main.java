/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej2pratica3;
import java.util.Random;
/**
 *
 * @author condo
 */
public class Main {
    public static void main(String[] args) {
        Figura[] figuras = new Figura[5];
        Random rnd = new Random();

        for (int i = 0; i < figuras.length; i++) {
            int tipo = rnd.nextInt(2) + 1;  
            String color = (rnd.nextBoolean()) ? "Rojo" : "Azul";

            if (tipo == 1) {
                double lado = rnd.nextInt(10) + 1;
                figuras[i] = new Cuadrado(color, lado);
            } else {
                double radio = rnd.nextInt(10) + 1;
                figuras[i] = new Circulo(color, radio);
            }
        }

        System.out.println(" Lista de Figuras ");
        for (Figura f : figuras) {
            System.out.println(f.toString());
            System.out.println("Área: " + f.area());
            System.out.println("Perímetro: " + f.perimetro());
            if (f instanceof Coloreado) {
                System.out.println(((Coloreado) f).comoColorear());
            }
            System.out.println();
        }
    }
   
}
