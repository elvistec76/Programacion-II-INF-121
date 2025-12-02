/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;

/**
 *
 * @author condo
 */
public class Estudiante {
    private int codigo;
    private String nombre;
    
    public Estudiante(int codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public void mostrarInfoEstudiante(){
        System.out.println("codigo: "+codigo);
        System.out.println("nombre: "+nombre);
    }
    public String getNombre(){
        return nombre;
    }
}
