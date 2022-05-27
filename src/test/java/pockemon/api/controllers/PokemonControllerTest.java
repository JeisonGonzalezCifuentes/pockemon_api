package pockemon.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pockemon.api.fabrica.PokemonDTOFabrica;
import pockemon.api.fabrica.PokemonDetailDTOFabrica;
import pockemon.api.rest.dtos.PokemonDTO;
import pockemon.api.rest.dtos.PokemonDetailDTO;
import pockemon.api.rest.responses.PokemonResponse;
import pockemon.api.services.implementations.BasicPokemonService;

public class PokemonControllerTest {
	
	private final String INTERNAL_ERROR_STATUS = "Internal error, for more details check the application logs.";
	private final String INTERNAL_ERROR_CODE = "500 INTERNAL_SERVER_ERROR";
	private final String INTERNAL_ERROR = "ERROR";
	
	private final String NOT_FOUND_STATUS = "Pokemon not found";
	private final String NOT_FOUND_CODE = "404 NOT_FOUND";
	private final String NOT_FOUND = "NOT_FOUND";
	
	private final String SUCCES_STATUS = "Succes";
	private final String SUCCES_CODE = "200 OK";
	private final String OK = "OK";
	
	private final Integer DEFAULT_LIMIT = 15;
	private final Integer DEFAULT_OFFSET = 0;
	private final Integer DEFAULT_POKEMON_ID = 15;

	@Mock
	BasicPokemonService pokemonService;

	@InjectMocks
	PokemonController pokemonController;
	
	@Test
	public void getAllPokemonsWithoutResults() {
		MockitoAnnotations.initMocks(this);
		
		when(pokemonService.getAll(Optional.of(DEFAULT_LIMIT), Optional.of(DEFAULT_OFFSET)))
		.thenReturn(new ArrayList<PokemonDTO>());
		
		final PokemonResponse<List<PokemonDTO>> response = pokemonController.getAllPokemons(DEFAULT_LIMIT, DEFAULT_OFFSET);

		assertEquals(response.getData().size(), 0);
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), OK);		
	}
	
	@Test
	public void getAllPokemonsWithtResults() {
		MockitoAnnotations.initMocks(this);
		
		final List<PokemonDTO> expectedResult = new ArrayList<PokemonDTO>();
		expectedResult.add(new PokemonDTOFabrica().getDTO());
		expectedResult.add(new PokemonDTOFabrica().getDTO());
		expectedResult.add(new PokemonDTOFabrica().getDTO());
		
		when(pokemonService.getAll(Optional.of(DEFAULT_LIMIT), Optional.of(DEFAULT_OFFSET))).thenReturn(expectedResult);
		
		final PokemonResponse<List<PokemonDTO>> response = pokemonController.getAllPokemons(DEFAULT_LIMIT, DEFAULT_OFFSET);

		assertEquals(response.getData().size(), 3);
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), OK);		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getAllPokemonsWithtInternalError() {
		MockitoAnnotations.initMocks(this);
		
		when(pokemonService.getAll(Optional.of(DEFAULT_LIMIT), Optional.of(DEFAULT_OFFSET)))
		.thenThrow(NullPointerException.class);
		
		final PokemonResponse<List<PokemonDTO>> response = pokemonController.getAllPokemons(DEFAULT_LIMIT, DEFAULT_OFFSET);

		assertNull(response.getData());
		assertEquals(response.getStatus(), INTERNAL_ERROR_STATUS);
		assertEquals(response.getCode(), INTERNAL_ERROR_CODE);
		assertEquals(response.getMessage(), INTERNAL_ERROR);		
	}
	
	@Test
	public void getPokemonDetail() {
		MockitoAnnotations.initMocks(this);

		when(pokemonService.getPokemonDetail(DEFAULT_POKEMON_ID)).thenReturn(Optional.of(new PokemonDetailDTOFabrica().getDTO()));
		
		final PokemonResponse<PokemonDetailDTO> response = pokemonController.getPokemon(DEFAULT_POKEMON_ID);

		assertNotNull(response.getData());
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), OK);		
	}
	
	@Test
	public void getPokemonWithoutDetail() {
		MockitoAnnotations.initMocks(this);

		when(pokemonService.getPokemonDetail(DEFAULT_POKEMON_ID)).thenReturn(Optional.empty());
		
		final PokemonResponse<PokemonDetailDTO> response = pokemonController.getPokemon(DEFAULT_POKEMON_ID);

		assertNull(response.getData());
		assertEquals(response.getStatus(), NOT_FOUND_STATUS);
		assertEquals(response.getCode(), NOT_FOUND_CODE);
		assertEquals(response.getMessage(), NOT_FOUND);	
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getPokemonDetailWithtInternalError() {
		MockitoAnnotations.initMocks(this);
		
		when(pokemonService.getPokemonDetail(DEFAULT_POKEMON_ID))
		.thenThrow(NullPointerException.class);
		
		final PokemonResponse<PokemonDetailDTO> response = pokemonController.getPokemon(DEFAULT_POKEMON_ID);

		assertNull(response.getData());
		assertEquals(response.getStatus(), INTERNAL_ERROR_STATUS);
		assertEquals(response.getCode(), INTERNAL_ERROR_CODE);
		assertEquals(response.getMessage(), INTERNAL_ERROR);		
	}

}
