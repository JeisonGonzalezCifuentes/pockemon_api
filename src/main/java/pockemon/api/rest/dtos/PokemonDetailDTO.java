package pockemon.api.rest.dtos;

import java.util.List;

public class PokemonDetailDTO extends PokemonDTO {

	private String description;
	private List<EvolutionDTO> evolutions;
	
	public PokemonDetailDTO() {
		super();
	}

	public PokemonDetailDTO(PokemonDTO pokemon, String description, List<EvolutionDTO> evolutions) {
		super(pokemon.getId(), pokemon.getImageUrl(), pokemon.getName(), pokemon.getWeight(), 
				pokemon.getTypes(), pokemon.getAbilities());
		
		this.description = description;
		this.evolutions = evolutions;
	}

	public String getDescription() {
		return description;
	}

	public List<EvolutionDTO> getEvolutions() {
		return evolutions;
	}

	@Override
	public String toString() {
		return "PokemonDetailDTO [description=" + description + ", evolutions=" + evolutions + "]";
	}
	
}
