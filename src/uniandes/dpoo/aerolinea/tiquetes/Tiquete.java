package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	private Cliente cliente;
	
	public Tiquete(String codigo, Vuelo vuelo, Cliente cliente, int tarifa) {
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.cliente = cliente;
		this.vuelo = vuelo;
	}
	

	public Cliente getCliente() {
		return this.cliente;
	}
	
	public Vuelo getVuelo() {
		return this.vuelo;
	}
	
	public int getTarifa() {
		return this.tarifa;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public void marcarComoUsado (){
		usado = true;
	}
	
	public boolean esUsado() {
		return usado;
	}
}
