package com.wct.animall;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wct.animall.model.Animal;
import com.wct.animall.model.Category;
import com.wct.animall.repository.AnimalRepository;
import com.wct.animall.repository.CategoryRepository;
import com.wct.animall.repository.UserRepository;

@SpringBootApplication
public class SpringbootFirstAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirstAppApplication.class, args);

	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	File image1 = new File("/home/edga/Documents/Dev/Java/SpringBoot/Try/animall/src/main/resources/images/image1.jpg");
	File image2 = new File("/home/edga/Documents/Dev/Java/SpringBoot/Try/animall/src/main/resources/images/image2.jpg");

	@Override
	public void run(String... args) throws Exception {
		/*
		 * User user1 = new User("zefez", "Sam@gmail.com", "z789", "45796523",
		 * "5684268", "dga", "Samar", true, false, true, false, Authority.ROLE_USER);
		 * userRepository.save(user1);
		 * 
		 * User user2 = new User("abc", "def@gmail.com", "emlo", "2881258", "2025505",
		 * "jfp", "alop", true, true, true, true, Authority.ROLE_USER);
		 * userRepository.save(user2);
		 * 
		 * User user3 = new User("abcdede", "dezedzf@gmail.com", "aooeo", "0000000",
		 * "111111", "jfp", "alop", true, true, true, true, Authority.ROLE_USER);
		 * userRepository.save(user3);
		 */

		Animal animal2 = new Animal("black", "female", image2, "husky", "White", 5, 35.7f, 18.6f, 40.4f, true, true);

		animalRepository.save(animal2);
		Category category1 = new Category("Chien", animal2);

		categoryRepository.save(category1);

		Animal animal1 = new Animal("white", "Male", image1, "papip", "pika", 1, 25.5f, 16.5f, 20.6f, false, true);
		animalRepository.save(animal1);

		Category category2 = new Category("Chat", animal1);
		categoryRepository.save(category2);

	}

}
