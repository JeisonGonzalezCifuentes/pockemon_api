package pockemon.api.rest.dtos.pocke.client;

public class FieldNameDTO {

	private String name;
	private String url;
	
	public FieldNameDTO() {
		super();
	}
	
	public FieldNameDTO(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "FieldNameDTO [name=" + name + ", url=" + url + "]";
	}
	
}
