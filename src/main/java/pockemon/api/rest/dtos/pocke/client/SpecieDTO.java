package pockemon.api.rest.dtos.pocke.client;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonAlias;

public class SpecieDTO {

	@JsonAlias("evolution_chain")
	private FieldNameDTO evolutionChain;
	
	@JsonAlias("flavor_text_entries")
	private List<FlavorTextDTO> flavorTextEntries;

	public SpecieDTO() {
		super();
	}

	public SpecieDTO(FieldNameDTO evolutionChain, List<FlavorTextDTO> flavorTextEntries) {
		super();
		this.evolutionChain = evolutionChain;
		this.flavorTextEntries = flavorTextEntries;
	}

	public FieldNameDTO getEvolutionChain() {
		return evolutionChain;
	}

	public List<FlavorTextDTO> getFlavorTextEntries() {
		return flavorTextEntries;
	}

	public String getDescription() {
		final Set<String> descriptionSet = getFlavorTextEntries().stream()
				.filter(flavorText -> flavorText.getLanguage().getName().equals("en"))
				.map(flavorEnglishText -> flavorEnglishText.getFlavorText()).collect(Collectors.toSet());
		
		return String.join(". ", descriptionSet);		 
	}
	
}
