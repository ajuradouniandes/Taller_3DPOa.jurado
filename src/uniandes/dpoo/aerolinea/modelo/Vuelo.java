package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.Map;

import java.util.Random;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;

public class Vuelo {
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Map<String,Tiquete>Tiquetes;
	
	public Vuelo(String fecha, Ruta ruta, Avion avion) {
		this.fecha = fecha;
		this.ruta = ruta;
		this.avion = avion;
	}
	
	public Ruta getRuta() {
		return this.ruta;
	}
	
	public String getFecha() {
		return this.fecha;
	}
	
	public Avion getAvion() {
		return this.avion;
	}
	
	public Collection<Tiquete> getTiquetes () {
		Collection <Tiquete> listaTiquetes = Tiquetes.values();
		return listaTiquetes;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
		
		int total = 0;
		int i = 0;
		while(i <= cantidad) {
			String codigo = generarCodigo();
			if(!Tiquetes.containsKey(codigo)) {
				int tarifa = calculadora.CalcularTarifa(this,cliente);
				Tiquete nuevo_tiquete = new Tiquete(codigo, this, cliente, tarifa);
				Tiquetes.put(codigo, nuevo_tiquete);
				total += tarifa;
			}
		}
		return total;
	}

    public static String generarCodigo() {
        Random random = new Random();
        int codigo = 10000 + random.nextInt(90000); // Genera un número entre 10000 y 99999
        return String.format("%05d", codigo);
    }
    
    public boolean equals(Object obj) {
    	return this == obj;
    }
    
	
}
