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
        Consultorio c1 = new Consultorio();
        //1
        c1.cargarDatosIniciales();
        c1.guardarArchivoJson("medicos.json", "consultas.json");
        
        //2 
        c1.bajaMedicoPorNombre("Elvis", "Huaynoca");
        //3 
        c1.cambiarDiaConsulta();
        
        c1.guardarArchivoJson("medicos.json", "consultas.json");
        c1.cargarArchivoJson("medicos.json", "consultas.json");
        
        System.out.println("---------------");
        System.out.println("medicos");
        c1.mostrarMedicos();
        System.out.println("consultas");
        c1.mostrarConsultas();
    }
}

