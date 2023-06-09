package com.satya.Project02.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class FrontController implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
		webCtx.register(MvcConfig.class);
		Dynamic servlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(webCtx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
