/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;
import java.util.*;
/**
 *
 * @author condo
 */
public class Libro {
    private String titulo;
    private String ISBN;
    private List<Pagina> paginas;
    
    public Libro(String titulo,String ISBN, List<Pagina> p){
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.paginas = p;
    }
    
    public void leerLibro(){
        for(Pagina p: paginas){
            p.mostrarPagina();
        }
    }
    public String getTitulo(){
        return titulo;
    }
}
