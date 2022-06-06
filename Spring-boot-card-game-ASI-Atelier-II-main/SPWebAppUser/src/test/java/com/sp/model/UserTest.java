package com.sp.model;


import com.sp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserTest {
	
	@Autowired
	private UserRepository uRepository;

	 @Test
	    public void createUserModel() {
		 uRepository.save(new User(1,"silia", "taider", "mdp",500));
		 Optional<User> u= uRepository.findById(1);
		 assertTrue(u.get().getName().equals("silia"));
	    }

}

