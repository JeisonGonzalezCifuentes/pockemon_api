package pockemon.api.rest.dtos.pocke.api;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PokemonDTO {

	private String name;
	
	@JsonAlias("url")
	private String urlDetail;
	
	public PokemonDTO() {
		super();
	}

	public PokemonDTO(String name, String url) {
		super();
		this.name = name;
		this.urlDetail = url;
	}

	public String getName() {
		return name;
	}

	public String getUrlDetail() {
		return urlDetail;
	}

	@Override
	public String toString() {
		return "PokemonDTO [name=" + name + ", urlDetail=" + urlDetail + "]";
	}
	
}
