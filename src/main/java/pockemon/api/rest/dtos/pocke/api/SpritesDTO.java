package pockemon.api.rest.dtos.pocke.api;

public class SpritesDTO {

	private String back_default;
	private String back_female;
	private String front_default;
	private String front_female;
	
	public SpritesDTO() {
		super();
	}

	public SpritesDTO(String back_default, String back_female, String front_default, String front_female) {
		super();
		this.back_default = back_default;
		this.back_female = back_female;
		this.front_default = front_default;
		this.front_female = front_female;
	}

	public String getBack_default() {
		return back_default;
	}

	public String getBack_female() {
		return back_female;
	}

	public String getFront_default() {
		return front_default;
	}

	public String getFront_female() {
		return front_female;
	}
	
}
