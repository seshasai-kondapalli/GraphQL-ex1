package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	PostService postService;

	@Override
	@Transactional(readOnly = true)
	public List<Author> findAllAuthor() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Author findAuthrById(Long id) {
		// TODO Auto-generated method stub
		return authorRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void saveAuthor(Author author) {
		// TODO Auto-generated method stub
		authorRepository.save(author);
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void saveAuthors(List<Author> authors) {
		// TODO Auto-generated method stub
		authors = authors.stream().map(author -> {

			author.setPosts(postService.saveAllPosts(author.getPosts()));

			return author;
		}).collect(Collectors.toList());
		authorRepository.saveAll(authors).stream().forEach(System.out::println);
	}

}
