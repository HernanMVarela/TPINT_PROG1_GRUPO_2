package frgp.utn.edu.ar.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
		.inMemoryAuthentication().withUser("localadmin").password("{noop}123456").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/clientes").access("hasRole('ADMIN')")
			.and()
				.formLogin().loginPage("/login")
				.successForwardUrl("/clientes")
				.and()
				.httpBasic()
				.and().logout();
	}
	
	
}
