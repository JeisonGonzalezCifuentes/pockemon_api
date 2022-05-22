package pockemon.api.rest.dtos.pocke.api;

import java.util.List;

public class PokemonDetailDTO {
	
	private Integer id;
	private String weight;
	private SpritesDTO sprites;
	private List<AbilityDTO> abilities;
	private List<TypeDTO> types;
	
	public PokemonDetailDTO() {
		super();
	}
	
	public PokemonDetailDTO(Integer id, String weight, SpritesDTO sprites, List<AbilityDTO> abilities, List<TypeDTO> types) {
		super();
		this.weight = weight;
		this.sprites = sprites;
		this.abilities = abilities;
		this.types = types;
	}
	
	public Integer getId() {
		return id;
	}

	public String getWeight() {
		return weight;
	}
	
	public SpritesDTO getSprites() {
		return sprites;
	}
	
	public List<AbilityDTO> getAbilities() {
		return abilities;
	}
	
	public List<TypeDTO> getTypes() {
		return types;
	}	
	
}
