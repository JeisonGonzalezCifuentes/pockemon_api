package pockemon.api.fabrica;

import java.util.ArrayList;
import java.util.List;

import pockemon.api.rest.dtos.PokemonDTO;

public class PokemonDTOFabrica {

	private Integer id;
	private String imageUrl;
	private String name;
	private String weight;
	
	private List<String> types;
	private List<String> abilities;
	
	public PokemonDTOFabrica() {
		this.id = 1;
		this.imageUrl = "image.png";
		this.name = "name";
		this.weight = "50";
		this.types = new ArrayList<>();
		this.abilities = new ArrayList<>();
		
	}
	
	public PokemonDTO getDTO() {
		return new PokemonDTO(id, imageUrl, name, weight, types, abilities);
	}	
	
}
