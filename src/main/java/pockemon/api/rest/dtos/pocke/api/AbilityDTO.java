package pockemon.api.rest.dtos.pocke.api;

import com.fasterxml.jackson.annotation.JsonAlias;

public class AbilityDTO {

	@JsonAlias("ability")
	private FieldNameDTO abilityName;

	public AbilityDTO() {
		super();
	}

	public AbilityDTO(FieldNameDTO abilityName) {
		super();
		this.abilityName = abilityName;
	}

	public FieldNameDTO getAbilityName() {
		return abilityName;
	}
	
}
