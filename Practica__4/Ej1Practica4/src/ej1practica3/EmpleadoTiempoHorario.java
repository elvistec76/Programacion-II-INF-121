/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1practica3;

/**
 *
 * @author condo
 */
public class EmpleadoTiempoHorario extends Empleado {
    private double horasTrabajadas;
    private double tarifaHora;

    public EmpleadoTiempoHorario(String nombre, double horasTrabajadas, double tarifaHora) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
    }

    @Override
    public double calcularSalarioMensual() {
        return horasTrabajadas * tarifaHora;
    }

    @Override
    public String toString() {
        return super.toString() + ", Horas trabajadas: " + horasTrabajadas +
                ", Tarifa por hora: " + tarifaHora +
                ", Salario Mensual: " + calcularSalarioMensual();
    }
}
