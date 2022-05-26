package pockemon.api.services.implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pockemon.api.rest.dtos.PokemonDTO;
import pockemon.api.rest.dtos.pocke.client.GetAllDTO;
import pockemon.api.rest.dtos.pocke.client.PokeDetailClientDTO;
import pockemon.api.rest.dtos.pocke.client.PokeClientDTO;
import pockemon.api.services.PokeClientService;
import pockemon.api.services.PokemonService;

@Service
public class BasicPokemonService implements PokemonService {
	
	private final String URL_BASE_ORIGIN = "https://pokeapi.co/api/v2/";
	private final String URL_GET_ALL_POKEMONS = "%spokemon?limit=%s&offset=%s";
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private PokeClientService pokeClientService;

	@Cacheable("pokemons")
	@Override
	public List<PokemonDTO> getAll(Optional<Integer> limitOptional, Optional<Integer> offsetOptional) {
		try {
			String url = getUrlToGetAllPokemons(limitOptional, offsetOptional);
			
			final GetAllDTO pokemons = (GetAllDTO) pokeClientService.callService(GetAllDTO.class, url).getBody();
			
			logger.info(String.format("Response of external API (%s): %s", url, pokemons));
			return getPokemonsDetail(pokemons);
		} catch (Exception exception) {
			logger.error("Error going to external PokeAPI", exception);
			return new ArrayList<>();
		}
	}


	private List<PokemonDTO> getPokemonsDetail(final GetAllDTO pokeResults) {
		return pokeResults.getResults().stream().map(pokeResult -> {
			return getPokemonDetail(pokeResult);
		}).collect(Collectors.toList());
	}


	private PokemonDTO getPokemonDetail(PokeClientDTO pokemon) {		
		final PokeDetailClientDTO pokemonDetail = 
				(PokeDetailClientDTO) pokeClientService.callService(PokeDetailClientDTO.class, pokemon.getUrlDetail()).getBody();
				
		final List<String> abilities = pokemonDetail.getAbilities().stream().map(ability -> ability.getAbilityName().getName())
				.collect(Collectors.toList());
		final List<String> types = pokemonDetail.getTypes().stream().map(type -> type.getTypeName().getName())
				.collect(Collectors.toList());
		
		return new PokemonDTO(pokemonDetail.getId(), pokemonDetail.getSprites().getFront_default(), pokemon.getName(), 
				pokemonDetail.getWeight(), types, abilities);
	}


	private String getUrlToGetAllPokemons(Optional<Integer> limitOptional, Optional<Integer> offsetOptional) {
		final Integer limitValidated = limitOptional.orElse(2);
		final Integer offsetValidated = offsetOptional.orElse(0);
		
		return String.format(URL_GET_ALL_POKEMONS, URL_BASE_ORIGIN, limitValidated, offsetValidated);
	}

}
