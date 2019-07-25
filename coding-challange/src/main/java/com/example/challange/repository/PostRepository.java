package com.example.challange.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.challange.model.Post;

public interface PostRepository extends CassandraRepository<Post, Integer> {

	Post findById(int id);

}
