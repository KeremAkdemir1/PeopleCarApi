package com.test.springtest.modules.person.api;

import com.test.springtest.modules.person.api.model.PersonRequest;
import com.test.springtest.modules.person.mapper.PersonMapper;
import com.test.springtest.modules.person.persistence.entity.Person;
import com.test.springtest.modules.person.persistence.specification.PersonSpecification;
import com.test.springtest.modules.person.service.PersonService;
import com.test.springtest.modules.person.service.dto.PersonDto;
import com.test.springtest.util.PagingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonApi {
    @Autowired
   private PersonMapper personMapper;
    @Autowired
   private PersonService personService;



    @PostMapping("/search")
    public ResponseEntity<PagingModel<PersonDto>> getAll(@RequestBody PersonRequest request){
        Page pageData = personService.getAll(
                request,
                PersonSpecification.search(request)
        );

        PagingModel personPage = new PagingModel();
        personPage.setTotalItems(pageData.getTotalElements());
        personPage.setCurrentPage(pageData.getNumber());
        personPage.setTotalPage(pageData.getTotalPages());
        personPage.setData(personMapper.convert(pageData.getContent()));

        return new ResponseEntity(personPage,new HttpHeaders(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonDto> save(@RequestBody PersonRequest personRequest){
        return new ResponseEntity(personService.createPerson(personMapper.convertToEntity(personRequest)),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable Long id){
        return new ResponseEntity<>(personMapper.convert(personService.getPersonById(id))
                ,new HttpHeaders(),
                HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PersonDto> updatePerson(@RequestBody PersonRequest personRequest){
        Person person = personService.getPersonById(personRequest.id);

        personMapper.convert(personRequest,person);

        return new ResponseEntity<>(personMapper.convert(personService.updatePerson(person))
                ,new HttpHeaders(),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }
}
