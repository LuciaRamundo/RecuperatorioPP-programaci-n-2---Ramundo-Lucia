
package Entidades;

import java.util.Objects;


public class Fabricante {
    
    private String nombre;
    private String ciudad;
    private int antiguedad;

    public Fabricante(String nombre, String ciudad, int antiguedad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.antiguedad = antiguedad;
    }


    public String getNombre() { 
        return this.nombre;
    }
    
    public String getCiudad() { 
        return this.ciudad; 
    }
    
    public int getAntiguedad() { 
        return this.antiguedad; 
    }
    
    public static boolean sonIguales(Fabricante f1, Fabricante f2) {
        if(f1.nombre.equals(f2.nombre) && f1.ciudad.equals(f2.ciudad) && f1.antiguedad == f2.antiguedad){
            return true;
        }
        return false;
    }

    private String getInfoFabricante() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fabricante: ").append(this.nombre);
        sb.append("\n Ciudad: ").append(this.ciudad);
        sb.append("\n Antiguedad: ").append(this.antiguedad).append(" años");
        
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.getInfoFabricante();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj){ 
            return true; 
        }
        if (obj == null || this.getClass() != obj.getClass()){ 
            return false; 
        }
        
        Fabricante other = (Fabricante) obj;
        
        return this.antiguedad == other.antiguedad && Objects.equals(this.nombre, other.nombre) && Objects.equals(this.ciudad, other.ciudad);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.nombre, this.ciudad, this.antiguedad);
    }
    
    
}
