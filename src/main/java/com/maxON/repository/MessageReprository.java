package com.maxON.repository;

import com.maxON.domain.Message;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MessageReprository extends CrudRepository<Message, Integer> {

}