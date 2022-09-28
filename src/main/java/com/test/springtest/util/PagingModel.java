package com.test.springtest.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PagingModel<T> {
    Long totalItems;
    Integer totalPage;
    Integer currentPage;
    List<T> data;

}
