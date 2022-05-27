package pockemon.api.rest.dtos;

import pockemon.api.rest.dtos.pocke.client.ChainDTO;

public class EvolutionDTO {

	private Integer minLevel;
	private EvolutionDTO evolvesTo;

	public EvolutionDTO() {
		super();
	}

	public EvolutionDTO(Integer minLevel, EvolutionDTO evolvesTo) {
		super();
		this.minLevel = minLevel;
		this.evolvesTo = evolvesTo;
	}

	public EvolutionDTO(ChainDTO chain) {
		super();
		minLevel = getMinLevel(chain);
		evolvesTo = chain.getEvolvesTo().stream().findFirst().map(chainNested -> new EvolutionDTO(chainNested)).orElse(null);
	}

	public Integer getMinLevel() {
		return minLevel;
	}

	public Integer getMinLevel(ChainDTO chain) {
		return chain.getEvolutionDetails().stream().findFirst().map(detail -> detail.getMinLevel()).orElse(0);
	}

	public EvolutionDTO getEvolvesTo() {
		return evolvesTo;
	}

}
