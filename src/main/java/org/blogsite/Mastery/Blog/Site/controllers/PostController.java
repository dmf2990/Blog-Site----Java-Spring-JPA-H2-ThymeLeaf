package org.blogsite.Mastery.Blog.Site.controllers;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.blogsite.Mastery.Blog.Site.Repositories.AuthorRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.CategoryRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.PostRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.TagRepository;
import org.blogsite.Mastery.Blog.Site.models.Author;
import org.blogsite.Mastery.Blog.Site.models.Category;
import org.blogsite.Mastery.Blog.Site.models.Post;
import org.blogsite.Mastery.Blog.Site.models.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
 
	@Resource
	PostRepository postRepo;
	@Resource
	CategoryRepository catRepo;
	@Resource
	TagRepository tagRepo;
	@Resource
	AuthorRepository authorRepo;
	
	
	//home TH & home controller - beer
	// links "POSTS" in Nav to all posts page
	//also goes to allPost, find all posts in post repo, then return allPost
	//not a collection of posts in post model, therefore do we need to find all in cat or auth or tag?
	@GetMapping("/allPost")
	public String allPost(Model model) {
		model.addAttribute("Posts", postRepo.findAll());
		return "allPost"; 
	}
	//Review TH & review controller beer
	// links "NEW BLOG" in Nav to new blog post page
	@GetMapping("/newBlog")
	public String newBlog() {
		return "newBlog";
	}
	
	//populate that form on new page with all other posts
	@PostMapping("/newBlog")
	public String submitPost (String postTitle, String body, String authorName, String postCategory, String tagName) {
		
		Author author = authorRepo.findByAuthorName(authorName);
		Category category = catRepo.findByPostCategory(postCategory);
		Tag tag = tagRepo.findByTagName(tagName);
		
		postRepo.save(new Post(postTitle, body, author, category, tag));
		
		return "redirect:/allPost";
	}
	
}
