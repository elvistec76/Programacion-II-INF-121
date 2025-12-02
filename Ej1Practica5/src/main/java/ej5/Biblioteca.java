/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author condo
 */
public class Biblioteca {
    private String nombre;
    private List<Libro> libros;
    private List<Autor> autores;
    private List<Prestamo> prestamos;
    private Horario horario;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.horario = new Horario("luenes a viernes", "9:00 am ", "9:00 pm");
    }
    
    public void AgregarLibro(Libro l){
        libros.add(l);
    }
    
    public void agregarAutor(Autor a){
        autores.add(a);
    }
    
    public void prestarLibro(Estudiante e,Libro l){
        Prestamo p = new Prestamo(e,l);
        prestamos.add(p);
        
        
    }
    
    
    public void mostrarEstado(){
        System.out.println("Biblioteca: "+nombre);
        System.out.println("----------------------------");
        System.out.println("Horario: ");
        horario.mostrarHorario();
        System.out.println("-----------------------------");
        System.out.println("libros: ");
        for (Libro l: libros) {
            System.out.println(l.getTitulo());
        }
        System.out.println("-----------------------------");
        System.out.println("autores: ");
        for (Autor a: autores) {
            a.mostrarInfo();
        }
        System.out.println("------------------------------");
        System.out.println("libros prestados: ");
        for (Prestamo p: prestamos) {
            System.out.println("prestamo realizado a: ");
            p.mostrarInfoPrestamo();
        }
    }
   
}
