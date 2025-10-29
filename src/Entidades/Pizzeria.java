
package Entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Pizzeria implements Iterable<Producto> {
    
    private String nombre;
    private int capacidad;
    private Collection<Producto> productos; 

    public Pizzeria(String nombre) {
        this(nombre, 3);
    }

    public Pizzeria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>(); 
    }

    private boolean sonIguales(Producto producto) {
        return this.productos.contains(producto);
    }
    
    public void agregar(Producto producto) {
        if (this.productos.size() < this.capacidad) {
            if (!this.sonIguales(producto)) {
                this.productos.add(producto);
                System.out.println("Producto: " + producto.getNombre() + " agregado con exito.");
            } else {
                System.out.println("El producto " + producto.getNombre() + " ya se encuentra disponible.");
            }
        } else {
            System.out.println("La pizzeria ha alcanzado su capacidad maxima: " + this.capacidad);
        }
    }
    

    private double getPrecioProductos(TipoProducto tipo) {
        double precioTotal = 0;
        
        for (Producto p : this.productos) { 
            if (tipo == TipoProducto.TODOS) {
                precioTotal += ((IVendible) p).getPrecioTotal(); 
            } else if (tipo == TipoProducto.PIZZAS && p instanceof Pizza) {
                precioTotal += ((Pizza) p).getPrecioTotal();
            } else if (tipo == TipoProducto.POSTRES && p instanceof Postre) {
                precioTotal += ((Postre) p).getPrecioTotal();
            }
        }
        
        return precioTotal;
    }
    
    private double getPrecioDePizzas() {
        return this.getPrecioProductos(TipoProducto.PIZZAS);
    }
    
    private double getPrecioDePostres() {
        return this.getPrecioProductos(TipoProducto.POSTRES);
    }
    
    private double getPrecioTotal() {
        return this.getPrecioProductos(TipoProducto.TODOS);
    }

    @Override
    public Iterator<Producto> iterator() {
        return this.productos.iterator();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Pizzeria: ").append(this.nombre).append("\n");
        sb.append("Capacidad Maxima: ").append(this.capacidad).append("\n");
        sb.append("Cantidad de Productos: ").append(this.productos.size()).append("\n");
        
        sb.append("\n--- DETALLE DE PRODUCTOS ---\n");
        
        for (Producto p : this.productos) {
            sb.append(p.toString()).append("\n");
        }
        
        sb.append("\n--- PRECIOS TOTALES ---\n");
        sb.append("Precio Total de Pizzas: $").append(String.format("%.2f", this.getPrecioDePizzas())).append("\n");
        sb.append("Precio Total de Postres: $").append(String.format("%.2f", this.getPrecioDePostres())).append("\n");
        sb.append("PRECIO Global TOTAL: $").append(String.format("%.2f", this.getPrecioTotal())).append("\n");

        return sb.toString();
    }
    
}
