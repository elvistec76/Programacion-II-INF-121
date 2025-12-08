/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

/**
 *
 * @author condo
 */
public class Main2 {
    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio();
        
        consultorio.cargarDatos();
        
        //Dar de baja al médico de nombre "Ana" y apellido "Lopez" y sus consultas
        consultorio.bajaMedicoPorNombre("Ana", "Lopez");

        // Cambiar el día de las consultas en Navidad o Año Nuevo
        consultorio.cambiarDiaConsultasFestivas();

        System.out.println("Médicos JSON: " + consultorio.getMedicos());
        System.out.println("Consultas JSON: " + consultorio.getConsultas());
    }
}

