package com.marcelo.workshopmongo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.workshopmongo.domain.Post;
import com.marcelo.workshopmongo.repository.PostRepository;
import com.marcelo.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Post findByTitle(String text) {
		return  (Post) repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, java.util.Date min , java.util.Date max) {
		max = new Date(max.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSourcee(text, min, max);
	}
}
