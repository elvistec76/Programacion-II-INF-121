/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;
import java.util.*;
/**
 *
 * @author condo
 */
public class Main {
    public static void main(String[] args) {
        // autores 
        Autor a1= new Autor("ELvis", "Boliviano");
        Autor a2= new Autor("Erik", "Boliviano");
        
        List<Pagina> pglibro1= List.of(new Pagina(1, "introduccion ala robotica"),new Pagina(2, "desarrollo de la robotica"));
        List<Pagina> pglibro2= List.of(new Pagina(1, "como cambiar los habitos"), new Pagina(2,"habito nro 1"));
        
        Libro libro1= new Libro("Robotica", "2322342342", pglibro1);
        Libro libro2= new Libro("1000 habitos", "2322342342", pglibro1);
        
        Estudiante e1 = new Estudiante(1865617, "Rafi");
        Estudiante e2 = new Estudiante(1865619, "conde");
        
        Biblioteca b1 = new Biblioteca("Biblioteca de la facultda de Informatica");
        b1.agregarAutor(a1);
        b1.agregarAutor(a2);
        b1.AgregarLibro(libro1);
        b1.AgregarLibro(libro2);
        b1.prestarLibro(e1, libro1);
        
        b1.prestarLibro(e2, libro2);
        
        b1.mostrarEstado();
        
        
        
    }
}
    