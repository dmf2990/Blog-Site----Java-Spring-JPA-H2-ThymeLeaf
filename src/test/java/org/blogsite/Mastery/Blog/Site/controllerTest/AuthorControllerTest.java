package org.blogsite.Mastery.Blog.Site.controllerTest;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.blogsite.Mastery.Blog.Site.Repositories.AuthorRepository;
import org.blogsite.Mastery.Blog.Site.controllers.AuthorController;
import org.blogsite.Mastery.Blog.Site.models.Author;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;


public class AuthorControllerTest {
	 
    @InjectMocks
    private AuthorController underTest;
 
    @Mock
    private AuthorRepository authorRepo;
 
    @Mock
    private Author author;
    
	@Mock
	private Model model;
 
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void shouldAddAuthorToModel() throws Exception {
        Long id = 1L;
        when(authorRepo.findById(id)).thenReturn(Optional.of(author));
 
        underTest.getAuth(id, model);
 
        verify(model).addAttribute("author", author);
    }
}