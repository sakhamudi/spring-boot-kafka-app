package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.service.KafKaProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

	 private final KafKaProducerService producerService;
	 
	    @Autowired
	    public KafkaProducerController(KafKaProducerService producerService) 
	    {
	        this.producerService = producerService;
	    }
	 
	    @GetMapping(value = "/publish")
	    public void sendMessageToKafkaTopic(@RequestParam("message") String message) 
	    {
	    	System.out.println("-------------****------------");
	        this.producerService.sendMessage(message);
	    }
}
