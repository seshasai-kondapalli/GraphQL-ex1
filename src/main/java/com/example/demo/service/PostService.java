package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Author;
import com.example.demo.entity.Post;

public interface PostService {
	
	Post savePost(Post post);
	
	Post savePost(Post post, Long authorId);

	List<Post> saveAllPosts(List<Post> posts);
	
	List<Post> findByAuthor(Author author);
	
	List<Post> findAllPosts(int count, int offset);
	
}
