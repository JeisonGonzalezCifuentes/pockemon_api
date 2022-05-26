package pockemon.api.rest.dtos.pocke.client;

import java.util.List;

public class GetAllDTO {
	
	private List<PokeClientDTO> results;
	
	public GetAllDTO() {
		super();
	}

	public GetAllDTO(List<PokeClientDTO> results) {
		super();
		this.results = results;
	}

	public List<PokeClientDTO> getResults() {
		return results;
	}

	@Override
	public String toString() {
		return "GetAllDTO [results=" + results + "]";
	}

}
