package com.microservices.SOAPWebserviceClient.client;

import com.microservices.SOAPWebserviceClient.loaneligibility.Acknowledgement;
import com.microservices.SOAPWebserviceClient.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SOAPClient {

    @Autowired
   private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public Acknowledgement getLoanStatus(CustomerRequest request)
    {
        template = new WebServiceTemplate(marshaller);
        Acknowledgement acknowledgement = (Acknowledgement)template.marshalSendAndReceive("http://localhost:8091/ws",request);
        return acknowledgement;
    }
}
