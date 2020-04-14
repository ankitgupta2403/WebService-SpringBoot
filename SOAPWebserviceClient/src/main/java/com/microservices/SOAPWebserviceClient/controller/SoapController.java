package com.microservices.SOAPWebserviceClient.controller;

import com.microservices.SOAPWebserviceClient.client.SOAPClient;
import com.microservices.SOAPWebserviceClient.loaneligibility.Acknowledgement;
import com.microservices.SOAPWebserviceClient.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoapController {

    @Autowired
    private SOAPClient client;

    @PostMapping("/getLoanStatus")
    public Acknowledgement getLoanStatus(@RequestBody CustomerRequest request)
    {
        return client.getLoanStatus(request);
    }
}
