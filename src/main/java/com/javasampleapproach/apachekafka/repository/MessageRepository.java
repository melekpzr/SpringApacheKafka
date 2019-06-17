package com.javasampleapproach.apachekafka.repository;

import com.javasampleapproach.apachekafka.model.Messagedb;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Messagedb, Integer> {
}
