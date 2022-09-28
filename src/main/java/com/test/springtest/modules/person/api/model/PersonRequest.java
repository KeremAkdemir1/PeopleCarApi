package com.test.springtest.modules.person.api.model;

import com.test.springtest.common.model.BaseRequest;
import com.test.springtest.modules.car.persistence.entity.Car;
import com.test.springtest.modules.car.service.dto.CarDto;
import com.test.springtest.modules.person.persistence.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper=false)
public class PersonRequest extends BaseRequest {

    public String name;

    public Integer age;

    public Boolean sick;

    public Boolean hasLicense;

    public Boolean married;

    public List<Car> cars;
}
