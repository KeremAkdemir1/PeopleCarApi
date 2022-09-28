package com.test.springtest.modules.car.api.model;

import com.test.springtest.common.model.BaseRequest;

import javax.persistence.Column;

public class CarRequest extends BaseRequest {

    public String name;
    public String engine;
    public String type;
    public Integer seat;
    public String color;

}
