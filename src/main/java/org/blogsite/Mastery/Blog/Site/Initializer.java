package org.blogsite.Mastery.Blog.Site;

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
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	PostRepository postRepo;
	@Resource
	CategoryRepository catRepo;
	@Resource
	TagRepository tagRepo;
	@Resource
	AuthorRepository authorRepo;
	
	@Override //jdbc:h2:mem:testdb
	public void run(String... args) throws Exception {
		
		
		Author author1 = authorRepo.save(new Author("Drew"));
		Author author2 = authorRepo.save(new Author("Steve"));
		
		Tag tag = tagRepo.save(new Tag("tag"));	
		
		Category category1 = catRepo.save(new Category("crossFit"));
		Category category2 = catRepo.save(new Category("kickBoxing"));
		
		postRepo.save(new Post("String", "string", author1, category1, tag));	
	}


}
