package com.qiumingkui.ddd.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qiumingkui.ddd.sample.blog.domain.model.BlogId;
import com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository.jdbc.JdbcBlogRepository;


//@SpringBootApplication
//public class Application implements CommandLineRunner{
//
//	@Autowired
//	JdbcBlogRepository blogRepository;
//
//	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
////		application.blogRepository.get(new BlogId("1"));
//	}
//
//	@Override
//	public void run(String... arg0) throws Exception {
//		
//		System.out.print("run...");		
//	}
//
//}

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}