package com.configuration;

import java.util.Arrays;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;


@Configuration
public class MessagingConfiguration {
	 private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
     
	    private static final String ORDER_QUEUE = "order-queue";
	 
	    @Bean
	    public ActiveMQConnectionFactory connectionFactory(){
	        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
	        //connectionFactory.setTrustedPackages(new ArrayList(Arrays.asList("com.configuration,com.messaging,com.model.InventoryResponse".split(","))));
	        connectionFactory.setTrustedPackages(Arrays.asList("com"));
	        return connectionFactory;
	    }
	     
	    @Bean
	    public JmsTemplate jmsTemplate(){
	        JmsTemplate template = new JmsTemplate();
	        template.setConnectionFactory(connectionFactory());
	        template.setDefaultDestinationName(ORDER_QUEUE);
	        return template;
	    }
}
