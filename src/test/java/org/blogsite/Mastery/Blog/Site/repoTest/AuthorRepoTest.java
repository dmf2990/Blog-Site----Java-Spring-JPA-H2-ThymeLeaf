package org.blogsite.Mastery.Blog.Site.repoTest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.blogsite.Mastery.Blog.Site.Repositories.AuthorRepository;
import org.blogsite.Mastery.Blog.Site.models.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class AuthorRepoTest {

	@RunWith(SpringJUnit4ClassRunner.class)
	@DataJpaTest
	public class AuthorTest {

		@Resource
		private TestEntityManager entityManager;

		@Resource
		private AuthorRepository authorRepo;

		@Test
		public void shouldSaveAndLoadAuthor() {
			Author author = authorRepo.save(new Author("Kathy Sierra"));

			entityManager.persist(author);
			entityManager.flush();
			entityManager.clear();

			Author authorFromDatabase = authorRepo.findByAuthorName("Head First Java");

			assertThat(authorFromDatabase.getAuthorName(), is("Head First Java"));
		}
	}
}