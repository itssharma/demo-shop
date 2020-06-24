package com.specter.onlineshopping.flows;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;


@Configuration
public class WebflowConfig extends AbstractFlowConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(WebflowConfig.class);
	
	
	@Bean
	public FlowDefinitionRegistry flowRegistry() {
		logger.info("inside flow config");
		return getFlowDefinitionRegistryBuilder(flowBuilderServices())
				.setBasePath("/WEB-INF/views/flows")
				.addFlowLocationPattern("/**/*-flow.xml")
				.build();
	}
	
	@Bean
	public FlowExecutor flowExecutor() {
		return getFlowExecutorBuilder(flowRegistry()).build();
	}
	
	@Bean
	public FlowBuilderServices flowBuilderServices() {
	    return getFlowBuilderServicesBuilder()
	            
	            .build();
	}
	
}
