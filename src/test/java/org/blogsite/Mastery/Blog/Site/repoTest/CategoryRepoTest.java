package org.blogsite.Mastery.Blog.Site.repoTest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.blogsite.Mastery.Blog.Site.Repositories.CategoryRepository;
import org.blogsite.Mastery.Blog.Site.models.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class CategoryRepoTest {

	@RunWith(SpringJUnit4ClassRunner.class)
	@DataJpaTest
	public class CategoryTest {

		@Resource
		private TestEntityManager entityManager;

		@Resource
		private CategoryRepository categoryRepo;

		@Test
		public void shouldSaveAndLoadCategory() {
			Category category = categoryRepo.save(new Category("Kathy Sierra"));

			entityManager.persist(category);
			entityManager.flush();
			entityManager.clear();

			Category categoryFromDatabase = categoryRepo.findByPostCategory("Head First Java");

			assertThat(categoryFromDatabase.getPostCategory(), is("Head First Java"));
		}
	}
}