/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1practica3;
import java.util.Scanner;
/**
 *
 * @author condo
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empleado[] empleados = new Empleado[5];

        System.out.println("=== Registrar 3 empleados a tiempo completo ===");
        for (int i = 0; i < 3; i++) {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Salario anual: ");
            double salario = sc.nextDouble();
            sc.nextLine(); 
            empleados[i] = new EmpleadoTiempoCompleto(nombre, salario);
        }

        System.out.println("\n=== Registrar 2 empleados a tiempo horario ===");
        for (int i = 3; i < 5; i++) {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Horas trabajadas: ");
            double horas = sc.nextDouble();
            System.out.print("Tarifa por hora: ");
            double tarifa = sc.nextDouble();
            sc.nextLine();
            empleados[i] = new EmpleadoTiempoHorario(nombre, horas, tarifa);
        }

        System.out.println("\n=== Lista de empleados registrados ===");
        for (Empleado e : empleados) {
            System.out.println(e.toString());
        }
    }
}
