package pockemon.api.fabrica;

import pockemon.api.rest.dtos.EvolutionDTO;

public class EvolutionDTOFabrica {

	private Integer minLevel;
	private EvolutionDTO evolvesTo;
	
	public EvolutionDTOFabrica(Integer minLevel) {
		this.minLevel = 1;
		this.evolvesTo = minLevel > 5 ? new EvolutionDTOFabrica(minLevel + 1).getDTO() : null;
	}
	
	public EvolutionDTO getDTO() {
		return new EvolutionDTO(minLevel, evolvesTo);
	}

}
