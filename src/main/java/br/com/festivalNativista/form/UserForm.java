package br.com.festivalNativista.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.festivalNativista.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {

	@NotNull @NotEmpty
	private String email;
	
	@NotEmpty @NotNull
	private String senha;
	
	public User converter(String senha) {
		return new User(this.email, senha);
	}
	
}
