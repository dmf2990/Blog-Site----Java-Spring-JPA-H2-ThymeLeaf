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
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//when get to allAuth pg list all authors in authorRepo
	@GetMapping("/allAuth")
	public String allAuth(Model model) {
		model.addAttribute("Authors", authorRepo.findAll());
		return "allAuth";
	}
	
	@PostMapping("/allAuth")
	public String submitAuthor (String authorName) {
		
		//if auth not exist - make new.  
		Author author = authorRepo.findByAuthorName(authorName);
		if (author == null) {
			author = authorRepo.save(new Author(authorName));
		}
		
		//if exists already - dont replicate
		author = authorRepo.save(author);
		return "redirect:/allAuth";
	}
	
	// get specific author
	// use singleAuth to call on collection of posts in TH: line 19
	@GetMapping("/allAuth/{id}")
	public String getAuth(@PathVariable Long id, Model model) {
		model.addAttribute("SingleAuth", authorRepo.findById(id).get());
		return "specAuth";
	}

}
