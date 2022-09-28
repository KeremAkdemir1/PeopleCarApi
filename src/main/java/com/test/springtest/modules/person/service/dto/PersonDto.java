package com.test.springtest.modules.person.service.dto;

import com.test.springtest.common.service.dto.BaseDto;
import com.test.springtest.modules.car.persistence.entity.Car;
import com.test.springtest.modules.car.service.dto.CarDto;
import com.test.springtest.modules.person.persistence.entity.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;




@EqualsAndHashCode(callSuper=false)
public class PersonDto extends BaseDto {
    public String name;

    public Integer age;

    public Boolean sick;

    public Boolean hasLicense;

    public Boolean married;

    public List<Car> cars;
}