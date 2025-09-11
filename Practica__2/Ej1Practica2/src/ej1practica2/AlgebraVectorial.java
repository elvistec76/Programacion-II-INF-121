/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1practica2;

/**
 *
 * @author condo
 */
public class AlgebraVectorial {
    private double x,y,z;

    public AlgebraVectorial(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public AlgebraVectorial(double x){
        this.x = x;
        this.y = 2;
        this.z = 4;
    }
    
    public AlgebraVectorial() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    public double maginitud(){
        return Math.sqrt(x*x+y*y+z*z);
    }
    
    public AlgebraVectorial suma(AlgebraVectorial b){
        return new AlgebraVectorial(x+b.x, y+b.y, z+b.z);
   }
    public AlgebraVectorial resta(AlgebraVectorial b){
        return new AlgebraVectorial(x-b.x, y-b.y, z-b.z);
    }
    
    public double productoPunto(AlgebraVectorial b){
        return x*b.x+y*b.y+z*b.z;
    }
    public AlgebraVectorial productoCruz(AlgebraVectorial b) {
        double cx = this.y * b.z - this.z * b.y;
        double cy = this.z * b.x - this.x * b.z;
        double cz = this.x * b.y - this.y * b.x;
        return new AlgebraVectorial(cx, cy, cz);
    }
    //sobrecarga de la funcion esPerpendicular 
    public boolean esPerpendicular(AlgebraVectorial b, boolean usarNormas) {
        if (usarNormas) {
            return Math.abs(suma(b).maginitud() - resta(b).maginitud()) < 1e-9;
        }
        return false;
    }
    public boolean esPerpendicular(AlgebraVectorial b, int criterioSimetrico) {
        if (criterioSimetrico == 1) {
            return Math.abs(resta(b).maginitud() - b.resta(this).maginitud()) < 1e-9;
        }
        return false;
    }
        
    public boolean esPerpendicular(AlgebraVectorial b){
        return Math.abs(productoPunto(b))< 1e-9;
    }
    public boolean esPerpendicular(AlgebraVectorial b, String criterio) {
        double sumMag = Math.pow(suma(b).maginitud(), 2);
        double sumaIndiv = Math.pow(this.maginitud(), 2) + Math.pow(b.maginitud(), 2);
    
        if ("pitagoras".equalsIgnoreCase(criterio)) {
            return Math.abs(sumMag - sumaIndiv) < 1e-9;
        }
        return false;
    }
    public boolean esParalela(AlgebraVectorial b, double r) {
        return Math.abs(x - r * b.x) < 1e-9 && Math.abs(y - r * b.y) < 1e-9 && Math.abs(z - r * b.z) < 1e-9;
    }
    
    public boolean esParalela(AlgebraVectorial b) {
        AlgebraVectorial cruz = productoCruz(b);
        return Math.abs(cruz.x) < 1e-9 && Math.abs(cruz.y) < 1e-9 && Math.abs(cruz.z) < 1e-9;
    }
     public AlgebraVectorial proyeccionSobre(AlgebraVectorial b) {
        double escalar = productoPunto(b) / Math.pow(b.maginitud(), 2);
        return new AlgebraVectorial(b.x * escalar, b.y * escalar, b.z * escalar);
    }
    public double componenteEnDireccionDe(AlgebraVectorial b) {
        return productoPunto(b) / b.maginitud();
    }
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }
    
    
    
    
    
    
    
    
    
    
}
