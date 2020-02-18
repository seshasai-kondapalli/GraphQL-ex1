package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.config.GraphQLResolvers.mutation.Mutation;
import com.example.demo.config.GraphQLResolvers.query.AuthorResolver;
import com.example.demo.config.GraphQLResolvers.query.PostResolver;
import com.example.demo.config.GraphQLResolvers.query.Query;

@Configuration
public class GraphQlConfigration {

	@Bean
	public AuthorResolver authorResolver() {
		return new AuthorResolver();
	}

	@Bean
	public PostResolver postResolver() {
		return new PostResolver();
	}

	@Bean
	public Query query() {
		return new Query();
	}

	@Bean
	public Mutation mutation() {
		return new Mutation();
	}

}
