package com.example.demo.config.GraphQLResolvers.mutation;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.entity.Post;
import com.example.demo.service.PostService;

public class Mutation implements GraphQLMutationResolver {

	@Autowired
	private PostService postService;


	public Post writePost(String title, String text, String category, Long authorId) {
		

		Post newPost = new Post();
		newPost.setTitle(title);
		newPost.setText(text);
		newPost.setCategory(category);		

		return postService.savePost(newPost, authorId);
	}
}
