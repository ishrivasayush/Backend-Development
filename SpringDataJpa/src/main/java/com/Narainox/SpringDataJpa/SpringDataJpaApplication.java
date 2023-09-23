package com.Narainox.SpringDataJpa;

import com.Narainox.SpringDataJpa.model.User;
import com.Narainox.SpringDataJpa.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Autowired
	UserDao userDao;

	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		user.setName("Ayush");
		user.setCity("Delhi");

		User user1=new User();
		user1.setName("Abhay");
		user1.setCity("Kanpur");

		User user2=new User();
		user2.setName("Aditi");
		user2.setCity("Noida");

		List<User> users=new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user);

		//userDao.saveAll(users);
		//System.out.println(users);

//		User save = userDao.save(user);
//		System.out.println(save);

		List<User> nameAndCity = userDao.findByNameAndCity("Ayush", "Delhi");
		System.out.println(nameAndCity);



	}
}
