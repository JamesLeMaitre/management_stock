package com.mtj.receipt_management.utils;

import com.mtj.receipt_management.entities.Receipts;
import com.mtj.receipt_management.models.ReceiptDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public  class JavaUtils {
    public <E, D> D entityToDTO(E entity, Class<D> dtoClass) {
        D dto = BeanUtils.instantiateClass(dtoClass);
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public <E, D> E dtoToEntity(D dto, Class<E> entityClass) {
        E entity = BeanUtils.instantiateClass(entityClass);
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
