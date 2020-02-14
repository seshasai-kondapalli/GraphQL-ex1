package com.example.demo.config.GraphQLResolvers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.entity.Author;
import com.example.demo.entity.Post;
import com.example.demo.service.AuthorService;

public class PostResolver implements GraphQLResolver<Post> {

	@Autowired
	private AuthorService authorService;

	public Optional<Author> getAuthor(Post post) {
		return Optional.ofNullable(authorService.findAuthrById(post.getAuthor().getId()));
	}

}
