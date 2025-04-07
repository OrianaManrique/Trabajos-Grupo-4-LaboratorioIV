package Ejercicio2;

public class Producto {
	
    private String fechaCaducidad;
    private int numeroLote;

    public Producto(String fechaCaducidad, int numeroLote) {
        this.fechaCaducidad = fechaCaducidad;
        this.numeroLote = numeroLote;
    }
    
    public Producto()
	{
    	this.fechaCaducidad = "0/0/0000";
    	this.numeroLote = 0;		
	}

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public int getNumeroLote() {
        return numeroLote;
    }
    
    
    @Override
    public String toString() {
        return "Fecha de caducidad: " + fechaCaducidad + ", Lote: " + numeroLote;
    }
}