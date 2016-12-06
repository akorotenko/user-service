package com.bigpay.microservices.users.repository;

import com.bigpay.microservices.users.domain.User;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by akorotenko on 12/5/16.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
