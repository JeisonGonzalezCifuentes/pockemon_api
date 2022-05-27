package pockemon.api.rest.dtos.pocke.client;

import java.util.List;

public class PokeDetailClientDTO extends PokeClientDTO {
	
	private Integer id;
	private String weight;
	private SpritesDTO sprites;
	private FieldNameDTO species;
	private List<AbilityDTO> abilities;
	private List<TypeDTO> types;
	
	public PokeDetailClientDTO() {
		super();
	}

	public PokeDetailClientDTO(Integer id, String weight, SpritesDTO sprites, FieldNameDTO species,
			List<AbilityDTO> abilities, List<TypeDTO> types) {
		super();
		this.id = id;
		this.weight = weight;
		this.sprites = sprites;
		this.species = species;
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

	public FieldNameDTO getSpecies() {
		return species;
	}

	public List<AbilityDTO> getAbilities() {
		return abilities;
	}

	public List<TypeDTO> getTypes() {
		return types;
	}	
	
}
