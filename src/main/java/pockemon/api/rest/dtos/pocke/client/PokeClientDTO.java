package pockemon.api.rest.dtos.pocke.client;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PokeClientDTO {

	private String name;
	
	@JsonAlias("url")
	private String urlDetail;
	
	public PokeClientDTO() {
		super();
	}

	public PokeClientDTO(String name, String url) {
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
	
}
