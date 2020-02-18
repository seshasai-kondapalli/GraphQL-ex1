package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
public class Author {

	@Id
	@SequenceGenerator(name = "author_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
	@Column(name = "id")
	private Long id;

	@Column(name = "name", insertable = false, updatable = false)
	private String name;

	@Column(name = "name")
	private String thumbnail;

	@OneToMany(mappedBy = "author")
	private List<Post> posts;

}
