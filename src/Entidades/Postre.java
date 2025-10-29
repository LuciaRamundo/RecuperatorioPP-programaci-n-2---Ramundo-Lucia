
package Entidades;


public class Postre extends Producto implements IVendible {
    
    private TipoPostre tipoPostre;

    public Postre(String nombre, double precio, Fabricante fabricante, TipoPostre tipoPostre) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;
    }

    @Override
    public double getPrecioTotal() {
        double precioFinal = super.getPrecioBase();
        switch (this.tipoPostre) { 
            case TIRAMISU: 
                precioFinal *= 1.20; 
                break;
            case HELADO: 
                precioFinal *= 1.15; 
                break;
            case FLAN: 
                precioFinal *= 1.10; 
                break;
        }
        
        return precioFinal;
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder(super.toString());
        
        sb.append(" | Tipo: POSTRE | Variedad: ").append(this.tipoPostre);
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
        
        Postre other = (Postre) obj; 
        
        return this.tipoPostre == other.tipoPostre;
    }
    
}
