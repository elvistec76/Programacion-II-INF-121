/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author condo
 */
public class Consultorio{
    private  String consultas;
    private  String medicos;
    private transient Gson gson = new Gson();
    private static final Type TIPO_LISTA_MEDICOS = new TypeToken<List<Medico>>() {}.getType();
    private static final Type TIPO_LISTA_CONSULTAS = new TypeToken<List<Consulta>>() {}.getType();
    
    public Consultorio(){
        this.medicos = "[]";
        this.consultas ="[]";
    }
    public String getConsultas() {
        return consultas;
    }

    public void setConsultas(String consultas) {
        this.consultas = consultas;
    }

    public String getMedicos() {
        return medicos;
    }

    public void setMedicos(String medicos) {
        this.medicos = medicos;
    }
    
    private List<Medico> obtenerListaMedicos() {
        if (medicos == null || medicos.isBlank()) {
            return new ArrayList<>();
        }
        return gson.fromJson(medicos, TIPO_LISTA_MEDICOS);
    }

    private void actualizarJsonMedicos(List<Medico> lista) {
        this.medicos = gson.toJson(lista);
    }

    private List<Consulta> obtenerListaConsultas() {
        if (consultas == null || consultas.isBlank()) {
            return new ArrayList<>();
        }
        return gson.fromJson(consultas, TIPO_LISTA_CONSULTAS);
    }

    private void actualizarJsonConsultas(List<Consulta> lista) {
        this.consultas = gson.toJson(lista);
    }
    
    public void altaMedico(Medico m) {
        List<Medico> lista = obtenerListaMedicos();
        lista.add(m);
        actualizarJsonMedicos(lista);
    }
    public void altaConsulta(Consulta c) {
        List<Consulta> lista = obtenerListaConsultas();
        lista.add(c);
        actualizarJsonConsultas(lista);
    }
    public void cargarDatos(){
        altaMedico(new Medico(1, "Ana", "Lopez"));
        altaMedico(new Medico(2, "Carlos", "Gonzalez"));
        altaMedico(new Medico(3, "Maria", "Perez"));

        altaConsulta(new Consulta(1001, "Juan", "Perez", 1, 25, "diciembre", 2025)); 
        altaConsulta(new Consulta(1002, "Lucia", "Rios", 1, 10, "enero", 2025));
        altaConsulta(new Consulta(1003, "Pedro", "Lopez", 1, 1, "enero", 2025));     

        altaConsulta(new Consulta(2001, "Sofia", "Garcia", 2, 15, "noviembre", 2025));
        altaConsulta(new Consulta(2002, "Luis", "Mendez", 2, 25, "diciembre", 2025)); 
        altaConsulta(new Consulta(2003, "Elena", "Rojas", 2, 5, "enero", 2025));

        altaConsulta(new Consulta(3001, "Mario", "Suarez", 3, 1, "enero", 2025));  
        altaConsulta(new Consulta(3002, "Carla", "Torres", 3, 18, "diciembre", 2025));
        altaConsulta(new Consulta(3003, "Jose", "Ortiz", 3, 20, "enero", 2025));     
    }
    public void bajaMedicoPorNombre(String nombre, String apellido) {
        List<Medico> listaMed = obtenerListaMedicos();
        Integer idMedEliminado = null;
        Iterator<Medico> itMed = listaMed.iterator();
        while (itMed.hasNext()) {
            Medico m = itMed.next();
            if (m.getNombreMed().equalsIgnoreCase(nombre)
                    && m.getApellidoMed().equalsIgnoreCase(apellido)) {
                idMedEliminado = m.getIdMed();
                itMed.remove();
                break; 
            }
        }
        if (idMedEliminado == null) {
            System.out.println("No se encontró al médico " + nombre + " " + apellido);
            return;
        }
        
        actualizarJsonMedicos(listaMed);
        
        List<Consulta> listaCons = obtenerListaConsultas();
        Iterator<Consulta> itCons = listaCons.iterator();
        while (itCons.hasNext()) {
            Consulta c = itCons.next();
            if (c.getIdMed() == idMedEliminado) {
                itCons.remove();
            }
        }
        actualizarJsonConsultas(listaCons);
    }
    
   public void cambiarDiaConsultasFestivas() {
        List<Consulta> lista = obtenerListaConsultas();

        for (Consulta c : lista) {
            boolean esNavidad = c.getDia() == 25 && c.getMes().equalsIgnoreCase("diciembre");
            boolean esAnioNuevo = c.getDia() == 1 && c.getMes().equalsIgnoreCase("enero");

            if (esNavidad || esAnioNuevo) {
                
                c.setDia(c.getDia() + 1);
            }
        }
        actualizarJsonConsultas(lista);
        
    }
   
   
            
}
    
    






















