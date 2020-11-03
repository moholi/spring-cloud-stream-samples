package tech.moho.stream.spring.channel;

import java.io.Serializable;

public class MohoEvent implements Serializable{
	
	private static final long serialVersionUID = -5502243672707029587L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MohoEvent [message=" + message + "]";
	}
	
}
