package org.blogsite.Mastery.Blog.Site.controllerTest;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.blogsite.Mastery.Blog.Site.Repositories.CategoryRepository;
import org.blogsite.Mastery.Blog.Site.controllers.CategoryController;
import org.blogsite.Mastery.Blog.Site.models.Category;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;


public class CategoryControllerTest {
	 
    @InjectMocks
    private CategoryController underTest;
 
    @Mock
    private CategoryRepository catRepo;
 
    @Mock
    private Category category;
    
	@Mock
	private Model model;
 
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void shouldAddCategoryToModel() throws Exception {
        Long id = 1L;
        when(catRepo.findById(id)).thenReturn(Optional.of(category));
 
        underTest.getCat(id, model);
 
        verify(model).addAttribute("category", category);
    }
}