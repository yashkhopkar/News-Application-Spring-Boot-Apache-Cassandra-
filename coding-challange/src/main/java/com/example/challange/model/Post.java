package com.example.challange.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	@PrimaryKey
	@PrimaryKeyColumn
	private int id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String author;
	@Column
	private String tags;
	@Column
	private String created_at;
	@Column
	private String updated_at;
	
	public Post(int id, String title, String description, String author, String tags, String created_at,
			String updated_at) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
		this.tags = tags;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public Post() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	
	
	
}
