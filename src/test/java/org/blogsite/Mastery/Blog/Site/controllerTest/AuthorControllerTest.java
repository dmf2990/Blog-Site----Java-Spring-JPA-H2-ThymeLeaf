package org.blogsite.Mastery.Blog.Site.controllerTest;

public class AuthorControllerTest {

}

//
//package org.wecancodeit.publishinghouse.controllers;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.ui.Model;
//import org.wecancodeit.publishinghouse.models.Book;
//import org.wecancodeit.publishinghouse.repositories.BookRepository;
//
//public class BookControllerTest {
//	 
//    @InjectMocks
//    private BookController underTest;
// 
//    @Mock
//    private BookRepository bookRepo;
// 
//    @Mock
//    private Book book;
//    
//	@Mock
//	private Model model;
// 
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//    
//    @Test
//    public void shouldAddBookToModel() throws Exception {
//        Long bookId = 1L;
//        when(bookRepo.findById(bookId)).thenReturn(Optional.of(book));
// 
//        underTest.getBook(bookId, model);
// 
//        verify(model).addAttribute("book", book);
//    }
//}