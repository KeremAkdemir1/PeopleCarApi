package com.test.springtest.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

public class BaseRequest implements Serializable {

    public Integer page = 0;
    public Integer size = 15;
    public String sortBy = "id";
    public Boolean sortDirection = true;
    public Long id = null;

}
