/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;

/**
 *
 * @author condo
 */
public class Horario {
    private String DiasApertura;
    private String horaApertura;
    private String horaCierre;

    public Horario(String DiasApertura, String horaApertura, String horaCierre) {
        this.DiasApertura = DiasApertura;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }
    
    public void mostrarHorario(){
        System.out.println("dias de apertura: "+DiasApertura);
        System.out.println("hora de apertura: ["+horaApertura+"]   - hora de cierre: ["+horaCierre+"]");
    }
}
