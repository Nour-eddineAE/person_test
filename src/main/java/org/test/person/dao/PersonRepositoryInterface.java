package org.test.person.dao;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.test.person.entities.Person;


public interface PersonRepositoryInterface extends Neo4jRepository<Person, Long> {

}
