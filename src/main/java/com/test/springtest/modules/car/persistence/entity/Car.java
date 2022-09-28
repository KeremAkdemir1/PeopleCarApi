package com.test.springtest.modules.car.persistence.entity;


import com.test.springtest.common.persistence.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Table(name = "Cars")
@Entity
@Getter
@Setter
public class Car extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id" ,nullable = false)
    public Long id;

    @Column(name = "CarName" ,nullable = false)
    public String name;

    @Column(name = "Engine" ,nullable = false)
    public String engine;

    @Column(name = "Type" ,nullable = false)
    public String type;

    @Column(name = "Seat" ,nullable = false)
    public Integer seat;

    @Column(name = "Color", nullable = false)
    public String color;
}
