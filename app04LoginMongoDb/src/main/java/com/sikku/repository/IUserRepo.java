package com.sikku.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sikku.document.User;

@Repository
public interface IUserRepo extends MongoRepository<User, String> {

}