/*
public class Consultorio {

    // Lo que se guardará en el archivo JSON
    private String consultas;  
    private String medicos;   

    
    private transient Gson gson = new Gson();

    private static final Type TIPO_LISTA_MEDICOS =
            new TypeToken<List<Medico>>() {}.getType();
    private static final Type TIPO_LISTA_CONSULTAS =
            new TypeToken<List<Consulta>>() {}.getType();

    public Consultorio() {
        // Iniciamos como listas vacías en formato JSON
        this.medicos = "[]";
        this.consultas = "[]";
    }

    // GETTERS / SETTERS de los String (por si los necesitas)
    public String getConsultas() {
        return consultas;
    }

    public void setConsultas(String consultas) {
        this.consultas = consultas;
    }

    public String getMedicos() {
        return medicos;
    }

    public void setMedicos(String medicos) {
        this.medicos = medicos;
    }

    // ===================== MÉTODOS INTERNOS =======================

    private List<Medico> obtenerListaMedicos() {
        if (medicos == null || medicos.isBlank()) {
            return new ArrayList<>();
        }
        return gson.fromJson(medicos, TIPO_LISTA_MEDICOS);
    }

    private void actualizarJsonMedicos(List<Medico> lista) {
        this.medicos = gson.toJson(lista);
    }

    private List<Consulta> obtenerListaConsultas() {
        if (consultas == null || consultas.isBlank()) {
            return new ArrayList<>();
        }
        return gson.fromJson(consultas, TIPO_LISTA_CONSULTAS);
    }

    private void actualizarJsonConsultas(List<Consulta> lista) {
        this.consultas = gson.toJson(lista);
    }

    // ===================== 1. ALTAS =======================

    /**
     * Da de alta un médico (lo agrega a la lista).
     */
    /*public void altaMedico(Medico m) {
        List<Medico> lista = obtenerListaMedicos();
        lista.add(m);
        actualizarJsonMedicos(lista);
    }

    /**
     * Da de alta una consulta (la agrega a la lista).
     */
    /*public void altaConsulta(Consulta c) {
        List<Consulta> lista = obtenerListaConsultas();
        lista.add(c);
        actualizarJsonConsultas(lista);
    }

    /**
     * Ejemplo de carga inicial:
     * al menos 3 médicos y 9 consultas.
     */
    /*public void cargarDatosIniciales() {
        // 3 médicos
        altaMedico(new Medico(1, "Ana", "Lopez"));
        altaMedico(new Medico(2, "Carlos", "Gonzalez"));
        altaMedico(new Medico(3, "Maria", "Perez"));

        // 9 consultas (3 por cada médico, a modo de ejemplo)
        // Algunas en Navidad y Año Nuevo para el punto 3
        altaConsulta(new Consulta(1001, "Juan", "Perez", 1, 25, "diciembre", 2025)); // Navidad
        altaConsulta(new Consulta(1002, "Lucia", "Rios", 1, 10, "enero", 2025));
        altaConsulta(new Consulta(1003, "Pedro", "Lopez", 1, 1, "enero", 2025));     // Año Nuevo

        altaConsulta(new Consulta(2001, "Sofia", "Garcia", 2, 15, "noviembre", 2025));
        altaConsulta(new Consulta(2002, "Luis", "Mendez", 2, 25, "diciembre", 2025)); // Navidad
        altaConsulta(new Consulta(2003, "Elena", "Rojas", 2, 5, "enero", 2025));

        altaConsulta(new Consulta(3001, "Mario", "Suarez", 3, 1, "enero", 2025));   // Año Nuevo
        altaConsulta(new Consulta(3002, "Carla", "Torres", 3, 18, "diciembre", 2025));
        altaConsulta(new Consulta(3003, "Jose", "Ortiz", 3, 20, "enero", 2025));
    }

    // ===================== 2. BAJA DE MÉDICO Y SUS CONSULTAS =======================

    /**
     * Borra al médico que tenga el nombre y apellido indicados
     * y elimina todas las consultas asociadas a su idMed.
     */
    /*public void bajaMedicoPorNombre(String nombre, String apellido) {
        List<Medico> listaMed = obtenerListaMedicos();
        Integer idMedEliminado = null;

        // 1) Eliminar el médico de la lista
        Iterator<Medico> itMed = listaMed.iterator();
        while (itMed.hasNext()) {
            Medico m = itMed.next();
            if (m.getNombreMed().equalsIgnoreCase(nombre)
                    && m.getApellidoMed().equalsIgnoreCase(apellido)) {
                idMedEliminado = m.getIdMed();
                itMed.remove();
                break;  // suponemos que nombre+apellido identifican a uno
            }
        }

        // Si no se encontró el médico, no hay nada más que hacer
        if (idMedEliminado == null) {
            System.out.println("No se encontró al médico " + nombre + " " + apellido);
            return;
        }

        // Actualizar JSON de médicos
        actualizarJsonMedicos(listaMed);

        // 2) Eliminar todas las consultas de ese médico
        List<Consulta> listaCons = obtenerListaConsultas();
        Iterator<Consulta> itCons = listaCons.iterator();
        while (itCons.hasNext()) {
            Consulta c = itCons.next();
            if (c.getIdMed() == idMedEliminado) {
                itCons.remove();
            }
        }

        // Actualizar JSON de consultas
        actualizarJsonConsultas(listaCons);

        System.out.println("Se dio de baja al médico y sus consultas asociadas.");
    }

    // ===================== 3. CAMBIAR DÍA NAVIDAD / AÑO NUEVO =======================

    /**
     * Cambia el día de las consultas que estaban agendadas
     * en Navidad (25 diciembre) o Año Nuevo (1 enero).
     * En este ejemplo, las pasamos al día siguiente:
     *  - 25 diciembre -> 26 diciembre
     *  - 1 enero -> 2 enero
     * Puedes adaptar la lógica según tu regla de negocio.
     */
    /*public void cambiarDiaConsultasFestivas() {
        List<Consulta> lista = obtenerListaConsultas();

        for (Consulta c : lista) {
            boolean esNavidad =
                    c.getDia() == 25 && c.getMes().equalsIgnoreCase("diciembre");
            boolean esAnioNuevo =*/
    
    




