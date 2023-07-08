package frgp.utn.edu.ar.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub --- NO SE USA
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] configFiles = {AppConfig.class}; /// Inicializacion del archivo de configuración.
		return configFiles;
	}

	@Override
	protected String[] getServletMappings() {
		// Crear mapeos de las vistas
		String [] mappings = {"/"};
		return mappings;
	}
}
