
package Entidades;

import java.util.Objects;
import java.util.Random;


public abstract class Producto {
    
    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int calorias; 
    protected int tiempoPreparacion; 
    protected static Random generadorAleatorio;

    static {
        Producto.generadorAleatorio = new Random(); 
    }

    public Producto(String nombre, double precio, Fabricante fabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
        this.calorias = 0; 
        this.tiempoPreparacion = 0;
    }
    
    public Producto(String nombre, double precio, Fabricante fabricante, String ciudadFabricante, int antiguedadFabricante){
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = new Fabricante("Jose", "CABA", 12);
        this.calorias = 0; 
        this.tiempoPreparacion = 0;
        
    }

    
    public Fabricante getFabricante() { 
        return this.fabricante; 
    }
    public String getNombre() { 
        return this.nombre; 
    }
    public double getPrecioBase() { 
        return this.precio; 
    }
    
    public int getCalorias() {
        
        if (this.calorias == 0) {
            this.calorias = Producto.generadorAleatorio.nextInt(601) + 200; 
        }
        
        return this.calorias;
    }

    public int getTiempoPreparacion() {
        
        if (this.tiempoPreparacion == 0) {
            this.tiempoPreparacion = Producto.generadorAleatorio.nextInt(16) + 5; 
        }
        
        return this.tiempoPreparacion;
    }
    
    private static String mostrar(Producto p) {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{nombre='").append(p.nombre).append('\'');
        sb.append(", precio=").append(p.precio);
        sb.append(", calorias=").append(p.getCalorias()); 
        sb.append(", tiempo=").append(p.getTiempoPreparacion());
        sb.append(", fabricante=").append(p.fabricante.toString());
        sb.append('}');
        return sb.toString();
    }
    
    private static boolean sonIguales(Producto p1, Producto p2) {
        return p1.nombre.equalsIgnoreCase(p2.nombre) && p1.fabricante.equals(p2.fabricante);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null || this.getClass() != obj.getClass()) { return false; }
        
        Producto other = (Producto) obj;
        
        return Producto.sonIguales(this, other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nombre.toLowerCase(), this.fabricante);
    }

    @Override
    public String toString() {
        return Producto.mostrar(this);
    }
    
}
