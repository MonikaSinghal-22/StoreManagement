package com.monika.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monika.BookStore.entity.MyBook;
import com.monika.BookStore.repository.MyBookRepository;

@Service
public class MyBookService {

	@Autowired
	private MyBookRepository mbRepo;
	
	public void save(MyBook mybook) {
		mbRepo.save(mybook);
	}
	
	public List<MyBook> getAllMyBook(){
		return mbRepo.findAll();
	}
	
	public void deleteById(int id) {
		mbRepo.deleteById(id);
	}
}
