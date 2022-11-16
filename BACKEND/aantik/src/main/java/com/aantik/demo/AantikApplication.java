package com.aantik.demo;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.aantik.demo.service.FilesStorageService;


@SpringBootApplication
public class AantikApplication {
	
	  @Resource
	  FilesStorageService storageService;
	  
	public static void main(String[] args) {
		SpringApplication.run(AantikApplication.class, args);

		
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8081").allowedMethods("*").allowedHeaders("*");
			}
		};
	}
	
	  public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	  }

}
