package org.blogsite.Mastery.Blog.Site.controllers;

import javax.annotation.Resource;

import org.blogsite.Mastery.Blog.Site.Repositories.AuthorRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.CategoryRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.PostRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.TagRepository;
import org.blogsite.Mastery.Blog.Site.models.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
	
	@Resource
	PostRepository postRepo;
	@Resource
	CategoryRepository catRepo;
	@Resource
	TagRepository tagRepo;
	@Resource
	AuthorRepository authorRepo;
	
	@GetMapping("/allAuth")
	public String allAuth(Model model) {
		model.addAttribute("Authors", authorRepo.findAll());
		return "allAuth";
	}
	
	@PostMapping("/allAuth")
	public String submitAuthor (String authorName) {
		authorRepo.save(new Author(authorName));
		return "redirect:/allAuth";
	}

}
