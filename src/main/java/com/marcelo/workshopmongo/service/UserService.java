package com.marcelo.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.workshopmongo.domain.User;
import com.marcelo.workshopmongo.dto.UserDTO;
import com.marcelo.workshopmongo.repository.UserRepository;
import com.marcelo.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objdto) {
		return new User(objdto.getId(),objdto.getName(),objdto.getEmail());
	}

}
