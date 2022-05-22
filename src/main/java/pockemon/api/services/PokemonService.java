package pockemon.api.services;

import java.util.List;
import java.util.Optional;

import pockemon.api.rest.dtos.PokemonDTO;

public interface PokemonService {

	public List<PokemonDTO> getAll(Optional<Integer> limit, Optional<Integer> offset);

}
