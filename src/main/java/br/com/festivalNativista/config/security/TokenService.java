package br.com.festivalNativista.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.festivalNativista.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${usuario.jwt.expiration}")
	private String expiration;

	@Value("${usuario.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		User logado = (User) authentication.getPrincipal();
		Date dataCriacao = new Date();
		Date dataExpiracao = new Date(dataCriacao.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
				.setIssuer("API Festival Cancao Nativista")
				.setSubject(logado.getId().toString())
				.setIssuedAt(dataCriacao)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean validaToken(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}
	
}
