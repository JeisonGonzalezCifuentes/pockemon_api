package pockemon.api.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pockemon.api.rest.dtos.PokemonDTO;
import pockemon.api.rest.dtos.pocke.api.GetAllDTO;
import pockemon.api.rest.dtos.pocke.api.PokemonDetailDTO;
import pockemon.api.services.PokemonService;

@Service
public class BasicPokemonService implements PokemonService {
	

	private final RestTemplate restTemplate = new RestTemplate();
	
	private final String URL_BASE_ORIGIN = "https://pokeapi.co/api/v2/";
	private final String URL_GET_ALL_POKEMONS = "%spokemon?limit=%s&offset=%s";
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<PokemonDTO> getAll(Optional<Integer> limitOptional, Optional<Integer> offsetOptional) {
		try {
			String url = getUrl(limitOptional, offsetOptional);
			
			logger.warn(String.format("Going to external PokeAPI with url: %s", url));
			final GetAllDTO pokeResponse = restTemplate.getForObject(url, GetAllDTO.class);
			
			logger.info("pokeResponse: " + pokeResponse);
			
			final List<PokemonDTO> result = pokeResponse.getResults().stream().map(pokeResult -> {
				logger.warn(String.format("Going to external PokeAPI for details: %s", pokeResult.getUrlDetail()));
				final PokemonDetailDTO pokeDetail = restTemplate.getForObject(pokeResult.getUrlDetail(), PokemonDetailDTO.class);
				
				logger.info("pokeResponse: " + pokeDetail);
				
				// TODO build the type and ability list 
				return new PokemonDTO(pokeDetail.getId(), pokeDetail.getSprites().getFront_default(), pokeResult.getName(), 
						pokeDetail.getWeight(), new ArrayList<>(), new ArrayList<>());
			}).toList();

			return result;
		} catch (Exception exception) {
			logger.error("Error going to external PokeAPI", exception);
			return new ArrayList<>();
		}
	}


	private String getUrl(Optional<Integer> limitOptional, Optional<Integer> offsetOptional) {
		final Integer limitValidated = limitOptional.orElse(2);
		final Integer offsetValidated = offsetOptional.orElse(0);
		
		return String.format(URL_GET_ALL_POKEMONS, URL_BASE_ORIGIN, limitValidated, offsetValidated);
	}

}
