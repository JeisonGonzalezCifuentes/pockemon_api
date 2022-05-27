package pockemon.api.rest.dtos.pocke.client;

public class EvolutionChainDTO {
	
	private ChainDTO chain;

	public EvolutionChainDTO() {
		super();
	}

	public EvolutionChainDTO(ChainDTO chain) {
		super();
		this.chain = chain;
	}

	public ChainDTO getChain() {
		return chain;
	}

	@Override
	public String toString() {
		return "EvolutionChainDTO [chain=" + chain + "]";
	}

}
