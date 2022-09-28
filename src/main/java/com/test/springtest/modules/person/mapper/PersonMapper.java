package com.test.springtest.modules.person.mapper;

import com.test.springtest.common.mapper.GenericMapper;
import com.test.springtest.modules.person.api.model.PersonRequest;
import com.test.springtest.modules.person.persistence.entity.Person;
import com.test.springtest.modules.person.service.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper extends GenericMapper<PersonRequest, PersonDto, Person> {
}