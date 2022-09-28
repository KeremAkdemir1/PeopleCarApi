package com.test.springtest.modules.person.service;

import com.test.springtest.modules.person.api.model.PersonRequest;
import com.test.springtest.modules.person.persistence.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

public interface PersonService {

    Page<Person> getAll(PersonRequest searchRequest, Specification<Person> specification);

    Person createPerson(Person person);

    Person getPersonById(Long id);

    Person updatePerson(Person person);

    void deletePerson(Long id);
}
