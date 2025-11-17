package examen;
import java.util.*;

public class Linea {
    private String color;
    private List<Persona> filaPersonas;
    private List<Cabina> cabinas;
    private int cantidadCabinas;

    public Linea(String color) {
        this.color = color;
        this.cantidadCabinas = 0;
        this.filaPersonas = new ArrayList<>();
        this.setCabinas(new ArrayList<>());
        for (int i = 1; i <= cantidadCabinas; i++) {
            getCabinas().add(new Cabina(i));
        }
    }

    public List<Cabina> getCabinas() {
        return cabinas;
    }

    public void setCabinas(List<Cabina> cabinas) {
        this.cabinas = cabinas;
    }

    public void agregarPersona(Persona p) {
        filaPersonas.add(p);
    }

    public void agregarCabina(int nrocabina) {
        getCabinas().add(new Cabina(nrocabina));
        cantidadCabinas++;
    }

    public String getColor() {
        return color;
    }

    public List<Persona> getPersonasEnFila() {
        return filaPersonas;
    }

    public void mostrarLinea() {
        System.out.println("Linea de color: " + color);
        System.out.println("Personas en fila:");
        for (Persona p : filaPersonas) {
            p.mostrar();
        }
        System.out.println("Cabinas:");
        for (Cabina c : getCabinas()) {
            c.mostrarPersonas();
        }
    }
}
