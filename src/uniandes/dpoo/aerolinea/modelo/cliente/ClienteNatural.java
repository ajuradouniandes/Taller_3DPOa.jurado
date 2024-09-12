package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente{
	public static String NATURAL = "natural";
	private String nombre;
	
	public ClienteNatural(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String getIdentificador() {
        int hash = nombre.hashCode();
        hash = Math.abs(hash);
        String codigo = String.format("%05d", hash % 100000);
        return codigo;
	}

	@Override
	public String getTipoCliente() {
		return NATURAL;
	}
	
}
