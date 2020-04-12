package com.microservices.SOAPWebservice.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class SOAPWSConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServletServlet(ApplicationContext context)
    {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<MessageDispatcherServlet>(servlet,"/ws/*");
    }

    @Bean(name="loanEligibility")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema)
    {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("LoanEligibility");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setTargetNamespace("http://www.javatechie.com/spring/soap/api/loanEligibility");
        defaultWsdl11Definition.setSchema(schema);
        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema xsdSchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("loaneligibility.xsd"));
    }

}
