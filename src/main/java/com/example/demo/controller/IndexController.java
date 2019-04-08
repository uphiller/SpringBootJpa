package com.example.demo.controller;

import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@Autowired
	ResourceService resourceService;
	
	@GetMapping("/")        
	 public String home(Model model) throws Exception{ 
//		List<Resource> users = userService.getResources();
//		model.addAttribute("users", users);
		resourceService.saveResource();
		return "index";
	 }

	@GetMapping("/error")
	public String error() throws Exception{
		return "index";
	}
}