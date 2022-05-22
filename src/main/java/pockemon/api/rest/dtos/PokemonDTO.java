package pockemon.api.rest.dtos;

import java.util.List;

import pockemon.api.rest.dtos.pocke.api.FieldNameDTO;

public class PokemonDTO {

	private Integer id;
	private String imageUrl;
	private String name;
	private String weight;
	
	private List<FieldNameDTO> types;
	private List<FieldNameDTO> abilities;
	
	public PokemonDTO() {
		super();
	}

	public PokemonDTO(Integer id, String imageUrl, String name, String weight, List<FieldNameDTO> types,
			List<FieldNameDTO> abilities) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.name = name;
		this.weight = weight;
		this.types = types;
		this.abilities = abilities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public List<FieldNameDTO> getTypes() {
		return types;
	}

	public void setTypes(List<FieldNameDTO> types) {
		this.types = types;
	}

	public List<FieldNameDTO> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<FieldNameDTO> abilities) {
		this.abilities = abilities;
	}
	
}
