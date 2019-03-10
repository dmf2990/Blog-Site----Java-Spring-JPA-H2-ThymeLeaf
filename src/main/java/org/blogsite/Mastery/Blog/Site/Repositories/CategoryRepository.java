package org.blogsite.Mastery.Blog.Site.Repositories;

import java.util.Optional;

import org.blogsite.Mastery.Blog.Site.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	Category findByPostCategory(String postCategory);
	Optional<Category> findById(Long id);
	Object findAllById(Long id);

}
