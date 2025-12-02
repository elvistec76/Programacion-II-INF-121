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
public class Prestamo {
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Estudiante estudiante;
    private Libro libro;
    
    public Prestamo(Estudiante estudiante, Libro libro){
        this.estudiante = estudiante;
        this.libro = libro; 
        this.fechaPrestamo = new Date();
        this.fechaDevolucion = new Date();
    } 
    
    public void mostrarInfoPrestamo(){
        
        System.out.println(" - Estudiante: "+estudiante.getNombre());
        System.out.println(" - Libro: "+libro.getTitulo());
    }
}
