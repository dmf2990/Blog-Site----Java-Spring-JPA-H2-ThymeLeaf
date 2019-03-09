package org.blogsite.Mastery.Blog.Site.Repositories;

import org.blogsite.Mastery.Blog.Site.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	
	Tag findByTagName(String tagName);

}
