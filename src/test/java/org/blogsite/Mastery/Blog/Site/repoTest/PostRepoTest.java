package org.blogsite.Mastery.Blog.Site.repoTest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.blogsite.Mastery.Blog.Site.Repositories.PostRepository;
import org.blogsite.Mastery.Blog.Site.models.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

	public class PostRepoTest {

		@RunWith(SpringJUnit4ClassRunner.class)
		@DataJpaTest
		public class PostTest {

			@Resource
			private TestEntityManager entityManager;

			@Resource
			private PostRepository postRepo;

			@Test
			public void shouldSaveAndLoadPost() {
				Post post = postRepo.save(new Post("Kathy Sierra", "", null, null));

				entityManager.persist(post);
				entityManager.flush();
				entityManager.clear();

				Post postFromDatabase = postRepo.findByPostTitle("Head First Java");

				assertThat(postFromDatabase.getPostTitle(), is("Head First Java"));
			}
		}
	}