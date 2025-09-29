/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author condo
 */
public class ClaseJuegoAdivinaNumero extends Juego {
    private int nroAAdivinar;

    public ClaseJuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }
    
    public boolean validaNumero(int n) {
        return n >= 0 && n <= 10;
    }
    
    public void juega() {
        Scanner lee = new Scanner(System.in);
        Random rand = new Random(); 
        super.reiniciarPartida();
        nroAAdivinar = rand.nextInt(11);  

        
        System.out.println("Adivina el número entre 0 y 10. Tienes " + numeroDeVidas + " vidas.");

        
        while (true) {
            System.out.print("Introduce un número: ");
            
            int intento = lee.nextInt();
            
            if (!validaNumero(intento)) {
                // validaNumero puede imprimir su propio mensaje de error en las subclases.
                // Si no lo hizo, damos una línea genérica.
                if (!(intento >= 0 && intento <= 10)) {
                    System.out.println("Número fuera de rango. Debe estar entre 0 y 10.");
                }
                continue;
            }
            if (intento == nroAAdivinar) {
                System.out.println("¡Acertaste!!");
                
                actualizaRecord();
                System.out.println("Vidas restantes: " + numeroDeVidas);
                System.out.println("Record actual: " + getRecord());
                break; 
            } else {
                
                boolean quedan = quitaVida(); 
                if (quedan) {
                    
                    if (intento < nroAAdivinar) {
                        System.out.println("Incorrecto. El número a adivinar es mayor. Vidas restantes: " + numeroDeVidas);
                    } else {
                        System.out.println("Incorrecto. El número a adivinar es menor. Vidas restantes: " + numeroDeVidas);
                    }
                    System.out.println("Intenta de nuevo.");
                    
                } else {
                    // quitaVida devolvió false -> ya no quedan vidas
                    System.out.println("No te quedan más vidas. Fin del juego.");
                    System.out.println("El número era: " + nroAAdivinar);
                    break; 
                }
            }
        }
        lee.close();  
    }
}
