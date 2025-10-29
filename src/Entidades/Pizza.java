
package Entidades;


public class Pizza extends Producto implements IVendible {
    
    private TipoPizza sabor;
    private TamanoPizza tamano;

    public Pizza(String nombre, double precio, Fabricante fabricante, TipoPizza sabor, TamanoPizza tamano) {
        super(nombre, precio, fabricante); 
        this.sabor = sabor;
        this.tamano = tamano;
    }
    
    @Override
    public double getPrecioTotal() {
        double precioFinal = super.getPrecioBase();
        switch (this.tamano) { 
            case CHICA: 
                precioFinal *= 1.05; 
                break;
            case MEDIANA: 
                precioFinal *= 1.10; 
                break;
            case GRANDE: 
                precioFinal *= 1.20; 
                break;
        }
        
        return precioFinal;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" | Tipo: PIZZA | Sabor: ").append(this.sabor);
        sb.append(" | Tamaño: ").append(this.tamano);
        sb.append(" | Precio Total Estimado: $").append(String.format("%.2f", this.getPrecioTotal()));
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) { 
            return false; 
        }
        if (this.getClass() != obj.getClass()) { 
            return false; 
        }
        
        Pizza other = (Pizza) obj; 
        
        return this.sabor == other.sabor && this.tamano == other.tamano;
    }
    
}
