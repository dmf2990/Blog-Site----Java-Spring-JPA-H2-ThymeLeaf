package org.blogsite.Mastery.Blog.Site.Repositories;

import org.blogsite.Mastery.Blog.Site.models.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

	Author findByAuthorName(String authorName);
}
