package pockemon.api.rest.dtos.pocke.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ChainDTO {
	 
	@JsonAlias("evolution_details")
	private List<EvolutionDetailDTO> evolutionDetails;
	
	@JsonAlias("evolves_to")
	private List<ChainDTO> evolvesTo;
	
	private boolean isBaby;

	public ChainDTO() {
		super();
	}

	public ChainDTO(List<EvolutionDetailDTO> evolutionDetails, List<ChainDTO> evolvesTo, boolean isBaby) {
		super();
		this.evolutionDetails = evolutionDetails;
		this.evolvesTo = evolvesTo;
		this.isBaby = isBaby;
	}

	public List<EvolutionDetailDTO> getEvolutionDetails() {
		return evolutionDetails;
	}

	public List<ChainDTO> getEvolvesTo() {
		return evolvesTo;
	}

	public boolean isBaby() {
		return isBaby;
	}
	
}
