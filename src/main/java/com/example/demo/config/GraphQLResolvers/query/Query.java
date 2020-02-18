package com.example.demo.config.GraphQLResolvers.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.entity.Post;
import com.example.demo.service.PostService;

public class Query implements GraphQLQueryResolver {

	@Autowired
	PostService postService;

	public List<Post> getRecentPosts(int count, int offset) {
		return postService.findAllPosts(count, offset);
	}

}
