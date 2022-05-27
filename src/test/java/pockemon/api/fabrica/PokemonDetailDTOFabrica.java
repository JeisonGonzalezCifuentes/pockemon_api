package pockemon.api.fabrica;

import pockemon.api.rest.dtos.EvolutionDTO;
import pockemon.api.rest.dtos.PokemonDetailDTO;

public class PokemonDetailDTOFabrica {

	private String description;
	private EvolutionDTO evolutions;
	
	public PokemonDetailDTOFabrica() {
		this.description = "Any description";
		this.evolutions = new EvolutionDTOFabrica(3).getDTO();
	}
	
	public PokemonDetailDTO getDTO() {
		return new PokemonDetailDTO(new PokemonDTOFabrica().getDTO(), description, evolutions);
	}
	
}
