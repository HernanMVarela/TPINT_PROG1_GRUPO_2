package frgp.utn.edu.ar.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/// AUTENTIFICACION POR BASE DE DATOS - Spring Security Schema con UserDetails
		auth
		.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)
		.and()
		.inMemoryAuthentication()
		.withUser("localadmin")
		.password("$2a$12$oDingzHIKvubzzOPT3Sr..CISToI1txQv/6B3reU2vp2HhnZj.4T6") //123456
		.roles("ADMIN")
		.and()
		.withUser("tamara")
		.password("$2a$12$8tILy447KTEuMNnI52cVYO2N3U/xL8/3eeYZ9cJ6aZH4nqnTvYeEK") //herrera
		.roles("ADMIN");
		
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
