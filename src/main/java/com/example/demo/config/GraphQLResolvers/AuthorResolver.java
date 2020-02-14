package com.example.demo.config.GraphQLResolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.entity.Author;
import com.example.demo.entity.Post;
import com.example.demo.service.PostService;

public class AuthorResolver implements GraphQLResolver<Author> {

	@Autowired
	private PostService postService;

	List<Post> getPosts(Author author) {
		return postService.findByAuthor(author);
	}
}
