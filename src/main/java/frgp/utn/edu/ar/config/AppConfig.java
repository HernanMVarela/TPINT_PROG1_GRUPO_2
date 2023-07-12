package frgp.utn.edu.ar.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.Prestamo;
import frgp.utn.edu.ar.dominio.Usuario;

@Configuration
@EnableWebMvc
@ComponentScan("frgp.utn.edu.ar")
public class AppConfig implements WebMvcConfigurer {
   
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/vistas/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/tpint_prog1_springsec");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("root");
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
		return driverManagerDataSource;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource());
		return jdbcTemplate;
	}
	
	@Bean
	@Scope("prototype")
	public Cliente clienteNuevo() {
		return new Cliente();
	}
	
	@Bean
	@Scope("prototype")
	public Prestamo prestamoNuevo() {
		Prestamo nuevo = new Prestamo();
		nuevo.setCliente(clienteNuevo());
		return nuevo;
	}
	
	@Bean
	@Scope("prototype")
	public Usuario usuarioNuevo() {
		return new Usuario();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/static/assets/");
    }
}
