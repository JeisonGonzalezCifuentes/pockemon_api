package pockemon.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import pockemon.api.rest.dtos.PokemonDTO;
import pockemon.api.rest.dtos.pocke.client.GetAllDTO;
import pockemon.api.rest.dtos.pocke.client.PokeDetailClientDTO;
import pockemon.api.services.implementations.BasicPokeClientService;
import pockemon.api.services.implementations.BasicPokemonService;

public class BasicPokemonServiceTest<T> {

	private final Integer DEFAULT_LIMIT = 15;
	private final Integer DEFAULT_OFFSET = 0;

	@Mock
	BasicPokeClientService<GetAllDTO> pokeClientService;

	@Mock
	BasicPokeClientService<PokeDetailClientDTO> pokeClientServiceDetail;

	@InjectMocks
	BasicPokemonService pokemonService;
	
	@SuppressWarnings("unchecked")
	@Test
	public void getAllPokemonsWithoutResults() {
		MockitoAnnotations.initMocks(this);
		
		final ResponseEntity<GetAllDTO> expectedResponse = new ResponseEntity<>(new GetAllDTO(new ArrayList<>()), HttpStatus.OK);
		
		when(pokeClientService.callService(any(), anyString()))
		.thenReturn((ResponseEntity<GetAllDTO>) expectedResponse);
		
		final List<PokemonDTO> response = pokemonService.getAll(Optional.of(DEFAULT_LIMIT), Optional.of(DEFAULT_OFFSET));

		assertTrue(response.isEmpty());	
	}
	
}
