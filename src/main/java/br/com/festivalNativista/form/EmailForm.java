package br.com.festivalNativista.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmailForm {

	@NotEmpty @NotNull
	private String email;
	
	@NotEmpty @NotNull
	private String name;
	
	@NotEmpty @NotNull
	private String message;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMailBody() {
		return " E-mail enviado por: " + this.name + "\n\n E-mail: " + this.email + "\n\n Mensagem: " + this.message;
	}
}

