package pockemon.api.services;

import org.springframework.http.ResponseEntity;

public interface PokeClientService<T> {

	public ResponseEntity<T> callService(final Class<T> tipoDeClaseRetorno, final String url);
	
}
