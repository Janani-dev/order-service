package com.oms.order;

import com.oms.order.entities.LoginUser;
import com.oms.order.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepository userRepository) {
		return (ApplicationArguments args) ->  dataSetup(userRepository);
	}

	private void dataSetup(UserRepository userRepository) {
		LoginUser test = new LoginUser("test", "$2a$10$3GXIInSL0cXDVcRZfjqLreYVCL13wq8.hq1YyL9YpHFX3rDYce/Hu", "User");
		userRepository.save(test);
	}
}
