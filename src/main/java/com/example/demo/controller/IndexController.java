package com.example.demo.controller;

import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@Autowired
	ResourceService resourceService;
	
	@GetMapping("/")        
	public String home() {
		return "index";
	}

	@GetMapping("/toastui")
	public String toastui() {
		return "toastui";
	}

}
