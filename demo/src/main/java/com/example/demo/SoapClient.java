package com.example.demo;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.wsdl.NumberToWords;
import com.example.consumingwebservice.wsdl.NumberToWordsResponse;

public class SoapClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(SoapClient.class);

    public NumberToWordsResponse getWords(BigInteger number) {

        NumberToWords request = new NumberToWords();
      request.setUbiNum(number);

      log.info("Requesting location for " + number);

      NumberToWordsResponse response = (NumberToWordsResponse) getWebServiceTemplate()
          .marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/numberconversion.wso", request,
              new SoapActionCallback(
                  ""));

      return response;
    }

  }