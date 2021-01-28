package com.alghanim.enaya.travelinsurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackageClasses=PlanManagementApplication.class)
public class PlanManagementApplication
{
    public static void main(String[] args){
        SpringApplication.run(PlanManagementApplication.class, args);
    }
}
