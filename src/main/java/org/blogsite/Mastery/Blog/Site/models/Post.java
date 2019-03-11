package org.blogsite.Mastery.Blog.Site.models;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	private String postTitle;
	private LocalDateTime date;
	@Lob
	private String body;
	
	@ManyToMany 
	private Collection<Author> authors;
	
	@ManyToMany
	private Collection<Tag> tags;
	
	@ManyToOne
	private Category category;
	
	public Post() {}
	
	public Post(String postTitle, String body, Author authors, Category category, Tag ...tags) {
		 this.postTitle = postTitle;
	     this.body = body;
	     this.date = LocalDateTime.now();
	     this.category = category;
	     this.authors = Arrays.asList(authors);
	     this.tags = Arrays.asList(tags);
	}

	public Long getId() {
		return id;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public LocalDateTime getDate() {
		return LocalDateTime.now();
	}

	public String getBody() {
		return body;
	}

	public Collection<Author> getAuthors() {
		return authors;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public Category getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + postTitle + ", date=" + date + ", body=" + body + ", author=" + authors
				+ ", tag=" + tags + ", category=" + category + "]";
	}

	public void addNewTag(Tag tag) {
		tags.add(tag);
		
	}

	public void addNewAuthor(Author author) {
		authors.add(author);
	}
}
