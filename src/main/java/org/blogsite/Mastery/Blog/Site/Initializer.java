package org.blogsite.Mastery.Blog.Site;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.blogsite.Mastery.Blog.Site.Repositories.AuthorRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.CategoryRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.PostRepository;
import org.blogsite.Mastery.Blog.Site.Repositories.TagRepository;
import org.blogsite.Mastery.Blog.Site.models.Author;
import org.blogsite.Mastery.Blog.Site.models.Category;
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
	
	@Override
	public void run(String... args) throws Exception {
		LocalDateTime date = LocalDateTime.now();
		Author author = authorRepo.save(new Author("Drew"));
		Category category = catRepo.save(new Category("crossFit"));
		Tag tag = tagRepo.save(new Tag("tag"));	
	}


}
