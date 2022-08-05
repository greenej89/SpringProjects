package com.codingdojo.relationships.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.relationships.models.Person;
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	ArrayList<Person> findAll();
	Optional<Person> findById(Long id);
	
	//
	@Query(value = "SELECT * FROM persons LEFT JOIN licenses ON persons.id = licenses.person_id WHERE person_id IS NULL",
			nativeQuery = true)
	ArrayList<Person> findAllPersonsWithoutLicense();
}
