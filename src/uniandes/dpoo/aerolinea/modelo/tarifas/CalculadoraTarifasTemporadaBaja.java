package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.*;
import uniandes.dpoo.aerolinea.modelo.cliente.*;

public class CalculadoraTarifasTemporadaBaja {
	private static int COSTO_POR_KM_NATURAL = 600;
	private static int COSTO_POR_KM_CORPORATIVO = 900;
	private static double DESCUENTO_PEQ = 0.02;
	private static double DESCUENTO_MEDIANAS = 0.1;
	private static double DESCUENTO_GRANDES = 0.2;
	

	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		Ruta ruta = vuelo.getRuta();
		int distancia = Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());
		int costo = 0;
		switch (cliente.getTipoCliente()){
			case "corporativo":
				costo = COSTO_POR_KM_CORPORATIVO * distancia;
				break;
			case "natural":
				costo = COSTO_POR_KM_NATURAL * distancia;
				break;
		}
		
		return costo;
	}

	public double calcularPorcentajeDescuento(Cliente cliente) {
		if(cliente.getTipoCliente() == "natural") {
			return 0;
		}
		switch(((ClienteCorporativo) cliente).geTamanioEmpresa()) {
		case 1:
			return DESCUENTO_GRANDES;
		case 2:
    		return DESCUENTO_MEDIANAS;
    	default:
    		return DESCUENTO_PEQ;
		}
	}

}
