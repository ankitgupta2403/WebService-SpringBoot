package com.microservices.SOAPWebservice.service;

import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanEligibitilyService {

 public Acknowledgement checkLoanEligibility(CustomerRequest customerRequest)
    {
       Acknowledgement acknowledgement = new Acknowledgement();
        List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();

        if(!(customerRequest.getAge()>30 && customerRequest.getAge()<=60))
        {
            mismatchCriteriaList.add("Person age should be between 30 and 60");
        }
        if(!(customerRequest.getYearlyIncome()>200000))
        {
            mismatchCriteriaList.add("Yearly income should be more than 2Lakh");
        }
        if(!(customerRequest.getCibilScore()>500))
        {
            mismatchCriteriaList.add("Low Cibil Score");
        }
        if(mismatchCriteriaList.size()>0)
        { acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false); }
            else{
            acknowledgement.setApprovedAmount(500000);
            acknowledgement.setIsEligible(true);
            mismatchCriteriaList.clear();
    }
            return acknowledgement;
    }

}

