package pockemon.api.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pockemon.api.rest.dtos.PokemonDTO;
import pockemon.api.rest.dtos.PokemonDetailDTO;
import pockemon.api.rest.responses.PokemonResponse;
import pockemon.api.services.PokemonService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/pokemon/v1")
public class PokemonController {

	@Autowired
	PokemonService pokemonService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "get-all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PokemonResponse<List<PokemonDTO>> getAllPokemons(@RequestParam(required = false) Integer limit,
			@RequestParam(required = false) Integer offset) {
		try {
			logger.info(String.format("Getting pokemons wit limit %s and offset %s", limit, offset));
			
			final List<PokemonDTO> pokemons = pokemonService.getAll(Optional.ofNullable(limit), Optional.ofNullable(offset));
			return new PokemonResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", pokemons);
		} catch (Exception exception) {
			logger.error("Error executing request: ", exception);
			return new PokemonResponse<>("Internal error, for more details check the application logs.", 
					String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), "ERROR");
		}
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "{pokemonId}/detail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PokemonResponse<PokemonDetailDTO> getPokemon(@PathVariable("pokemonId") int pokemonId) {
		try {
			logger.info(String.format("Getting pokemon wit id: %s", pokemonId));
			
			return pokemonService.getPokemonDetail(pokemonId)
			.map(pokemonDetail -> new PokemonResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", pokemonDetail))
			.orElse(new PokemonResponse<>("Pokemon not found", String.valueOf(HttpStatus.NOT_FOUND), "NOT_FOUND"));
		} catch (Exception exception) {
			logger.error("Error executing request: ", exception);
			return new PokemonResponse<>("Internal error, for more details check the application logs.", 
					String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), "ERROR");
		}
	}
	
}
