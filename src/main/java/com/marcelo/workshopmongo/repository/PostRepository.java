package com.marcelo.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.marcelo.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleContainingIgnoreCase(String text);

	@Query("{ 'title': <field>: { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	
	@Query("{ $and: [ { date: { $gte: ?1 }, { date: { $lte: ?2 } } , { $or: [ { 'title': <field>: { $regex: ?0, $options: 'i' } }, { 'body': <field>: { $regex: ?0, $options: 'i' } }, ... ,{ 'comments.text': <field>: { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSourcee(String text, Date minDate, Date maxDate);
}