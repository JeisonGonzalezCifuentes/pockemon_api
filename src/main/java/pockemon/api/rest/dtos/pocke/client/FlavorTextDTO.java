package pockemon.api.rest.dtos.pocke.client;

import com.fasterxml.jackson.annotation.JsonAlias;

public class FlavorTextDTO {
	
	@JsonAlias("flavor_text")
	private String flavorText;
	private FieldNameDTO language;
	
	public FlavorTextDTO() {
		super();
	}
	
	public FlavorTextDTO(String flavorText, FieldNameDTO language) {
		super();
		this.flavorText = flavorText;
		this.language = language;
	}

	public String getFlavorText() {
		return flavorText;
	}

	public FieldNameDTO getLanguage() {
		return language;
	}
	
}
