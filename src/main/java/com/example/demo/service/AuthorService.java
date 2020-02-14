package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Author;

public interface AuthorService {

	List<Author> findAllAuthor();
	
	Author findAuthrById(Long id);
	
	void saveAuthor(Author author);
	
	void saveAuthors(List<Author> authors);
}
