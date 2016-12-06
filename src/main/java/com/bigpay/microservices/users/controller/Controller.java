package com.bigpay.microservices.users.controller;

/**
 * Created by akorotenko on 12/5/16.
 */

import com.bigpay.microservices.users.domain.User;
import com.bigpay.microservices.users.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@RestController
public class Controller {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String heartBeat() {
        return "Alive! time : " + System.currentTimeMillis();
    }

    // CRUD

    @RequestMapping(path = "/user/{userName}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userName) {
        return userRepository.findOne(userName);
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public void setUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @RequestMapping(path = "/user/{userName}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String userName) {
        userRepository.delete(userName);
    }

    // GET Balance from YCS (our wrapper)
    @RequestMapping(path = "/user/{userName}/balance")
    public void getUserBalance(@PathVariable String userName) {
        // TBD
    }



}
