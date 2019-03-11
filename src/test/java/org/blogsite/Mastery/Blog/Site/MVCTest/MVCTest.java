package org.blogsite.Mastery.Blog.Site.MVCTest;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import javax.annotation.Resource;

import org.blogsite.Mastery.Blog.Site.Repositories.PostRepository;
import org.blogsite.Mastery.Blog.Site.controllers.PostController;
import org.blogsite.Mastery.Blog.Site.models.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)

public class MVCTest {
 
    @Resource
    private MockMvc mvc;
 
    @MockBean
    private PostRepository postRepo;
 
    @Mock
    private Post post;
    
    @Test
    public void shouldRouteToSinglePostView() throws Exception {
        Long id = 1L;
        when(postRepo.findById(id)).thenReturn(Optional.of(post));
        mvc.perform(get("/allPost/1")).andExpect(view().name(is("post/single")));
    }
     
    @Test
    public void shouldBeOkForSinglePost() throws Exception {
    	Long id = 1L;
        when(postRepo.findById(id)).thenReturn(Optional.of(post));
        mvc.perform(get("/allPost/1")).andExpect(status().isOk());
    }
     
    @Test
    public void shouldPutSinglePostIntoModel() throws Exception {
    	Long id = 1L;
        when(postRepo.findById(id)).thenReturn(Optional.of(post));
        mvc.perform(get("/allPost/1")).andExpect(model().attribute("post", is(post)));
    }
}