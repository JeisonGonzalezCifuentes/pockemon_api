package pockemon.api.rest.dtos.pocke.api;

import java.util.List;

public class GetAllDTO {
	
	private List<PokemonDTO> results;
	
	public GetAllDTO() {
		super();
	}

	public GetAllDTO(List<PokemonDTO> results) {
		super();
		this.results = results;
	}

	public List<PokemonDTO> getResults() {
		return results;
	}

	@Override
	public String toString() {
		return "GetAllDTO [results=" + results + "]";
	}

}
