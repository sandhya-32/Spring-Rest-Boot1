package com.capgemini.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	@GetMapping("/")
	public String sayHello() {
		return "Heloo world! time on server is " + LocalDateTime.now();
	}
	@GetMapping("/workout")
	public String getDailyWorkOut() {
		return "run a harg 5k!";
	}
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day!";
	}
}
