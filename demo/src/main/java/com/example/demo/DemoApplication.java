
package com.example.demo;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.wsdl.NumberToWordsResponse;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private SoapClient client;

    @GetMapping(value = "/getNumberIntoWord/{number}")
    public  NumberToWordsResponse invokeSoapClientToGetNumberInWords(@PathVariable BigInteger number) {
        return client.getWords(number);
    }

}
