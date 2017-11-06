package com.aparna.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {

	@RequestMapping(value = "/", method = {RequestMethod.GET,RequestMethod.POST})
	public String homePage(HttpServletRequest request) {
		      request.setAttribute("message",
		        "Welcome to Hospital Management system - Sample Project using Spring Boot, Spring Data JPA and MY SQL database.");
		      return "homePage";
		    }	
	}

