package org.blogsite.Mastery.Blog.Site.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	
	@Id
	@GeneratedValue
	private Long id;
	private String authorName;
	
	//mappedBy = organized by... collection of posts organized by Authors
	//new column to table in h2
	@ManyToMany (mappedBy="authors")
	private Collection<Post> posts;

	public Author() {}
	
	public Author(String authorName) {
		this.authorName = authorName;
	}

	public Long getId() {
		return id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public Collection<Post> getPosts() {
		return posts;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", authorName=" + authorName + ", posts=" + posts + "]";
	}
	
	
	
	
	
	
	
	
}
