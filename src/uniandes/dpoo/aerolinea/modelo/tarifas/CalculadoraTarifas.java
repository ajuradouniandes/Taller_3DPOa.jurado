package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.cliente.*;
import uniandes.dpoo.aerolinea.modelo.*;

public abstract class CalculadoraTarifas {
	
	private static double IMPUESTO = 0.28;
	
	public int CalcularTarifa (Vuelo vuelo, Cliente cliente) {
		int base = CalcularCostoBase(vuelo, cliente);
		int por_descuento = CalcularPorcentajeDescuento(cliente);
		int impuesto = CalcularValorImpuestos(base);
		
		return (int) (base * (1-por_descuento)) + impuesto;
	}
	
	public abstract int CalcularCostoBase(Vuelo vuelo, Cliente cliente);
	
	public abstract int CalcularPorcentajeDescuento(Cliente cliente);
	
	public int CalcularDistanciaVuelo (Ruta ruta) {

		Aeropuerto aero1 = ruta.getOrigen();
		Aeropuerto aero2 = ruta.getDestino();
		
		int distancia = Aeropuerto.calcularDistancia(aero1, aero2);
		return distancia;

	}
	
	public int CalcularValorImpuestos(int costoBase) {
		return (int) (costoBase * IMPUESTO);
	}
	
}
