package pockemon.api.services;

import java.util.List;
import java.util.Optional;

import pockemon.api.rest.dtos.PokemonDTO;
import pockemon.api.rest.dtos.PokemonDetailDTO;

public interface PokemonService {

	public List<PokemonDTO> getAll(Optional<Integer> limit, Optional<Integer> offset);
	public Optional<PokemonDetailDTO> getPokemonDetail(int pokemonId);

}
