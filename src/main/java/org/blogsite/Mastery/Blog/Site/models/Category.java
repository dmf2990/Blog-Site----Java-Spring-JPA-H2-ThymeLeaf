package org.blogsite.Mastery.Blog.Site.models;


import java.util.Collection;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Long id;
	private String postCategory;
	
	@OneToMany (mappedBy= "category")
	private Collection<Post> posts;
	
	public Category() {}

	public Category(String postCategory) {
		this.postCategory = postCategory;
	}

	public Long getId() {
		return id;
	}

	public String getPostCategory() {
		return postCategory;
	}

	public Collection<Post> getPosts() {
		return posts;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", genre=" + postCategory + ", posts=" + posts + "]";
	}

}
