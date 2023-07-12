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
		.authorities("ADMIN")
		.and()
		.withUser("tamara")
		.password("$2a$12$8tILy447KTEuMNnI52cVYO2N3U/xL8/3eeYZ9cJ6aZH4nqnTvYeEK") //herrera
		.authorities("ADMIN");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
			.antMatchers("/","/login","/registro").permitAll()
			.antMatchers("/home").authenticated()
			.antMatchers("/usuarios").hasAuthority("ADMIN")
			.antMatchers("/clientes").hasAnyAuthority("ADMIN", "USUARIO")
			.antMatchers("/prestamos").hasAnyAuthority("ADMIN", "CLIENTE")
			.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll()
				.successForwardUrl("/loginSuccesful").permitAll()
				.and()
				.httpBasic()
				.and().logout();
	}
	

}
