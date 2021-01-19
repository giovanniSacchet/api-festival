package br.com.festivalNativista.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EmailForm {

	@NotEmpty @NotNull
	private String email;
	
	@NotEmpty @NotNull
	private String name;
	
	@NotEmpty @NotNull
	private String message;

	public String getMailBody() {
		return " E-mail enviado por: " + this.name + "\n\n E-mail: " + this.email + "\n\n Mensagem: " + this.message;
	}
}

