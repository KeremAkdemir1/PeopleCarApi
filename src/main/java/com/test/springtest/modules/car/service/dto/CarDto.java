package com.test.springtest.modules.car.service.dto;

import com.test.springtest.common.service.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper=false)
public class CarDto extends BaseDto {
    public String name;
    public String engine;
    public String type;
    public Integer seat;
    public String color;
}