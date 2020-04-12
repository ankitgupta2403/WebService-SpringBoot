package com.microservices.SOAPWebservice.endPoint;

import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;
import com.microservices.SOAPWebservice.service.LoanEligibitilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityEndPoint {

    private static final String NAMESPACE = "http://www.javatechie.com/spring/soap/api/loanEligibility";

    @Autowired
    private LoanEligibitilyService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request)
    {
        return service.checkLoanEligibility(request);
    }
}
