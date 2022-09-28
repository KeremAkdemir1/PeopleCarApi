package com.test.springtest.modules.car.mapper;

import com.test.springtest.common.mapper.GenericMapper;
import com.test.springtest.modules.car.api.model.CarRequest;
import com.test.springtest.modules.car.persistence.entity.Car;
import com.test.springtest.modules.car.service.dto.CarDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper extends GenericMapper<CarRequest, CarDto, Car> {
}
