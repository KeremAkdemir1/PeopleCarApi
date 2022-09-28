package com.test.springtest.common.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageDto<T> {
    private Integer totalItems;
    private Integer totalPage;
    private Integer currentPage;
    private List<T> data;
}