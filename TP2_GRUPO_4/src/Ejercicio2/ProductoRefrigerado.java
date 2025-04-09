package Ejercicio2;

public class ProductoRefrigerado extends Producto {
		  
		private String CodOrganismo;
		
		public String getCodOrganismo() {
			return CodOrganismo;
		}

		public void setCodOrganismo(String codOrganismo) {
			CodOrganismo = codOrganismo;
		}

		public ProductoRefrigerado() {		
			super();
		    CodOrganismo = "0000Cod";
		}
		
		public ProductoRefrigerado(String fechaCaducidad , int NumeroLote, String codigo) {		
			super(fechaCaducidad , NumeroLote);
			this.CodOrganismo = codigo;
		}

		@Override
		public String toString() {
			return "ProductoRefrigerado | Fecha de caducidad: " + getFechaCaducidad() +
					"| Número de lote: " + getNumeroLote() + 
					" | Código del organismo de supervisión alimentaria: " + getCodOrganismo();
		}
	
		
		
}
