/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;

/**
 *
 * @author condo
 */
public class Autor {
    private String nombre;
    private String Nacionalidad;
    
    public Autor(String nombre, String Nacionalidad){
        this.nombre = nombre;
        this.Nacionalidad = Nacionalidad;
    }
    public void mostrarInfo(){
        System.out.println("nombre: "+nombre);
        System.out.println("Nacionalidad: "+Nacionalidad);
    }
    
}
