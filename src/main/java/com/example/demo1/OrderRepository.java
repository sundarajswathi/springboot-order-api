package com.example.demo1;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository  extends MongoRepository<OrderDataModel,String>{
    
}
