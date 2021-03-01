package com.api5.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

	
	@GetMapping("/evento")
	public String index() {
		return "index";
	}
	

	
}
