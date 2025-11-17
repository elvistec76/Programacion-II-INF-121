package examen;
import java.util.*;

public class MiTeleferico {
    private List<Linea> lineas;
    private float cantidadDeIngresos;

    public MiTeleferico() {
        this.lineas = new ArrayList<>();
        this.cantidadDeIngresos = 0;
    }

    
    public void agregarPersonaFila(Persona p, String Linea) {
        for (Linea l : lineas) {
            if (l.getColor().equalsIgnoreCase(Linea)) {
                /
                if (l.getPersonasEnFila().size() < 10 || p.getPeso() < 80) {
                    l.agregarPersona(p);
                    cantidadDeIngresos++;
                }
            }
        }
    }
    public void agregarCabina(String linea) {
    for (Linea l : lineas) {
        if (l.getColor().equalsIgnoreCase(linea)) {
            l.agregarCabina(l.getCabinas().size() + 1);
            }
        }
    }



    public void calcularTotalIngresos() {
        for (Linea l : lineas) {
            for (Cabina c : l.getCabinas()) {
                for (Persona p : c.getPersonasAbordo()) {
                    
                    cantidadDeIngresos++;
                }
            }
        }
    }

    
    public void mostrarTarifa(Persona p) {
        if (p.getEdad() > 25) {
            System.out.println("Tarifa regular: Persona mayor a 25 años");
        } else {
            System.out.println("Tarifa preferencial: Persona de 25 años o menos");
        }
    }

}   

