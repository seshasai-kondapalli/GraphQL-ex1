package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Author;
import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;
	
	@Override
	public Post savePost(Post post) {
		// TODO Auto-generated method stub
		return postRepository.save(post);
	}

	@Override
	public List<Post> saveAllPosts(List<Post> posts) {
		// TODO Auto-generated method stub
		return postRepository.saveAll(posts);
	}

	@Override
	public List<Post> findByAuthor(Author author) {
		// TODO Auto-generated method stub
		return postRepository.findByAuthor(author);
	}

}
