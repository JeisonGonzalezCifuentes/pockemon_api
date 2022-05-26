package pockemon.api.services.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pockemon.api.services.PokeClientService;

@Service
public class BasicPokeClientService<T> implements PokeClientService<T> {
	
	private final RestTemplate restTemplate = new RestTemplate();

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public ResponseEntity<T> callService(final Class<T> tipoDeClaseRetorno, final String url) {

		logger.warn(String.format("Going to external PokeAPI with url: %s", url));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Application");
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		return restTemplate.exchange(url, HttpMethod.GET, entity, tipoDeClaseRetorno);
	}
	
}
