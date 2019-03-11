package org.blogsite.Mastery.Blog.Site.controllers;

import javax.annotation.Resource;

import org.blogsite.Mastery.Blog.Site.Repositories.AuthorRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.CategoryRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.PostRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.TagRepository;
import org.blogsite.Mastery.Blog.Site.models.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
	
	@Resource
	PostRepository postRepo;
	@Resource
	CategoryRepository catRepo;
	@Resource
	TagRepository tagRepo;
	@Resource
	AuthorRepository authorRepo;
	
	@GetMapping("/allCat")
	public String allCat(Model model) {
		model.addAttribute("Categories", catRepo.findAll());
		return "allCat";
	}
	
	//make new category
	@PostMapping("/allCat")
	public String submitCategory (String postCategory) {
	
		// if category doesnt exist - make new
		Category category = catRepo.findByPostCategory(postCategory);	
		if (category == null) {
			category = catRepo.save(new Category(postCategory));	
		}
		
		// if exists already - dont replicate
		category = catRepo.save(category);
		return "redirect:/allCat";
	}
	
	// get specific category
	// use SingleCat to see all posts in specific cat: line 19 
	@GetMapping("/allCat/{id}")
	public String getCat(@PathVariable Long id, Model model) {
		model.addAttribute("SingleCat", catRepo.findById(id).get());
		return "specCat";
	}

}
