package com.marcelo.workshopmongo.service;

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
}
