package pockemon.api.rest.dtos.pocke.client;

import com.fasterxml.jackson.annotation.JsonAlias;

public class EvolutionDetailDTO {

	@JsonAlias("min_level")
	private Integer minLevel;
	
	public EvolutionDetailDTO() {
		super();
	}

	public EvolutionDetailDTO(Integer minLevel) {
		super();
		this.minLevel = minLevel;
	}

	public Integer getMinLevel() {
		return minLevel;
	}

}
