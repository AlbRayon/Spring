package rayon.inombrable.conf;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class SpringWebAppInitializer implements WebApplicationInitializer {
	 
    //@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class); 
        //appContext.vi
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.setAsyncSupported(true);
        dispatcher.addMapping("/");
    }
 
    
}