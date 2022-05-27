package pockemon.api.rest.dtos;

public class PokemonDetailDTO extends PokemonDTO {

	private String description;
	private EvolutionDTO evolutions;
	
	public PokemonDetailDTO() {
		super();
	}

	public PokemonDetailDTO(PokemonDTO pokemon, String description, EvolutionDTO evolutions) {
		super(pokemon.getId(), pokemon.getImageUrl(), pokemon.getName(), pokemon.getWeight(), 
				pokemon.getTypes(), pokemon.getAbilities());
		
		this.description = description;
		this.evolutions = evolutions;
	}

	public String getDescription() {
		return description;
	}

	public EvolutionDTO getEvolutions() {
		return evolutions;
	}
	
}
