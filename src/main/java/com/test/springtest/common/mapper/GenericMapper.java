package com.test.springtest.common.mapper;

import com.test.springtest.common.model.BaseRequest;
import com.test.springtest.common.persistence.entity.BaseEntity;
import com.test.springtest.common.service.dto.BaseDto;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface GenericMapper<R extends BaseRequest, D extends BaseDto, E extends BaseEntity> {
    D convert(E entity);

    R convert(D dto);

    D convert(R request);

    E convertToEntity(D dto);

    E convertToEntity(R request);

    List<D> convert(List<E> entities);

    List<E> convertToEntityList(List<R> requestList);

    void convert(R request, @MappingTarget E entity);

}
