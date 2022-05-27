package pockemon.api.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pockemon.api.rest.dtos.EvolutionDTO;
import pockemon.api.rest.dtos.PokemonDTO;
import pockemon.api.rest.dtos.PokemonDetailDTO;
import pockemon.api.rest.dtos.pocke.client.EvolutionChainDTO;
import pockemon.api.rest.dtos.pocke.client.GetAllDTO;
import pockemon.api.rest.dtos.pocke.client.PokeDetailClientDTO;
import pockemon.api.rest.dtos.pocke.client.SpecieDTO;
import pockemon.api.rest.dtos.pocke.client.PokeClientDTO;
import pockemon.api.services.PokeClientService;
import pockemon.api.services.PokemonService;

@SuppressWarnings("unchecked")
@Service
public class BasicPokemonService implements PokemonService {

	private static final String URL_BASE_ORIGIN = "https://pokeapi.co/api/v2/";
	private static final String URL_GET_ALL_POKEMONS = "%spokemon?limit=%s&offset=%s";
	private static final String URL_GET_POKEMON_DETAIL = "%spokemon/%s";

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("rawtypes")
	@Autowired
	private PokeClientService pokeClientService;

	@Cacheable("pokemons")
	@Override
	public List<PokemonDTO> getAll(Optional<Integer> limitOptional, Optional<Integer> offsetOptional) {
		try {
			String url = buildUrlToGetAllPokemons(limitOptional, offsetOptional);

			final GetAllDTO pokemons = (GetAllDTO) pokeClientService.callService(GetAllDTO.class, url).getBody();

			logger.info(String.format("Response of external API (%s): %s", url, pokemons));
			return getPokemonsDetail(pokemons);
		} catch (Exception exception) {
			logger.error("Error going to external PokeAPI", exception);
			return new ArrayList<>();
		}
	}

	@Cacheable(value = "pokemon", key = "#pokemonId")
	@Override
	public Optional<PokemonDetailDTO> getPokemonDetail(int pokemonId) {
		try {
			final PokeDetailClientDTO pokemonDetailClient = (PokeDetailClientDTO) pokeClientService
					.callService(PokeDetailClientDTO.class, buildUrlToGetPokemon(pokemonId)).getBody();

			return Optional.of(getDetailWithDescriptionAndEvolution(pokemonDetailClient));
		} catch (Exception exception) {
			logger.error("Error getting pokemon", exception);
			return Optional.empty();
		}
	}

	private PokemonDetailDTO getDetailWithDescriptionAndEvolution(final PokeDetailClientDTO pokemonDetailClient) {
		return Optional.of(pokemonDetailClient.getSpecies()).map(referenceToSpecie -> {
			final SpecieDTO specie = (SpecieDTO) pokeClientService
					.callService(SpecieDTO.class, referenceToSpecie.getUrl()).getBody();

			final EvolutionDTO evolutions = getEvolutions(specie.getEvolutionChain().getUrl());
			return new PokemonDetailDTO(new PokemonDTO(pokemonDetailClient), specie.getDescription(), evolutions);
		}).orElse(new PokemonDetailDTO(new PokemonDTO(pokemonDetailClient), null, null));
	}

	private EvolutionDTO getEvolutions(String urlEvolutions) {
		final EvolutionChainDTO evolutionChain = (EvolutionChainDTO) pokeClientService
				.callService(EvolutionChainDTO.class, urlEvolutions).getBody();

		logger.debug("Evolutions: " + evolutionChain);
		return new EvolutionDTO(evolutionChain.getChain());
	}

	private List<PokemonDTO> getPokemonsDetail(final GetAllDTO pokeResults) {
		return pokeResults.getResults().stream().map(pokeResult -> {
			return getPokemonDetailClient(pokeResult);
		}).collect(Collectors.toList());
	}

	private PokemonDTO getPokemonDetailClient(PokeClientDTO pokemon) {
		final PokeDetailClientDTO pokemonDetail = (PokeDetailClientDTO) pokeClientService
				.callService(PokeDetailClientDTO.class, pokemon.getUrlDetail()).getBody();

		return new PokemonDTO(pokemonDetail);
	}

	private String buildUrlToGetAllPokemons(Optional<Integer> limitOptional, Optional<Integer> offsetOptional) {
		final Integer limitValidated = limitOptional.orElse(20);
		final Integer offsetValidated = offsetOptional.orElse(0);

		return String.format(URL_GET_ALL_POKEMONS, URL_BASE_ORIGIN, limitValidated, offsetValidated);
	}

	private String buildUrlToGetPokemon(int pokemonId) {
		return String.format(URL_GET_POKEMON_DETAIL, URL_BASE_ORIGIN, pokemonId);
	}

}