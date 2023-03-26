package com.monika.BookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.monika.BookStore.entity.Book;
import com.monika.BookStore.entity.MyBook;
import com.monika.BookStore.service.BookService;
import com.monika.BookStore.service.MyBookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookService myBookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book> list = service.getAllBook();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bookList");
		mv.addObject("book", list);
		return mv;
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
	}
	
	@GetMapping("/my_book")
	public String getMyBook(Model model) {
		List<MyBook> list = myBookService.getAllMyBook();
		model.addAttribute("book", list);
		return "myBook";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = service.getBookById(id);
		MyBook mb = new MyBook(b.getId(),b.getName(),b.getAuthor(),b.getPrice());  
		myBookService.save(mb);
		return "redirect:/my_book";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b = service.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
}
