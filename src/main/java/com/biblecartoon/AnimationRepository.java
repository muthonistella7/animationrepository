package com.biblecartoon;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimationRepository extends MongoRepository<Animation, String> {
    // Custom query methods can be added here
    }
