package org.blogsite.Mastery.Blog.Site.repoTest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.blogsite.Mastery.Blog.Site.Repositories.TagRepository;
import org.blogsite.Mastery.Blog.Site.models.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

	public class TagRepoTest {

		@RunWith(SpringJUnit4ClassRunner.class)
		@DataJpaTest
		public class TagTest {

			@Resource
			private TestEntityManager entityManager;

			@Resource
			private TagRepository tagRepo;

			@Test
			public void shouldSaveAndLoadTag() {
				Tag tag = tagRepo.save(new Tag("Kathy"));

				entityManager.persist(tag);
				entityManager.flush();
				entityManager.clear();

				Tag tagFromDatabase = tagRepo.findByTagName("Head First Java");

				assertThat(tagFromDatabase.getTagName(), is("Head First Java"));
			}
		}
	}