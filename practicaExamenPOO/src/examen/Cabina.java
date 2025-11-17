package examen;

import java.util.*;

public class Cabina {
    private int nrocabina;
    private List<Persona> personasAbordo;

    public Cabina(int nrocabina) {
        this.nrocabina = nrocabina;
        this.personasAbordo = new ArrayList<>();
    }

    public void agregarPersona(Persona p) {
        personasAbordo.add(p);
    }

    public void mostrarPersonas() {
        System.out.println("Cabina Nro: " + nrocabina);
        for (Persona p : personasAbordo) {
            p.mostrar();
        }
    }

    public List<Persona> getPersonasAbordo() {
        return personasAbordo;
    }
}

