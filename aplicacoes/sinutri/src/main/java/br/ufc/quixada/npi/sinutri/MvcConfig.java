package br.ufc.quixada.npi.sinutri;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addRedirectViewController("", "/login");
    	registry.addRedirectViewController("/", "/login");
    	registry.addStatusController("/500", HttpStatus.INTERNAL_SERVER_ERROR);
    	registry.addStatusController("/403", HttpStatus.FORBIDDEN);
    	registry.addStatusController("/404", HttpStatus.NOT_FOUND);
    }
}