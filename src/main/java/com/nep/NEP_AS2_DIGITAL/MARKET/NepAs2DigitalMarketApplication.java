package com.nep.NEP_AS2_DIGITAL.MARKET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nep.NEP_AS2_DIGITAL.MARKET.data.ProductRepository;

@SpringBootApplication
public class NepAs2DigitalMarketApplication {
	 @Autowired
	 ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(NepAs2DigitalMarketApplication.class, args);
	}
	


}
