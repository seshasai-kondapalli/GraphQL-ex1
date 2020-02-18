package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	

	@Autowired
	private AuthorService authorService;

	@Override
	public Post savePost(Post post) {
		// TODO Auto-generated method stub
		return postRepository.save(post);
	}
	
	

	@Override
	public Post savePost(Post post, Long authorId) {
		// TODO Auto-generated method stub
		
		
		try {
			post.setAuthor(authorService.findAuthrById(authorId));
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new RuntimeException(String.format("author is not found with given id : %1$d ", authorId));
		}
				
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

	@Override
	public List<Post> findAllPosts(int count, int offset) {
		// TODO Auto-generated method stub
		PageRequest page = PageRequest.of(offset, count);

		Page<Post> posts = postRepository.findAll(page);

		return posts.getContent();
	}

}
