package fr.formation.inti.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/bootstrap/**").addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.1.1/");
		registry
        .addResourceHandler("/styles/**") 
        .addResourceLocations("/resources/static/css/");
		

		// PHOTO SAVE
		Path userUploadDir = Paths.get("./user-photos");
		String userUploadPath = userUploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/user-photos/**").addResourceLocations("file:/" + userUploadPath + "/");
		
	}
	

	@Bean
	public HttpFirewall getHttpFirewall() {
	    StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
	    strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
	    return strictHttpFirewall;
	}

}
