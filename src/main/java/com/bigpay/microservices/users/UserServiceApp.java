package com.bigpay.microservices.users;

import com.bigpay.microservices.users.domain.Card;
import com.bigpay.microservices.users.domain.User;
import com.bigpay.microservices.users.repository.CardRepository;
import com.bigpay.microservices.users.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by akorotenko on 12/5/16.
 */
@SpringBootApplication(scanBasePackages = "com.bigpay.microservices.users")
//@EnableEurekaClient
//@EnableJpaRepositories(basePackages = "com.bigpay.microservices.users.repository")
public class UserServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApp.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }


    @Bean
    public CommandLineRunner demo(UserRepository userRepository, CardRepository cardRepository) {
        return (args) -> {
            // save a couple of users and cards
            User user = new User();
            user.setUserName("id1");
            user.setFirstName("first name 1");
            user.setLastName("last name 1");
            user.setGender("M");

            Set<Card> cards = new HashSet<>();
            cards.add(new Card("1111111111111111", "open", "5000", "", "UAH"));
            cards.add(new Card("2222222222222222", "open", "15000", "", "UAH"));

            user.setCards(cards);
            cardRepository.save(cards);

            userRepository.save(user);

            user = new User();
            user.setUserName("id2");
            user.setFirstName("first name 2");
            user.setLastName("last name 2");
            user.setGender("F");
            user.setTitle("User title");

            cards = new HashSet<>();
            cards.add(new Card("1111111111112222", "open", "50000", "", "UAH"));
            cards.add(new Card("2222222222223333", "open", "19000", "", "USD"));

            user.setCards(cards);
            cardRepository.save(cards);
            userRepository.save(user);

        };
    }
}