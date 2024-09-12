package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {

	private List<Tiquete> tiquetesUsados = new ArrayList<Tiquete>();
	public List<Tiquete> tiquetesSinUsar = new ArrayList<Tiquete>();

	public Cliente () {}
	
	public abstract String getTipoCliente ();
	
	public abstract String getIdentificador ();
	
	public void agregartiquete(Tiquete tiquete) {
		tiquetesSinUsar.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
		int total = 0;
		for(Tiquete tiquete : tiquetesSinUsar) {
			total += tiquete.getTarifa();
		}
		return total;
	}

	public void usarTiquetes(Vuelo vuelo) {
		
		Iterator<Tiquete> iterador = tiquetesSinUsar.iterator();
		while(iterador.hasNext()) {
			Tiquete elemento = iterador.next();
			Vuelo vueloT = elemento.getVuelo();
			if(vueloT.equals(vuelo)) {
				tiquetesUsados.add(elemento);
				elemento.marcarComoUsado();
				iterador.remove();
			}
		}
	}
}
