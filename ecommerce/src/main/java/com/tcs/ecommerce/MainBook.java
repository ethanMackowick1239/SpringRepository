package com.tcs.ecommerce;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.ecommerce.config.DBConfig;
import com.tcs.ecommerce.model.Book;
import com.tcs.ecommerce.model.Page;
import com.tcs.ecommerce.repository.BookRepository;
import com.tcs.ecommerce.repository.PageRepository;


public class MainBook {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		
		BookRepository bookRepository = context.getBean(BookRepository.class);
		PageRepository pageRepository = context.getBean(PageRepository.class);
		
		Book book = new Book(0, "Java", "James", "Java001", null);
		bookRepository.save(book);
		
		pageRepository.save(new Page(0, 1, "intro", "Babyteps", book));
		pageRepository.save(new Page(0, 1, "Happy", "La lala", book));
		pageRepository.save(new Page(0, 1, "Bla la", "dskdsa", book));


	}

}
