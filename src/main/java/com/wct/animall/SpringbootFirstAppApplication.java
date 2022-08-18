package com.wct.animall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wct.animall.model.Animal;
import com.wct.animall.model.User;
import com.wct.animall.repository.AnimalRepository;
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

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("zefez", "Sam@gmail.com", "z789", "45796523", "5684268", "dga", "Samar", true, false,
				true, false);
		userRepository.save(user1);

		User user2 = new User("abc", "def@gmail.com", "emlo", "2881258", "2025505", "jfp", "alop", true, true, true,
				true);
		userRepository.save(user2);

		User user3 = new User("abcdede", "dezedzf@gmail.com", "aooeo", "0000000", "111111", "jfp", "alop", true, true,
				true, true);
		userRepository.save(user3);

		Animal animal1 = new Animal("white", "Male", "zejzeozfe", "papip", "pika", 1, 25.5f, 16.5f, 20.6f, false, true);
		animalRepository.save(animal1);

	}

}
