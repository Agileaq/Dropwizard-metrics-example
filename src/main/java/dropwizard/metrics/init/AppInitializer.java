package dropwizard.metrics.init;

import com.codahale.metrics.servlets.AdminServlet;
import com.ryantenney.metrics.spring.servlets.MetricsServletsContextListener;
import dropwizard.metrics.config.MyAppSpringConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Arc on 17/8/2016.
 */
public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        servletContext.addListener(new MetricsServletsContextListener());
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("restful", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");

        ServletRegistration.Dynamic dispatcherMetrics = servletContext.addServlet("metrics", new AdminServlet());
        dispatcherMetrics.setLoadOnStartup(1);
        dispatcherMetrics.addMapping("/metrics/*");

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(Boolean.TRUE);
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
        filterRegistration.addMappingForUrlPatterns(null, false, "/*");

    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MyAppSpringConfig.class);
        return context;
    }
}
