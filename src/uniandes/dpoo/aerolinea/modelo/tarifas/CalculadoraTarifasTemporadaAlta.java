package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.*;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;


public class CalculadoraTarifasTemporadaAlta {

	private static int COSTO_POR_KM = 1000;

	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {

		Ruta ruta = vuelo.getRuta();
		int distancia = Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());
		return COSTO_POR_KM * distancia;

	}

	public double calcularPorcentajeDescuento(Cliente cliente) {
		return 0;
	}
}
