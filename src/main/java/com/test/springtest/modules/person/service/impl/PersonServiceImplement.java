package com.test.springtest.modules.person.service.impl;

import com.test.springtest.modules.person.exception.PersonNotFoundException;
import com.test.springtest.modules.person.api.model.PersonRequest;
import com.test.springtest.modules.person.persistence.entity.Person;
import com.test.springtest.modules.person.persistence.repository.PersonRepository;
import com.test.springtest.modules.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImplement implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Page<Person> getAll(PersonRequest searchRequest, Specification<Person> specification) {
        Pageable pageable;
        if(searchRequest.sortDirection){
            pageable =   PageRequest.of(searchRequest.page
                    ,searchRequest.size,
                    Sort.by(Sort.Direction.ASC,
                            searchRequest.sortBy));
        }else {
            pageable =   PageRequest.of(searchRequest.page
                    ,searchRequest.size,
                    Sort.by(Sort.Direction.DESC,
                            searchRequest.sortBy));
        }
        return personRepository.findAll(specification,pageable);
    }

    @Override
    public Person createPerson(Person person) {
       return personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long id) {
       return personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

    @Override
    public Person updatePerson(Person person)
    {
        if (person.getId() == null) {

            throw new PersonNotFoundException();
        }
        Person personDb = personRepository.findById(person.getId())
                .orElseThrow(PersonNotFoundException::new);

        return personRepository.save(personDb);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
