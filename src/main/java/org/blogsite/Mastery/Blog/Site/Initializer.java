package org.blogsite.Mastery.Blog.Site;

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
		Author author3 = authorRepo.save(new Author("Eythan"));
		Author author4 = authorRepo.save(new Author("Matt"));
		Author author5 = authorRepo.save(new Author("Bini"));
		Author author6 = authorRepo.save(new Author("Sam"));
		Author author7 = authorRepo.save(new Author("Jenny"));
		Author author8 = authorRepo.save(new Author("Katie"));
		Author author9 = authorRepo.save(new Author("Joy"));
		Author author10 = authorRepo.save(new Author("Traci"));
		
		Tag tag1 = tagRepo.save(new Tag("tag"));	
		Tag tag2 = tagRepo.save(new Tag("fit"));
		Tag tag3 = tagRepo.save(new Tag("health"));
		Tag tag4 = tagRepo.save(new Tag("diet"));
		Tag tag5 = tagRepo.save(new Tag("lift"));
		Tag tag6 = tagRepo.save(new Tag("gym"));	
		Tag tag7 = tagRepo.save(new Tag("flex"));
		Tag tag8 = tagRepo.save(new Tag("water"));
		Tag tag9 = tagRepo.save(new Tag("rouge"));
		Tag tag10 = tagRepo.save(new Tag("cardio"));
		
		Category category1 = catRepo.save(new Category("crossFit"));
		Category category2 = catRepo.save(new Category("kickBoxing"));
		Category category3 = catRepo.save(new Category("powerLifting"));
		Category category4 = catRepo.save(new Category("olympicLifting"));
		Category category5 = catRepo.save(new Category("hitTraining"));
		Category category6 = catRepo.save(new Category("running"));
		Category category7 = catRepo.save(new Category("cycling"));
		Category category8 = catRepo.save(new Category("MMA"));
		Category category9 = catRepo.save(new Category("muay thai"));
		Category category10 = catRepo.save(new Category("football"));
		
		postRepo.save(new Post("Darrel", "Darrel likes to posts blogs like this", author1, category1, tag1));
		postRepo.save(new Post("Steve", "Blogs about olympic lifting are cool", author1, category1, tag1));
		postRepo.save(new Post("Crosscountry", "Running crosscountry is hard", author1, category1, tag1));
		postRepo.save(new Post("Fitness", "Fitness is awesome", author4, category1, tag1));

	}


}
