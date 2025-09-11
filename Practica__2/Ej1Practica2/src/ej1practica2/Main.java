/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1practica2;

/**
 *
 * @author condo
 */
public class Main {
    
    public static void main(String[] args) {
        AlgebraVectorial a = new AlgebraVectorial(3, 4, 0);
        AlgebraVectorial b = new AlgebraVectorial(-4, 3, 0);
        System.out.println("A) a es ortogonal o perpendicular  a b ? \n " +a.esPerpendicular(b, true));    
        System.out.println("B) a es mutuamente ortogonal ? \n "+a.esPerpendicular(b, 1));
        System.out.println("C) a es ortogonal a b ? \n"+a.esPerpendicular(b));
        System.out.println("D) a es ortogonal a b: ? \n"+a.esPerpendicular(b, "pitagora"));
        System.out.println("E) a es paralela a b por escalar r = 2? \n" + a.esParalela(b, 2));
        System.out.println("F) a es pararela a b por cruz? \n" + a.esParalela(b));
        System.out.println("G) Proyección de a sobre b: \n" + a.proyeccionSobre(b));
        System.out.println("H) Componente de a en dirección de b: \n" + a.componenteEnDireccionDe(b));
    }
}
