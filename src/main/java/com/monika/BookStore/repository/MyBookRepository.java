package com.monika.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monika.BookStore.entity.MyBook;

@Repository
public interface MyBookRepository extends JpaRepository<MyBook, Integer>{

}
