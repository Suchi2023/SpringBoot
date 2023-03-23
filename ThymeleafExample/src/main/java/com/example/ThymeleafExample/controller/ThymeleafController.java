package com.example.ThymeleafExample.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThymeleafController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
		System.out.println("Inside home handler..............");
		model.addAttribute("note", "Welcome to our website");
		model.addAttribute("imgName", "pic1.png");
		return "home";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Inside about handler.................");
		model.addAttribute("name", "Suchitra Maurya");
		model.addAttribute("currentDate", new Date().toLocaleString());
		model.addAttribute("owner", "Nirmal Sharma");
		return "about";
	}
	
	@RequestMapping(value = "/subjects", method = RequestMethod.GET)
	public String iteration(Model model) {
		System.out.println("Inside iteration handler....................");
		List<String> list = List.of("Database Management" , "Operating System", "Computer Networks", "Web Technology", "Compiler Design", 
				"Automata");
		model.addAttribute("subjectList", list);
		return "subject";
	}
	
	@GetMapping("/condition")
	public String conditionHandler(Model model) {
		System.out.println("Inside condition handler.............................");
		model.addAttribute("isActive", true);
		model.addAttribute("gender", "F");
		List<Integer> list = List.of(223, 43, 53, 645, 65);
		model.addAttribute("mylist", list);
		return "conditional";
	}
	
	@GetMapping("/service")
	public String serviceHandler(Model model) {
		System.out.println("Inside service handler.................................");
		model.addAttribute("header", "This is the header");
		model.addAttribute("footer",  "This is the footer");
		model.addAttribute("content", "This is the content of the page.");
		return "service";
	}
	
}
