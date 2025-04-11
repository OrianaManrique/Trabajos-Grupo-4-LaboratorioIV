package Ejercicio2;

public class ProductoFresco extends Producto {
  
	private String fechaDeEnvasado;
	private String paisDeOrigen;
	
	public String getFechaEnvasado() {
		return fechaDeEnvasado;
	}
	public void setFechaEnvasado(String fechaEnvasado) {
		this.fechaDeEnvasado = fechaEnvasado;
	}
	public String getPaisDeOrigen() {
		return paisDeOrigen;
	}
	public void setPaisDeOrigen(String paisDeOrigen) {
		this.paisDeOrigen = paisDeOrigen;
	}
	
	public ProductoFresco() {		
		super();
	    this.paisDeOrigen = "Sin Pais";
	    this.fechaDeEnvasado = "0/0/0";
	}
	
	public ProductoFresco(String fechaCaducidad , int NumeroLote , String fechadeEnvasado, String PaisOrigen) {		
		super(fechaCaducidad , NumeroLote);
		this.fechaDeEnvasado = fechadeEnvasado;
	    this.paisDeOrigen = PaisOrigen;    
	}
	
	@Override
	public String toString() {
		return "Producto Fresco | Fecha de caducidad: " + getFechaCaducidad() + 
				" | Número de lote: " + getNumeroLote() + 
				" | Fecha de envasado: " + fechaDeEnvasado + 
				"| País de origen: " + paisDeOrigen;
	}

}
