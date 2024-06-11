package rayon.inombrable.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "rayon.inombrable")
public class AppConfig implements WebMvcConfigurer{
	
//	@Autowired
   // RoleToUserProfileConverter roleToUserProfileConverter;
	
	@Bean
	@Description("Thymeleaf Template Resolver")
	public SpringResourceTemplateResolver templateResolver() {
		 SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	        templateResolver.setPrefix("/WEB-INF/views/"); // Ubicación de las vistas
	        templateResolver.setSuffix(".html"); // Extensión de los archivos
	        templateResolver.setTemplateMode("HTML"); // Modo de plantilla (HTML, XML, etc.)
	        return templateResolver;
	}

	
	@Bean
	@Description("Thymeleaf View Resolver")
	public ThymeleafViewResolver viewResolver() {
	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	    viewResolver.setTemplateEngine(templateEngine());
	    viewResolver.setOrder(1);
	    return viewResolver;
	}
	
	@Bean
	@Description("Thymeleaf Template Engine")
	public SpringTemplateEngine templateEngine() {
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver());
	    templateEngine.setTemplateEngineMessageSource(messageSource());
	    return templateEngine;
	}
	@Bean
	@Description("Spring Message Resolver")
	public ResourceBundleMessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}

	  @Override
	  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	      registry.addResourceHandler("/css/**").addResourceLocations("/resources/core/css/");
	      registry.addResourceHandler("/js/**").addResourceLocations("/resources/core/js/");
	      registry.addResourceHandler("/img/**").addResourceLocations("/resources/core/img/");
	      registry.addResourceHandler("/vendor/**").addResourceLocations("/resources/core/vendor/");
	      registry.addResourceHandler("/static/**").addResourceLocations("/static/");

	  }

	     
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
        return converter;
    }

    
    
    
}