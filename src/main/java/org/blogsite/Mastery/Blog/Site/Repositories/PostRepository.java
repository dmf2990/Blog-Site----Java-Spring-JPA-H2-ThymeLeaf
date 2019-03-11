package org.blogsite.Mastery.Blog.Site.Repositories;

import java.util.Optional;

import org.blogsite.Mastery.Blog.Site.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
	
	Post findByPostTitle(String postTitle);
	Optional<Post> findById(Long id);
}
