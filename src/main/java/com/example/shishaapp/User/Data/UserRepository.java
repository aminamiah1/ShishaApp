package com.example.shishaapp.User.Data;

import com.example.shishaapp.User.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

