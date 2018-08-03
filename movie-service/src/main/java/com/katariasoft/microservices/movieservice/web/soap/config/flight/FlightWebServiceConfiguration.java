package com.katariasoft.microservices.movieservice.web.soap.config.flight;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.katariasoft.microservices.movieservice.web.soap.config.WebServiceConfigurationTemplate;

@Configuration
@PropertySource("classpath:/properties/soap/${environment}/FlightService.properties")
public class FlightWebServiceConfiguration extends WebServiceConfigurationTemplate {

	@Autowired
	private Environment environment;

	@PostConstruct
	public void initProperties() {
		rootNode = environment.getProperty("flightwebservice.rootNode");
		jaxbPackage = environment.getProperty("flightwebservice.jaxbPackage");
		uri = environment.getProperty("flightwebservice.uri");
		fetchDummyResponse = environment.getProperty("flightwebservice.fetchDummyResponse");
		fileName = environment.getProperty("flightwebservice.fileName");
		logXml = Boolean.parseBoolean(environment.getProperty("flightwebservice.logXml"));
		soapActionHeaderUri = environment.getProperty("flightwebservice.soapActionHeaderUri");
	}

}