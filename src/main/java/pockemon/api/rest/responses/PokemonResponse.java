package pockemon.api.rest.responses;

import java.io.Serializable;

public class PokemonResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String status;
	private String code;
	private String message;
	private T data;
	
	public PokemonResponse(String status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
	
	public PokemonResponse(String status, String code, String message, T data) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}	

}