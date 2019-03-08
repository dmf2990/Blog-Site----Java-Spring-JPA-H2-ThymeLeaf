package org.blogsite.Mastery.Blog.Site.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

}
