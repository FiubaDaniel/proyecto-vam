package com.daniel.model;

import java.util.Map;

public class MaquinaDeEstado {

	private static Map<IdEstado, EstadoDeRegistro> tabla;

	public MaquinaDeEstado() {

		tabla.put(IdEstado.FIRMARYRETIRAR, new FirmarYRetirar());
		tabla.put(IdEstado.FIRMAR, new Firmar());
		tabla.put(IdEstado.DEJAR, new Dejar());
		tabla.put(IdEstado.RETIRAR, new Retirar());
		tabla.put(IdEstado.TERMINAR, new Terminado());

	}

	public static boolean modificarEstado(Registro registro, IdEstado id) {

		if (registro.getEstados().size() >= 2) {
			modificarEstado(registro, id, false);
			return true;
		} else if (registro.getEstadoActual().getIdEstado().getAtributo()
				.compareTo(IdEstado.TERMINAR.getAtributo()) != 0) {
			if (id.getAtributo().compareTo(
					IdEstado.FIRMARYRETIRAR.getAtributo()) == 0) {
				registro.setEstadoActual(tabla.get(id));
				return true;
			} else if (id.getAtributo()
					.compareTo(IdEstado.FIRMAR.getAtributo()) == 0
					&& registro.getEstadoActual().getIdEstado().getAtributo()
							.compareTo(IdEstado.FIRMARYRETIRAR.getAtributo()) == 0) {
				registro.setEstadoActual(tabla.get(id));
				return true;
			} else if (id.getAtributo().compareTo(
					IdEstado.RETIRAR.getAtributo()) == 0
					&& (registro.getEstadoActual().getIdEstado().getAtributo()
							.compareTo(IdEstado.FIRMARYRETIRAR.getAtributo()) == 0 || registro
							.getEstadoActual().getIdEstado().getAtributo()
							.compareTo(IdEstado.DEJAR.getAtributo()) == 0)) {
				registro.setEstadoActual(tabla.get(id));
				return true;
			} else if (id.getAtributo().compareTo(IdEstado.DEJAR.getAtributo()) == 0) {
				registro.setEstadoActual(tabla.get(id));
				return true;
			} else if (id.getAtributo().compareTo(
					IdEstado.TERMINAR.getAtributo()) == 0) {
				modificarEstado(registro, id, false);
				return true;
			}
		}
		return false;
	}

	public static void modificarEstado(Registro registro, IdEstado id,
			boolean finalizoOk) {

		modificarEstado(registro, id);
		Terminado estado = (Terminado) registro.getEstadoActual();
		estado.setExito(finalizoOk);
	}
}
