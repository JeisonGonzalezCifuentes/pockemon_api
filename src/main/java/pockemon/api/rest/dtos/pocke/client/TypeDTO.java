package pockemon.api.rest.dtos.pocke.client;

import com.fasterxml.jackson.annotation.JsonAlias;

public class TypeDTO {

	@JsonAlias("type")
	private FieldNameDTO typeName;

	public TypeDTO() {
		super();
	}

	public TypeDTO(FieldNameDTO typeName) {
		super();
		this.typeName = typeName;
	}

	public FieldNameDTO getTypeName() {
		return typeName;
	}

	@Override
	public String toString() {
		return "TypeDTO [typeName=" + typeName + "]";
	}
	
}
