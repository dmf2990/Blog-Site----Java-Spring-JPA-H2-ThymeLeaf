package org.blogsite.Mastery.Blog.Site.controllers;

import javax.annotation.Resource;

import org.blogsite.Mastery.Blog.Site.Repositories.AuthorRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.CategoryRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.PostRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.TagRepository;
import org.blogsite.Mastery.Blog.Site.models.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TagController {

	@Resource
	PostRepository postRepo;
	@Resource
	CategoryRepository catRepo;
	@Resource
	TagRepository tagRepo;
	@Resource
	AuthorRepository authorRepo;

	@GetMapping("/allTag")
	public String allTag(Model model) {
		model.addAttribute("Tags", tagRepo.findAll());
		return "allTag";
	}

	// populate tag list on allTag page 
	@PostMapping("/allTag")
	public String submitTag (String tagName) {
		
		//if tag does not exist - make new
		Tag tag = tagRepo.findByTagName(tagName);
		if (tag == null) {
			tag = tagRepo.save(new Tag(tagName));
		}
		
		//if exists - dont replicate
		tag = tagRepo.save(tag);
		return "redirect:/allTag";
	}
	
	// get specific tag
	// also use SingleTag to populate all posts with same tag in specific tag pg
	@GetMapping("/allTag/{id}")
	public String getTag(@PathVariable Long id, Model model) {
		model.addAttribute("SingleTag", tagRepo.findById(id).get());
		return "specTag";
	}
	
}
