package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "post")
@Data
@ToString(exclude = "author")
@NoArgsConstructor
public class Post {

	@Id
	@SequenceGenerator(name = "post_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_seq")
	@Column(name = "id")
	private Long id;

	@Column(name = "tilte")
	private String title;

	@Column(name = "text")
	private String text;

	@Column(name = "category")
	private String category;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(columnDefinition = "author_id", referencedColumnName = "id", nullable = false)
	private Author author;


}
