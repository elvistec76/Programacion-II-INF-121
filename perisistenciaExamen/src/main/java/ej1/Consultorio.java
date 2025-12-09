/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

/**
 *
 * @author condo
 */
public class Consultorio {
    private List<Medico> medicos;
    private List<Consulta> consultas;

    public Consultorio() {
        medicos = new ArrayList<>();
        consultas = new ArrayList<>();
    }

    // 1) 
    public void cargarDatosIniciales() {
        Medico medico1 = new Medico(1, "Elvis", "Huaynoca");
        Medico medico2 = new Medico(2, "Joel", "González");
        Medico medico3 = new Medico(3, "Gabriela", "Ramírez");

        medicos.add(medico1);
        medicos.add(medico2);
        medicos.add(medico3);

        consultas.add(new Consulta(12345678, "Ana", "Lopez", 1, 25, "Diciembre", 2025));
        consultas.add(new Consulta(87654321, "Luis", "Martínez", 1, 24, "Diciembre", 2025));
        consultas.add(new Consulta(11223344, "Marta", "Rodríguez", 1, 31, "Diciembre", 2025));
        consultas.add(new Consulta(22334455, "Pedro", "Sánchez", 2, 1, "Enero", 2026));
        consultas.add(new Consulta(33445566, "Lucía", "Fernández", 2, 2, "Enero", 2026));
        consultas.add(new Consulta(44556677, "David", "Gómez", 2, 5, "Enero", 2026));
        consultas.add(new Consulta(55667788, "Julia", "Vázquez", 3, 24, "Enero", 2026));
        consultas.add(new Consulta(66778899, "Diego", "Hernández", 3, 25, "Enero", 2026));
        consultas.add(new Consulta(77889900, "Sofia", "Pérez", 3, 30, "Enero", 2026));
    }

    // 2) 
    public void bajaMedicoPorNombre(String nombre, String apellido) {
        for (Medico medico : medicos) {
            if (medico.getNombreMed().equals(nombre) && medico.getApellidoMed().equals(apellido)) {
                medicos.remove(medico);
                consultas.removeIf(consulta -> consulta.getIdMed() == medico.getIdMed());
                System.out.println("Médico " + nombre + " " + apellido + " y sus consultas han sido eliminados.");
                return;
            }
        }
        System.out.println("Médico no encontrado.");
    }

    // 3) 
    public void cambiarDiaConsulta() {
        for (Consulta consulta : consultas) {
            if ((consulta.getDia() == 25 && consulta.getMes().equals("Diciembre")) || (consulta.getDia() == 1 && consulta.getMes().equals("Enero"))) {
                consulta.setDia(26);
                System.out.println("Consulta de " + consulta.getNombrePaciente() + " " + consulta.getApellidoPaciente() + " se cambio para otro dia.");
            }
        }
    }

    // Métodos para guardar y cargar JSON
    public void guardarArchivoJson(String archivoMedicos, String archivoConsultas) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
           
            objectMapper.writeValue(new File(archivoMedicos), medicos);
           
            objectMapper.writeValue(new File(archivoConsultas), consultas);
            System.out.println("Datos guardados.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarArchivoJson(String archivoMedicos, String archivoConsultas) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();           
            medicos = Arrays.asList(objectMapper.readValue(new File(archivoMedicos), Medico[].class));
            consultas = Arrays.asList(objectMapper.readValue(new File(archivoConsultas), Consulta[].class));
            System.out.println("Datos cargados.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarMedicos() {
        for (Medico medico : medicos) {
            System.out.println("Médico: " + medico.getNombreMed() + " " + medico.getApellidoMed());
        }
    }

    public void mostrarConsultas() {
        for (Consulta consulta : consultas) {
            System.out.println("Consulta de " + consulta.getNombrePaciente() + " " + consulta.getApellidoPaciente() + " con médico ID: " + consulta.getIdMed() +
                               " el " + consulta.getDia() + "/" + consulta.getMes() + "/" + consulta.getAnio());
        }
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
    
    




