package com.unigram.AuthService;

@SpringBootApplication
@EnableMongoAuditing
@EnableBinding(UserEventStream.class)
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
}