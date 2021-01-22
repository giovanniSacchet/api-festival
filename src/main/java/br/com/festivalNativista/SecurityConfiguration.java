package br.com.festivalNativista;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	// Autorização
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().csrf().disable()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/api/login").permitAll()
				.antMatchers("/api/video").permitAll()
				.antMatchers(HttpMethod.POST, "/api/votar").permitAll()
				.antMatchers(HttpMethod.POST, "/api/email").permitAll();
		}

}