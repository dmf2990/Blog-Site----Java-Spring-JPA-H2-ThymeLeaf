package org.blogsite.Mastery.Blog.Site.MVCTest;

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







//package org.wecancodeit.publishinghouse;
//
//import static org.hamcrest.Matchers.is;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//import java.util.Optional;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.wecancodeit.publishinghouse.controllers.BookController;
//import org.wecancodeit.publishinghouse.models.Book;
//import org.wecancodeit.publishinghouse.repositories.BookRepository;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(BookController.class)
//public class BookMvcTest {
// 
//    @Resource
//    private MockMvc mvc;
// 
//    @MockBean
//    private BookRepository bookRepo;
// 
//    @Mock
//    private Book book;
//    
//    @Test
//    public void shouldRouteToSingleBookView() throws Exception {
//        Long bookId = 1L;
//        when(bookRepo.findById(bookId)).thenReturn(Optional.of(book));
//        mvc.perform(get("/books/1")).andExpect(view().name(is("books/single")));
//    }
//     
//    @Test
//    public void shouldBeOkForSingleBook() throws Exception {
//    	Long bookId = 1L;
//        when(bookRepo.findById(bookId)).thenReturn(Optional.of(book));
//        mvc.perform(get("/books/1")).andExpect(status().isOk());
//    }
//     
//    @Test
//    public void shouldPutSingleEmployeeIntoModel() throws Exception {
//    	Long bookId = 1L;
//        when(bookRepo.findById(bookId)).thenReturn(Optional.of(book));
//        mvc.perform(get("/books/1")).andExpect(model().attribute("book", is(book)));
//    }
//}