package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Author;
import com.example.demo.entity.Post;
import com.example.demo.service.AuthorService;

@SpringBootApplication
public class GraphQlEx1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlEx1Application.class, args);
	}

//	@Bean
//    GraphQLSchema schema() {
//        return GraphQLSchema.newSchema()
//            .query(GraphQLObjectType.newObject()
//                .name("query")
//                .field(field -> field
//                    .name("test")
//                    .type(Scalars.GraphQLString)
//                    .dataFetcher(environment -> "response")
//                )
//                .build())
//            .build();
//    }
	
	@Autowired
	AuthorService authorService;

	@Override
	public void run(String... args) throws Exception {

		List<Author> existedAuthros = authorService.findAllAuthor();
		
		if (Objects.isNull(existedAuthros) || existedAuthros.isEmpty()) {
			List<Author> authros = new ArrayList<>();
			Random random = new Random();
			random.setSeed(1);
			LongStream.range(1, 10).forEach((lc) -> {

				List<Post> posts = new ArrayList<>();

				Author author = new Author();
				author.setName(String.format("author%1$s", lc));
				author.setPosts(posts);

				IntStream.range(1, 20).forEach(ic -> {
					
					Post post = new Post();

					post.setAuthor(author);
					post.setCategory(String.format("Caterory%1$s", ic));
					post.setTitle(String.format("Title %1$s", random.nextInt(100)));
					post.setText(String.format("Text %1$s", random.nextInt(100)));
					author.getPosts().add(post);
				});

				authros.add(author);
			});

			authorService.saveAuthors(authros);

		}

	}

}
