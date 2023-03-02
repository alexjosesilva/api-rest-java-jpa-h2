package com.techinterface.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techinterface.models.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
