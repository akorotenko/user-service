package com.bigpay.microservices.users.repository;

import org.springframework.data.repository.CrudRepository;

import com.bigpay.microservices.users.domain.Card;

/**
 * Created by akorotenko on 12/5/16.
 */
public interface CardRepository extends CrudRepository<Card, String> {
}
