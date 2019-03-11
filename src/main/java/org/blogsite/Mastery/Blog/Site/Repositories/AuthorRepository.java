package org.blogsite.Mastery.Blog.Site.Repositories;

import java.util.Optional;

import org.blogsite.Mastery.Blog.Site.models.Author;
import org.blogsite.Mastery.Blog.Site.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

	Author findByAuthorName(String authorName);
	Optional<Author> findById(Long id);
}
