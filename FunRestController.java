package com.capgemini.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	//inject properties for :coach.name and team.name
	@Value("${coach.name}")
	private String Coachname;
	
	@Value("${team.name}")
	private String Teamname;
	
	//expose new new endpoint for "teaminfo"
	@GetMapping("/teaminfoo")
	public String getTeamInfo() {
		return "Coach : " + Coachname + ", Team Name :" + Teamname;
	}
	
	
	@GetMapping("/Helloo")
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
